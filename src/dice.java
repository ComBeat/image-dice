
//import java.lang.ProcessBuilder;
import java.io.*;
import java.util.*;

public class dice {
    public static void main(String[] args) {
        Random rand = new Random();
        int random = rand.nextInt(3) + 1;
        String abs_img1 = "";
        String abs_img2 = "";
        String abs_img3 = "";
        String expr = "";
        String home = System.getProperty("user.home");
        String img1 = "63740442_p0.png";
        String img2 = "c7906b68f44be6e1aac7357dd54e520b.jpg";
        String img3 = "wallhaven-384721.png";
        String kill_cmd = "";
        String os = System.getProperty("os.name");
        String viewer = "";

        // determine which os is being used
        if (os.equals("Windows 10")) {
            kill_cmd = "cmd.exe /c taskkill -im rundll32.exe";
            abs_img1 = home + "\\Nextcloud\\Images\\" + img1;
            abs_img2 = home + "\\Nextcloud\\Images\\" + img2;
            abs_img3 = home + "\\Nextcloud\\Images\\" + img3;
            viewer = "rundll32 \"C:\\Program Files (x86)\\Windows Photo Viewer\\PhotoViewer.dll\", ImageView_Fullscreen ";
        } else if (os.equals("Linux")) {
            kill_cmd = "pkill eog";
            abs_img1 = home + "/Nextcloud/Images/" + img1;
            abs_img2 = home + "/Nextcloud/Images/" + img2;
            abs_img3 = home + "/Nextcloud/Images/" + img3;
            viewer = "eog ";
        } else {
            System.out.println("Currently not supported");
        }

        try {
            // kill all running processes of PhotoViewer
            Runtime.getRuntime().exec(kill_cmd);

            // execution of the PhotoViewer with chosen image
            switch (random) {
            case 1: {
                expr = viewer + abs_img1;
                break;
            }
            case 2: {
                expr = viewer + abs_img2;
                break;
            }
            case 3: {
                expr = viewer + abs_img3;
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
