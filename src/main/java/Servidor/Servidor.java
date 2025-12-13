package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
 public static final int puerto =12345;
public static ServerSocket server;
public static void main(String args[]) throws IOException {
    server= new ServerSocket(puerto);
    Socket clientSocket;
try {
    while (true){
        clientSocket=server.accept();
        Thread hilo= new Thread(new HiloJuego(clientSocket));
        hilo.start();
    }
} catch (IOException e) {
    throw new RuntimeException(e);
}

}
}
