import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ScannerProceso {
    public static void main(String[] args) throws IOException {
        final String[] comando = {"cmd","/c","dir"};
        Process ls = Runtime.getRuntime().exec(comando);
        Scanner lsIn = new Scanner(ls.getInputStream(), StandardCharsets.UTF_8);
        String linea;
        PrintWriter escritor = new PrintWriter("salida.txt",StandardCharsets.UTF_8);
        while (lsIn.hasNextLine()){
            System.out.println((linea = lsIn.nextLine()));
            escritor.println(linea);
            escritor.flush();
        }
        escritor.close();
    }
}
