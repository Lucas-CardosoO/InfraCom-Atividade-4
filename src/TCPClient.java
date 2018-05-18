import java.util.Scanner;
import java.net.Socket;
import java.io.DataOutputStream;


public class TCPClient {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int port = 2002;
        String address = "localhost";
        try {
            Socket socket = new Socket(address, port);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());


            while(in.hasNext()) {
                String msg = in.nextLine();

                output.writeUTF(msg);
            }

        } catch (Exception e) {
            System.out.println("deu ruim");
        }

    }

}