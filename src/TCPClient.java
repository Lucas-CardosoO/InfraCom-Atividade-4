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
        boolean [] clientsConnect = new boolean[maxNoOfUsers];
        Socket [] clientsSocket = new Socket[maxNoOfUsers];
        
        for(int i = 0 ; i < maxNoOfUsers; i++){
        	clientsAddr[i] = "0";
        	clientsConnect[i] = false;
        }
        
        try {
    		while(true){
    			Socket srvrSocket = new Socket(address, port);
    				
				new Thread(){
					public void srvrConnect() throws IOException{
						
						int i = 0;
		    			while(true && i < maxNoOfUsers){
	    					
	    					DataInputStream srvrInput = new DataInputStream(srvrSocket.getInputStream());
	            			
	            			String addr = srvrInput.readUTF();            			
	            			
	            			Socket socket = new Socket(addr, port);
	            			
	            			clientsSocket[i] = socket;
	            			clientsConnect[i] = true;
	            			
	            			new Thread(){
	                    		public void rcvMsg() throws IOException{
	                    			while(true){
	                        			DataInputStream input = new DataInputStream(socket.getInputStream());
	                        			
	                        			String msgRcv = input.readUTF();
	                        			
	                        			System.out.println(msgRcv);
	                    			}
	                    		}
	                    	};
	            			
	            			i++;
		    			}
					}
				};
    			
    			
    			new Thread(){
            		public void sendMsg() throws IOException{
            			while(in.hasNext()) {
                            String msgSend = in.nextLine();
                            
	            			for (int i = 0; i < maxNoOfUsers && clientsConnect[i]; i++){
		                        DataOutputStream output = new DataOutputStream(clientsSocket[i].getOutputStream());

		                        output.writeUTF(msgSend);
		                        
		                        
	            			}
            			}
            		}
            	}.start();

				
			}

        } catch (Exception e) {
            System.out.println("deu ruim");
        }

    }

}