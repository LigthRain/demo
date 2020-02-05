package netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    while (true) {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            int len;
                            byte[] data = new byte[1024];
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
//                                System.out.println(data);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
