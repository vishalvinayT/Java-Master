package Client.HttpNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URLInfo {
    private URL url;
    private URLConnection connection;

    // other way

    private HttpURLConnection httpURLConnection;


    public URLInfo(URL url) throws IOException {
        this.url=url;
        this.connection=(HttpURLConnection) url.openConnection();
        connection.connect();

    }

    public String readData(){
        try{
            BufferedReader reader=  new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder= new StringBuilder();
            String value;
            do{
                value= reader.readLine();
                builder.append(value);
            }while(value!=null);

            return builder.toString();
        }catch(IOException e){
            System.out.println("cant read");
        }
        return null;
    }


    public void getHeaderFeilds(){
        Map<String, List<String>> headers= connection.getHeaderFields();
        for(Map.Entry<String,List<String>> iter: headers.entrySet()){
            System.out.println("Key: "+ iter.getKey()+" Value: "+ iter.getValue());
        }
    }
}
