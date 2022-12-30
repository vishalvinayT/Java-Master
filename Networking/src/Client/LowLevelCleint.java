package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class LowLevelCleint {

    private Socket socket;

    private String ip;
    private int port;

    public LowLevelCleint(String ip, int port){
        this.ip=ip;
        this.port=port;
        try {
            socket= new Socket(ip, port);
        }catch(IOException e){
            System.out.println("Cant connect to server");
        }
    }

    public void recieveData() throws IOException  {
        try{
            BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String meassage= reader.readLine();
            System.out.println("Meassage from server: " +meassage);
        }catch (SocketTimeoutException e){
            System.out.println("Server Timed Out from Clien side");
        }

    }

    public void sendData(String message) throws IOException{
        PrintWriter write= new PrintWriter(socket.getOutputStream(),true);
        write.println(message);
    }
}
