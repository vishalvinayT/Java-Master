package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class LowLevelServer implements Runnable  {
    private Socket socket;

    public LowLevelServer(Socket socket) {
        this.socket=socket;
    }



    @Override
    public void run(){}



    public void sendInfo(Object message) throws IOException{
        if(socket!=null){
            PrintWriter output= new PrintWriter(socket.getOutputStream(),true);
            output.println(message);
        }else{
            System.out.println("Server not connected");
        }
    }

    public void recieveInfo() throws IOException{
        if( socket!=null){

            BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Object message= reader.readLine();
            System.out.println("message: "+ message);

        }
    }


    public void endServer(){
        try{
            socket.close();
        }catch(IOException e){
            System.out.println("Server Closed successfully");
        }
    }
}
