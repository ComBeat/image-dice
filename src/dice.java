
//import java.lang.ProcessBuilder;
import java.io.*;
import java.util.*;

public class dice {
	public static void main(String[] args) {
		Random rand = new Random();
		int random = rand.nextInt(3);
		ArrayList<String> absImg = new ArrayList<>();
		String expr = "";
		String home = System.getProperty("user.home");
		String[] imgStrings = { "Z55fNk7.jpg", "c7906b68f44be6e1aac7357dd54e520b.jpg", "wallhaven-384721.png" };
		String kill_cmd = "";
		String os = System.getProperty("os.name");
		String viewer = "";

		// determine which os is being used
		if (os.equals("Windows 10")) {
			kill_cmd = "cmd.exe /c taskkill -im rundll32.exe";
			for (String s : imgStrings)
				absImg.add(home + "\\Nextcloud\\Images\\" + s);
			viewer = "rundll32 \"C:\\Program Files (x86)\\Windows Photo Viewer\\PhotoViewer.dll\", ImageView_Fullscreen ";
		} else if (os.equals("Linux")) {
			kill_cmd = "pkill eog";
			for (String s : imgStrings)
				absImg.add(home + "/Nextcloud/Images/" + s);
			viewer = "eog ";
		} else {
			System.err.println("Currently not supported");
		}

		try {
			// kill all running processes of PhotoViewer
			Runtime.getRuntime().exec(kill_cmd);

			// execution of the PhotoViewer with chosen image
			switch (random) {
			case 0: {
				expr = viewer + absImg.get(0);
				break;
			}
			case 1: {
				expr = viewer + absImg.get(1);
				break;
			}
			case 2: {
				expr = viewer + absImg.get(2);
				break;
			}
			default:
				System.out.println("This could be your ad");
			}

			Runtime.getRuntime().exec(expr);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
