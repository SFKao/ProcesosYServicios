import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FlitraLineas {

    static final int MAX_LINEAS = 6;
    static final String[] COMANDO = {"find","\"la\""};

    public static void main(String[] args) throws InterruptedException {
        String parametro = "la";
        //COMANDO[1] = parametro;
        Scanner scanner = new Scanner(System.in);;
        Process processGrep = null;
        PrintWriter printWriterGrep = null;
        Scanner scannerGrep = null;
        try {
            processGrep = Runtime.getRuntime().exec(COMANDO);
            printWriterGrep = new PrintWriter(processGrep.getOutputStream());
            scannerGrep = new Scanner(processGrep.getInputStream());
            for(int i = 0; i < MAX_LINEAS; i++) {
                String introducido = scanner.nextLine();
                if (!introducido.equals("")) {
                    printWriterGrep.println(introducido);
                    printWriterGrep.close();
                    Thread.sleep(20);
                    if (scannerGrep.hasNextLine()) {
                        scannerGrep.nextLine();
                        System.out.printf("%s contiene %s%n", introducido, parametro);
                    } else {
                        System.out.printf("%s no contiene %s%n", introducido, parametro);
                    }
                }else{
                    i = 10;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(processGrep!=null){
            processGrep.destroy();
        }

        System.exit(1);


    }


    public static void fufa(){
        String parametro = "la";
        //COMANDO[1] = parametro;
        Scanner scanner = new Scanner(System.in);
        Process processGrep = null;
        PrintWriter inputGrep = null;
        BufferedReader outputGrep = null;
        try {
            processGrep = Runtime.getRuntime().exec(COMANDO);
            inputGrep = new PrintWriter(processGrep.getOutputStream());
            outputGrep = new BufferedReader(new InputStreamReader(processGrep.getInputStream()));
            String linea = "";
            for(int i = 0; i < MAX_LINEAS; i++) {
                String introducido = scanner.nextLine();
                if (!introducido.equals("")) {
                    inputGrep.println(introducido);
                    inputGrep.flush();
                    Thread.sleep(20);
                    if (outputGrep.ready()) {
                        linea = outputGrep.readLine();
                        System.out.printf("%s contiene %s%n", introducido, parametro);
                    } else {
                        System.out.printf("%s no contiene %s%n", introducido, parametro);
                    }
                }else{
                    i = 10;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if(processGrep!=null){
            processGrep.destroy();
        }

        System.exit(1);
    }
}
