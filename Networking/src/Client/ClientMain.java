package Client;


import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket=new DatagramSocket();
            LowLevelClientUDP clientUDP= new LowLevelClientUDP(address,socket);
            String message=null;
            do{
                System.out.println("Enter something udp client");
                Scanner scanner= new Scanner(System.in);
                message=scanner.nextLine();
                clientUDP.sendInfo(message);
                clientUDP.recieveInfo();
            }while(!message.equals("exit"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }


//        String message=null;
//        LowLevelCleint client= new LowLevelCleint("localhost",7007);
//        do{
//            try{
//                System.out.println("Enter something from Client");
//                Scanner scanner = new Scanner(System.in);
//                message=scanner.nextLine();
//                client.sendData(message);
//                client.recieveData();
//            }catch (IOException e){
//                System.out.println("Something went wrong");
//            }
//        }while (!message.equals("exit"));

        }

}
