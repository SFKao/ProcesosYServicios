import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ActividadSencilla {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] comando;
        if(args.length>=1)
            comando = new String[]{"cmd", "/c", "dir", args[0]};
        else
            comando = new String[]{"cmd","/c","dir"};

        Process proceso = Runtime.getRuntime().exec(comando);

        Scanner scanner = new Scanner(proceso.getInputStream());
        PrintWriter printWriter = new PrintWriter("salida.txt");

        while (scanner.hasNextLine()){
            String salida = scanner.nextLine();
            System.out.println(salida);
            printWriter.println(salida);
            printWriter.flush();
        }
        printWriter.close();

        proceso.destroy();
        proceso.waitFor();

        System.out.printf("Codigo de finalizacion: %d",proceso.exitValue());
        System.exit(1);
    }
}
