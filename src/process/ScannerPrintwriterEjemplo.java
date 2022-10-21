import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerPrintwriterEjemplo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter salida = null;

        try{
            salida = new PrintWriter("salida.txt");
            String linea;
            while((linea = in.nextLine())!=null && linea.length() != 0){
                salida.println(linea);
            }
            salida.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(salida!=null){
                salida.close();
            }
        }
    }
}
