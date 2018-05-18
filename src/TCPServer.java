        import java.net.ServerSocket;
        import java.net.Socket;
        import java.io.DataInputStream;

public class TCPServer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int port = 2002;
        int timeOut = 10*(int) (Math.pow(10,9));

        try {
            ServerSocket tmpsocket = new ServerSocket(port);
            while (true) {

                System.out.println("Waiting");


                Socket socket = tmpsocket.accept();
                System.out.println("Connected!");

                long timeBegin = System.nanoTime();
                long timeNow = timeBegin;
                DataInputStream input = new DataInputStream(socket.getInputStream());
                while (true) {
                    timeNow = System.nanoTime();
                    String msg = input.readUTF();
                    if(timeNow < (timeBegin + timeOut)) {
                        System.out.println(msg);
                    } else {
                        break;
                    }

                }

                System.out.println("Connecton closed");

                socket.close();
            }
        } catch(Exception e) {

        }
    }

}
