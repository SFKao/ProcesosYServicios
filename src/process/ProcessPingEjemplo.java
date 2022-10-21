import java.io.IOException;
import java.util.Scanner;

public class ProcessPingEjemplo {
    public static void main(String[] args) {

        //creo el proceso
        Process ping = null;
        String[] pingComando;
        if(args.length>=1)
            pingComando = new String[]{"ping", args[0], "-t"};
        else
            pingComando = new String[]{"ping", "www.google.es","-t"};
        //ejecuto el ping
        try{
            ping = Runtime.getRuntime().exec(pingComando);
            //leo el ping 10 veces
            Scanner inPing = new Scanner(ping.getInputStream());

            for (int i = 0; i < 10; i++)
                System.out.printf("Leyendo ping: %s%n",inPing.nextLine());

        } catch (IOException e) {
            System.out.println("No pudimos correr el ping");
            System.exit(-1);
        }


        //si el ping funcionó lo mato
        if(ping.isAlive()){
            ping.destroy();
            System.out.println("Matando proceso ping");
        }
        //espero a que muera

        try{
            System.out.println("Espero a que muera ping");
            ping.waitFor();
            System.out.println("Ping ha muerto");
        }catch (InterruptedException e){
            System.out.println("No se pudo esperar a que muera porque ya termino");
            System.exit(-1);
        }
        System.out.printf("Estado de terminacion de ping: %d%n",ping.exitValue());

    }
}
