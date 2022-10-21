import java.io.IOException;

public class NotepadOpener {
    public static void main(String[] args) {
        try{
            System.out.println("Abriendo notepad");
            String[] comando = {"notepad"};
            Process notepad = Runtime.getRuntime().exec(comando);
            notepad.waitFor();
            System.out.println("Se ha cerrado");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
