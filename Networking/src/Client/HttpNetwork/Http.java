package Client.HttpNetwork;

import java.io.IOException;
import java.net.URL;

public class Http {
    public static void main(String[] args){
        try {
            URL url= new URL("https://www.facebook.com/thala.vinay.3");
            URLInfo info= new URLInfo(url);
            System.out.println(info.readData());
            info.getHeaderFeilds();
        }catch(IOException e){
            System.out.println("Cant connect to web: "+ e.getMessage());
        }
    }
}
