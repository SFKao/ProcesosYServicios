package processES;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class nslookup_inherit {

    public static void main(String[] args) {

        final String[] COMANDO = {"cmd","/c","nslookup"};
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(COMANDO);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try(
                Scanner scanner = new Scanner(System.in);
                ){
            String linea;
            System.out.println("Introduce el nombre del dominio");
            while(!(linea = scanner.nextLine()).equals("") && linea.length()!=0){
                Process process = processBuilder.start();
                try(
                        PrintWriter printWriter = new PrintWriter(process.getOutputStream());
                        ){
                    printWriter.println(linea);
                    //printWriter.flush();
                }
/*
                try(
                        Scanner lectorNS = new Scanner(process.getInputStream());
                        ){
                    while (lectorNS.hasNextLine())
                        System.out.println(lectorNS.nextLine());
                }
                
 */
                try{
                    process.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
