import java.io.IOException;

public class SystemInReadEjemplo {
    public static void main(String[] args) throws IOException {
        char c;
        int contador = 0;

        while ((c = (char) System.in.read())!='\n'){
            contador++;
            System.out.println(c);
        }
        System.out.printf("%nContados %d bytes",contador);
    }
}