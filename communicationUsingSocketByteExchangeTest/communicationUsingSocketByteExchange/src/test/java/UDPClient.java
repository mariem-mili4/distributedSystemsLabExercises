import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        int i = 8;
        byte[] b = (i+"").getBytes();
        InetAddress ia=   InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b,b.length,ia,9999) ;
        ds.send(dp);

        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
        ds.receive(dp1);

        String str = new String(dp1.getData());
        System.out.println( "Result is: "+ str);


    }
}
