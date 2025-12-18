package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Usuario{
    public static final int  puerto=12345;
    public static Socket socket;
   public static String ipServer= "34.236.154.196";
    public static void main(String args[]) throws IOException {
        socket= new Socket(ipServer,puerto);
        BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out= new PrintWriter(socket.getOutputStream(),true);
        Scanner teclado= new Scanner(System.in);
        System.out.println("Introduce un número del 1 al 100");

        int numero;
        String respuesta;

        do {
            numero = teclado.nextInt();
            teclado.nextLine();
            out.println(numero);

            respuesta = in.readLine();
            System.out.println(respuesta);

        } while (!respuesta.equalsIgnoreCase("correcto"));

        System.out.println("Has acertado el número. Juego acabado.");

    }
}
