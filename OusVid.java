import java.io.*;
import java.util.Scanner;


public class OusVid {

	public static void main (String [] args) {
		// First, create user input grabber tool
		Scanner readlink = new Scanner (System.in);
		// Ask user to input the YouTube link
		// of the video they would like to download
		System.out.println ("Wee mzee weka link hapa 😂: ");
		// Store that link as String in the memory
		String ytlink = readlink.nextLine ();
		// Now give them whatever they requested
		ousVidDownloader (ytlink);
	}

	public static void ousVidDownloader (String url) {

		try {
			ProcessBuilder builder = new ProcessBuilder (
					"yt-dlp", "-o", "% (title)s.% (ext)s", url);
			builder.redirectErrorStream (true);
			Process process = builder.start ();

			BufferedReader reader = new BufferedReader (new InputStreamReader (process.getInputStream ()));
			String ytlink;
			while ((ytlink = reader.readLine ()) != null) {
				System.out.println (ytlink);
			}

			process.waitFor ();
			System.out.println ("Hell yeah, the download is complete!");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace ();
		}
	}
}
