import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(9090); // Change to 9090
        System.out.println("Server started...");

        Socket socket = server.accept() ;
        System.out.println("Client connected");


        ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String productName = (String) in.readObject();
        System.out.println("Received product: " + productName);

        Product product = new Product(productName,99.9);
        System.out.println("Sending product with price: "+ product.getPrice());

        out.writeObject(product);

        in.close();
        out.close();
        socket.close();
    }
}
