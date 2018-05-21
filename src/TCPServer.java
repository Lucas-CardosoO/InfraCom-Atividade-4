import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.Thread;
        
public class TCPServer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int port = 2002;
        int maxNoOfUsers = 1000;
        
        String [] clientsAddr = new String[maxNoOfUsers];
        Socket [] clientsSocket = new Socket[maxNoOfUsers];
        
        for(int i = 0 ; i < maxNoOfUsers; i++){
        	clientsAddr[i] = "0";
        }
        

        try { 
            
            int i = 0;
            while (true) {
                ServerSocket tmpsocket = new ServerSocket(port);

                System.out.println("Waiting");
                
                Socket socket = tmpsocket.accept();
                System.out.println("Connected!");

                String name = socket.getInetAddress().getHostAddress();
                
                clientsAddr[i] = name;
                clientsSocket[i] = socket;
                
                System.out.println(name);
                
                for(int j = 0; j < i; j++){
                	DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                	output.writeUTF(clientsAddr[j]);
                }
                                
                /*for(int j = 0; j < i; j++){
                	DataOutputStream output = new DataOutputStream(clientsSocket[j].getOutputStream());
                	output.writeUTF(clientsAddr[i]);
                }*/

                i++;
            }
        } catch(Exception e) {

        }
    }

}
