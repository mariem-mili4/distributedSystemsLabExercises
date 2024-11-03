import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 9090); // Change to 9090
        System.out.println("Connected to the server");

        ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()));
        ObjectInputStream in =new ObjectInputStream(socket.getInputStream());


        String productName = "Laptop";
        out.writeObject(productName);
        System.out.println("Sent product name: " + productName);

        Product receivedProduct = (Product) in.readObject();
        System.out.println("Received product price :"+ receivedProduct.getPrice());

        in.close();
        out.close();
        socket.close();

    }
}
