package gui.workers;

import javax.swing.JEditorPane;
import javax.swing.SwingWorker;

public class GetHTMLWorker extends SwingWorker<Void, Void>{

	private JEditorPane _htmlPnael;
	
	private String _url;

	public GetHTMLWorker(JEditorPane htmlPnael, String url){
		
		this._htmlPnael = htmlPnael;
		this._url = url;
	}
	
	protected Void doInBackground() throws Exception {
		
		this._htmlPnael.setPage( _url );
		
		return null;
	}
	
//	protected void done(){}
}
