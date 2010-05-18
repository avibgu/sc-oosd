package gui.workers;

import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.SwingWorker;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class GetHTMLWorker extends SwingWorker<Void, Void>{

	private JEditorPane _htmlPnael;

	private String _url;

	public GetHTMLWorker(JEditorPane htmlPnael, String url){

		this._htmlPnael = htmlPnael;
		this._url = url;
	}

	protected Void doInBackground() throws Exception {

		StyleSheet ss = new StyleSheet();

		ss.importStyleSheet( new URL(this._url) );

		HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
		htmlEditorKit.setStyleSheet( ss );

		this._htmlPnael.setEditorKit( htmlEditorKit );

		this._htmlPnael.setPage( _url );

		return null;
	}

//	protected void done(){}
}
