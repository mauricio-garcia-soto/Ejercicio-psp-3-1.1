package Servidor;

import java.net.Socket;

public class HiloJuego implements Runnable{
    private Socket socket;
public HiloJuego(Socket socket){
    this.socket=socket;
}
    @Override
    public void run() {

    }
}
