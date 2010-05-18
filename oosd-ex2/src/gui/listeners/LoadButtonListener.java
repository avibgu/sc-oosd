package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

import gui.*;

import plugin.PluginWrapper;

public class LoadButtonListener implements ActionListener {

	private ListSelectionListener m_Gui;

	private JList m_items;


	public LoadButtonListener(ListSelectionListener gui, JList items){
		this.m_Gui = gui;
		this.m_items = items;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		JFileChooser tDlg = new JFileChooser(".");

        tDlg.setFileFilter( new FileFilter() {

            public boolean accept(File f) {

                return f.isDirectory() || f.getName().endsWith(".jar");
            }

            public String getDescription() { return "Jar files"; }
        });

        int tRes = tDlg.showOpenDialog( new JFrame() );

        if (tRes == JFileChooser.APPROVE_OPTION) {

            File tFile = tDlg.getSelectedFile();

            try{

                PluginWrapper tWrap = new PluginWrapper(tFile);
                if(tWrap.getView() == "Items"){
                	JList newItems = (JList)tWrap.getComponent(tFile);
                	setItems(newItems);
                	this.m_items.addListSelectionListener(this.m_Gui);

                }
                // getPluginsMap().put(tWrap.getExt(), tWrap);
            }
            catch (Exception e1) {

            	JOptionPane.showMessageDialog(
            			new JFrame(), e1.getMessage(), "Cannot load plugin", JOptionPane.ERROR_MESSAGE);
            }
        }

	}

	public void setItems(JList items){
		this.m_items = items;
	}


}
