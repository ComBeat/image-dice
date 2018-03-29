//import java.lang.ProcessBuilder;
import java.io.*;
import java.util.*;

public class dice {
public static void main(String[] args){
        Random rand = new Random();

        String cmd = "cmd.exe /c taskkill -im rundll32.exe";
        String home = System.getProperty("user.home");
        String img1 = home+"\\Nextcloud\\63740442_p0.png";
        String img2 = home+"\\Nextcloud\\c7906b68f44be6e1aac7357dd54e520b.jpg";
        String img3 = home+"\\Nextcloud\\wallhaven-384721.png";
        String viewer = "rundll32 \"C:\\Program Files (x86)\\Windows Photo Viewer\\PhotoViewer.dll\", ImageView_Fullscreen ";
        String expr;
        int random = rand.nextInt(3)+1;

        try{
          Runtime.getRuntime().exec(cmd);
        } catch(IOException e){
          System.out.println(e);
        }

        if(random==1) {
                try{
                        expr = viewer + img1;
                        Runtime.getRuntime().exec(expr);
                } catch(IOException e) {
                        System.out.println(e);
                }
        } else if(random==2) {
                try{
                        expr = viewer + img2;
                        Runtime.getRuntime().exec(expr);
                } catch(IOException e) {
                        System.out.println(e);
                }
        } else if(random==3) {
                try{
                        expr = viewer + img3;
                        Runtime.getRuntime().exec(expr);
                } catch(IOException e) {
                        System.out.println(e);
                }
        }
}
}
