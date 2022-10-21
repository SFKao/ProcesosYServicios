import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeeFicheroPantalla {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner fichero = new Scanner(new File("salida.txt"));
        while (fichero.hasNextLine())
            System.out.println(fichero.nextLine());
        fichero.close();

    }
}
