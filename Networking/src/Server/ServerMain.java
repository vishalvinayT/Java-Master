package Server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        try {
            DatagramSocket socketUDP= new DatagramSocket(7009);
            while(true){
                Thread t=new Thread(new LowLevelUDP(socketUDP){
                    @Override
                    public void run(){
                        try{
                            String message=recieveInfo();
                            sendInfo(message);
                        }catch (IOException r){
                            System.out.println("Something happend in the getting messages");
                        }

                    }
                });

                t.start();

            }

        }catch(IOException e){
            System.out.println("opps cant connect");
        }



        Socket socket=null;
        ServerSocket serverSocket=null;
        try{
            serverSocket= new ServerSocket(7007);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Client Connected!!");
        while (true){
            try {
                Thread thread=new Thread(new LowLevelServer(serverSocket.accept()) {
                    @Override
                    public void run() {
                        try {
                            recieveInfo();
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Enter Something from server");
                            String value= scanner.nextLine();
                            sendInfo(value);
                        }catch (IOException e){
                            System.out.println("Somethong went wrong internally");
                        }

                    }
                });
                thread.start();
            }catch (IOException a){
                System.out.println("Something went Wrong");
            }




        }
    }
}