package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class LowLevelClientUDP {
    private DatagramSocket socket;
    private DatagramPacket packet;

    private InetAddress address;


    public LowLevelClientUDP(InetAddress address,DatagramSocket socket) {
        this.socket=socket;
        this.address=address;
    }





    public void sendInfo(String message) throws IOException {
        if(socket!=null){
            byte[] data= message.getBytes();
            DatagramPacket packetSend= new DatagramPacket(data, data.length,address,7009);
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
            System.out.println("message from server: "+ value);
            return value;
        }
        return null;
    }


}
