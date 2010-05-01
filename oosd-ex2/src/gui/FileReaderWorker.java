package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class FileReaderWorker extends SwingWorker<Void, String> {

	private File _file;
	private JTextArea _text;
	
	public FileReaderWorker(File tFile, JTextArea content) {

		this.setFile(tFile);
		this.setText(content);
	}

	public void setFile(File _file) {
		
		this._file = _file;
	}

	public File getFile() {
		
		return _file;
	}

	public void setText(JTextArea _text) {
		
		this._text = _text;
	}

	public JTextArea getText() {
		
		return _text;
	}
	
	protected Void doInBackground() throws Exception {

		try{
			
			BufferedReader tIn = new BufferedReader(new FileReader(getFile()));
			
			String tLine;
			
			while ((tLine = tIn.readLine()) != null){
				
				publish(tLine);
			}
			
			tIn.close();
		}
		catch (IOException e) {
			
			publish(e.getMessage());
		}
		
		return null;
	}
	
	protected void process(List<String> chunks) {
		
		for (String tLine : chunks) {
		
			getText().append(tLine + "\n");
		}
	}
		
	protected void done() {
		
		getText().setCaretPosition(0);
	}
}
