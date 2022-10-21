package processBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProcessBuilderEjemplo1 {
    public static void processBuilderLeer(String archivo){
        //Creo un process builder, requiere todos los parametros en un array o concatenados
        //type = cat
        ProcessBuilder processBuilder = new ProcessBuilder().command("cmd","/c","type",archivo);
        Scanner in = null;
        try{
            Process process = processBuilder.start();
            in = new Scanner(process.getInputStream());
            while(in.hasNextLine())
                System.out.println(in.nextLine());
            process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void processBuilderInheritIO(){
        //busca archivos
        String[] comando = new String[]{"cmd","/c","dir","/s","\\*"};
        //que el proceso tome las mismas E/S que el padre y redirija los errores a el
        ProcessBuilder processBuilder = new ProcessBuilder().command(comando).inheritIO().redirectErrorStream(true);
        try{
            Process process = processBuilder.start();
            //tienes 300 milisegundos para terminar o te mato
            if(!process.waitFor(300, TimeUnit.MILLISECONDS)){
                process.destroy();
                System.out.println("No termino a tiempo");
            }
        } catch (IOException e) {
            System.out.println("No se pudo tomar la E/S");
            System.exit(-1);
        } catch (InterruptedException e) {
            System.out.println("El proceso se interrumpio");
            System.exit(-2);
        }
        System.exit(0);
    }

    public static int lanzaProcesoEntradaYSalidaPorFichero(String[] comando) throws IOException, InterruptedException { return new ProcessBuilder().command(comando).redirectInput(new File("entrada.txt")).redirectOutput(ProcessBuilder.Redirect.appendTo(new File("salida.txt"))).start().waitFor(); }

    public static void main(String[] args) {
        //processBuilderLeer("salida.txt");
        //processBuilderInheritIO();
        try {
            System.out.println(lanzaProcesoEntradaYSalidaPorFichero(new String[]{"cmd","/c","dir"}));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
