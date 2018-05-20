import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.lang.Thread;


public class TCPClient {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int port = 2002;
        int maxNoOfUsers = 1000;
        String address = "localhost";
        
        String [] clientsAddr = new String[maxNoOfUsers];
        
        for(int i = 0 ; i < maxNoOfUsers; i++){
        	clientsAddr[i] = "0";
        }
        
        try {
        	
        	new Thread(){
        		public void reloadClients() throws UnknownHostException, IOException{
        			Socket socket = new Socket(address, port);
        			
        			while(true){
            			DataInputStream input = new DataInputStream(socket.getInputStream());
            			
            			
        			}
        			
        		}
        	}.start();
        	
        	new Thread(){
        		public void sendMsg(){
        			
        		}
        	}.start();
        	
        	new Thread(){
        		public void receiveMsg(){
        			
        		}
        	}.start();
        	
            Socket socket = new Socket(address, port);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            
            DataInputStream input = new DataInputStream(socket.getInputStream());
            

            
            while(in.hasNext()) {
                String msg = in.nextLine();

                output.writeUTF(msg);
            }

        } catch (Exception e) {
            System.out.println("deu ruim");
        }

    }

}