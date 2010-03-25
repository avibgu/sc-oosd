package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import exception.AbortException;
import exception.GiveUpException;

public class FileHandling {

	public FileHandling(){}
	
	public File openFileForReading(String tFilename) throws GiveUpException {
		
		File file = null;
		
		while (true) {

			try {
				
				if ( tFilename == null || tFilename.isEmpty() )

					tFilename = promptFile();

				file = new File(tFilename);

				return file;
			}
			catch (AbortException e) {

				reportGiveUp();
				throw new GiveUpException();
			}
		}
	}

	private String promptFile() throws AbortException {

		System.out.println("Please insert file name:\n");

		BufferedReader tIn = new BufferedReader( new InputStreamReader(System.in));

		try {

			String tFilename = tIn.readLine();

			if (tFilename == null || tFilename.isEmpty())

					throw new AbortException();

			return tFilename;
		}
		catch (IOException e) {

			throw new AbortException();
		}
	}

	public void writeToFile(String tFilename, String toWrite) throws GiveUpException {

		while (true) {

			try {

				if ( tFilename == null || tFilename.isEmpty() )

					tFilename = promptFile();

				try {

					PrintWriter tOut = new PrintWriter(
											new FileWriter(new File(tFilename)));

					tOut.print(toWrite);

					tOut.close();

					return;
				}
				catch (IOException e) {

					reportError();
					continue;
				}
			}
			catch (AbortException e) {

				reportGiveUp();
				throw new GiveUpException();
			}
		}
	}

	private void reportError(){

		// TODO
		System.out.println("error");
	}

	private void reportGiveUp(){

		// TODO
		System.out.println("give up");
	}
}