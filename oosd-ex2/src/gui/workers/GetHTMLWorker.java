package gui.workers;

import java.net.URL;

import javax.print.attribute.DocAttribute;
import javax.print.attribute.HashDocAttributeSet;
import javax.swing.JEditorPane;
import javax.swing.SwingWorker;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.CSS;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.swing.text.html.CSS.Attribute;

public class GetHTMLWorker extends SwingWorker<Void, Void>{

	private JEditorPane _htmlPnael;

	private String _url;

	public GetHTMLWorker(JEditorPane htmlPnael, String url){

		this._htmlPnael = htmlPnael;
		this._url = url;
	}

	protected Void doInBackground() throws Exception {

		StyleSheet ss = new StyleSheet();

		//ss.importStyleSheet( new URL(this._url) );
		
		Attribute[] atts = CSS.getAllAttributeKeys();
		
		//ss.addAttributes( ss.getEmptySet(), atts );

		HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
		htmlEditorKit.setStyleSheet( ss );

		this._htmlPnael.setEditorKit( htmlEditorKit );

		this._htmlPnael.setPage( _url );

		return null;
	}

//	protected void done(){}
}
