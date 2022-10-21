import java.io.File;
import java.util.Scanner;

public class ResolucionPingGrepConFichero {

    public static void main(String[] args) {

        final File intercambio = new File("salidaPing.txt");

        //Preparo el process builder del ping
        ProcessBuilder pbPing = new ProcessBuilder();
        String[] pingComando;
        if(args.length>=1)
            pingComando = new String[]{"ping", args[0]};
        else
            pingComando = new String[]{"ping", "www.amazon.es"};
        pbPing.command(pingComando).redirectOutput(intercambio);

        //Preparo el process builder del grep
        ProcessBuilder pbGrep = new ProcessBuilder();
        final String[] grepComando = {"find","\"Media\""};
        pbGrep.command(grepComando).redirectInput(intercambio).redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try{
            Process pingProcess = pbPing.start();
            pingProcess.waitFor();
            Process grepProcess = pbGrep.start();
            //Scanner scanner = new Scanner(grepProcess.getInputStream());
            //Thread.sleep(20);
            //System.out.println(scanner.nextLine());

        }catch (Exception e){}



    }

}
