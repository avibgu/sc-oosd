//public class WriteToFile {
//
//	public WriteToFile(){}
//
//	private String promptFile() throws AbortException {
//
//		//TODO
//		System.out.println("Please insert filename:");
//
//		BufferedReader tIn = new BufferedReader( new InputStreamReader(System.in));
//
//		try {
//
//			String tFilename = tIn.readLine();
//
//			if (tFilename == null || tFilename.isEmpty())
//
//					throw new AbortException();
//
//			return tFilename;
//		}
//		catch (IOException e) {
//
//			throw new AbortException();
//		}
//	}
//
//
//	public void writeToFile() throws GiveUpException {
//
//		//TODO
//		while (true) {
//
//			try {
//
//				String tFilename = promptFile();
//
//				try {
//
//					PrintWriter tOut = new PrintWriter(
//											new FileWriter(new File(tFilename)));
//
//					tOut.println("Hello, World");
//
//					tOut.close();
//
//					return;
//			}
//			catch (IOException e) {
//
//				reportError();
//				continue;
//			}
//			catch (AbortException e) {
//
//				reportGiveUp();
//				throw new GiveUpException();
//			}
//	}
//
//	public void writeToFile(String tFilename) throws GiveUpException {
//
//		//TODO
//		while (true) {
//
//			try {
//
//					if ( tFilename == null || tFilename.isEmpty() )
//
//						tFilename = promptFile();
//
//				try {
//
//					PrintWriter tOut = new PrintWriter(
//											new FileWriter(new File(tFilename)));
//
//					tOut.println("Hello, World");
//
//					tOut.close();
//
//					return;
//				}
//				catch (IOException e) {
//
//					reportError();
//					continue;
//				}
//			}
//			catch (AbortException e) {
//
//				reportGiveUp();
//				throw new GiveUpException();
//			}
//	}
//
//	private void reportError(){
//
//		// TODO
//		System.out.println("error");
//	}
//
//	private void reportGiveUp(){
//
//		// TODO
//		System.out.println("give up");
//	}
//}