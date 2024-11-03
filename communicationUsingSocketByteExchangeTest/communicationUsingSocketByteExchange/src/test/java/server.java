import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        System.out.println("Server is running... waiting for client connection.");
        Socket s = ss.accept();
        System.out.println("Client connected.");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Client :"+ str);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("yees !");
        pr.flush();
    }
}
