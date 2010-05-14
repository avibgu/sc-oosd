package plugin;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginWrapper {

	private Object _plugin;
	private Method _method;
	private String _ext;

    private String getAttr(Attributes attrs, String key) {
        return (String) attrs.get(new Attributes.Name(key));
    }

    public PluginWrapper(File file) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
		JarFile tJar = new JarFile(file);
		Manifest tManifest = tJar.getManifest();
		Attributes tAttrs = tManifest.getMainAttributes();
		String tClassName = getAttr(tAttrs, "Browser-Plugin-Class");
		String tMethodName = getAttr(tAttrs, "Browser-Plugin-Method");
		setExt(getAttr(tAttrs, "Browser-Plugin-Ext"));
		URL tURL = file.toURI().toURL();
		URL[] tPath = new URL[] { tURL };
		ClassLoader tLoader = new URLClassLoader(tPath);
		Class tClass = tLoader.loadClass(tClassName);
		setPlugin(tClass.newInstance());
		Class[] tArgTypes = new Class[] { File.class };
		setMethod(tClass.getMethod(tMethodName, tArgTypes));
		if (!Component.class.isAssignableFrom(getMethod().getReturnType())) {
			throw new NoSuchMethodException(getMethod().getName());
		}
	}

	public Component getComponent(File file) throws InvocationTargetException, IllegalAccessException {
		Object[] tArgs = { file };
		return (Component) getMethod().invoke(getPlugin(), tArgs);
	}

	public String getExt() {
		return _ext;
	}

	public void setExt(String ext) {
		_ext = ext;
	}

    private Object getPlugin() {
        return _plugin;
    }

    private void setPlugin(Object plugin) {
        _plugin = plugin;
    }

    private Method getMethod() {
        return _method;
    }

    private void setMethod(Method method) {
        _method = method;
    }

}
