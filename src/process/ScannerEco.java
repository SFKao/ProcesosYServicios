import java.util.Scanner;

public class ScannerEco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linea;
        while((linea = scanner.nextLine()) != null && linea.length() != 0){
            System.out.println(linea);
        }
    }
}
