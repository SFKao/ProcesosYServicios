
import java.io.PrintWriter;
import java.util.Scanner;

public class ResolucionPingGrep {

    public static void main(String[] args) {

        //creo el proceso
        ProcessBuilder pbPing = new ProcessBuilder();
        String[] pingComando;
        if(args.length>=1)
            pingComando = new String[]{"ping", args[0]};
        else
            pingComando = new String[]{"ping", "www.google.es"};
        pbPing.command(pingComando);

        ProcessBuilder pbGrep = new ProcessBuilder();
        final String[] grepComando = {"find","\"Media\""};
        pbGrep.command(grepComando);

        try{
            Process pingProcess = pbPing.start();
            Process grepProcess = pbGrep.start();

            Scanner lectorPing = new Scanner(pingProcess.getInputStream());
            PrintWriter escritorGrep = new PrintWriter(grepProcess.getOutputStream());
            Scanner scanner = new Scanner(grepProcess.getInputStream());
            while(lectorPing.hasNextLine()){
                escritorGrep.println(lectorPing.nextLine());
                escritorGrep.flush();
            }

            if(scanner.hasNextLine())
                System.out.println(scanner.nextLine());

        }catch (Exception e){}



    }

}
