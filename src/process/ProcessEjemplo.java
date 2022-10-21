import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessEjemplo {
    public static void main(String[] args){
        try {
            //Ejecuto el comando
            final String[] cmd = {"cmd", "/c", "dir"};
            Process p = Runtime.getRuntime().exec(cmd);
            //preparo un lector
            InputStream inputStreamRuntime = p.getInputStream();
            BufferedReader bufferedReaderRuntime = new BufferedReader(new InputStreamReader(inputStreamRuntime));
            //Comienzo a leer
            String lectura = bufferedReaderRuntime.readLine();
            while (lectura != null) {
                System.out.println(lectura);
                lectura = bufferedReaderRuntime.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
