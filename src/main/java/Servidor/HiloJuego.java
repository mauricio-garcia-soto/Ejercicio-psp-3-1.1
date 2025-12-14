package Servidor;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class HiloJuego implements Runnable{
    private Socket socket;
    BufferedReader in;
    PrintWriter out;
    int numeroSecreto=(int) (Math.random()*100)+1;

public HiloJuego(Socket socket){
    this.socket=socket;
    this.numeroSecreto=(int) (Math.random()*100)+1;
    try {
in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
out= new PrintWriter(socket.getOutputStream(),true);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

    @Override
    public void run() {

    try {
        String mensaje;
        while ((mensaje = in.readLine()) != null){
            if (Integer.parseInt(mensaje)>numeroSecreto){
                out.println("el numero es mas pequeño");
            } else if (Integer.parseInt(mensaje)<numeroSecreto) {
                out.println("el numero es mas grande");
            }else {
                out.println("correcto");
                break;
            }
        }

    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    }
}
