package Server;


import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class LowLevelUDP implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket packet;


    public LowLevelUDP(DatagramSocket socket) {
        this.socket=socket;
    }



    @Override
    public void run(){}



    public void sendInfo(String message) throws IOException {
        if(socket!=null){
            String value="echo: "+ message.toUpperCase();
            byte[] data= value.getBytes();
            DatagramPacket packetSend= new DatagramPacket(data, data.length,packet.getAddress(),packet.getPort());
            socket.send(packetSend);
        }else{
            System.out.println("Server not connected");
        }
    }

    public String recieveInfo() throws IOException{
        if( socket!=null){
            byte[] message = new byte[50];
            packet= new DatagramPacket(message, message.length);
            socket.receive(packet);
            String value= new String(message, 0, packet.getLength());
            System.out.println("message from client: "+ value);
            return value;
        }
        return null;
    }

}
