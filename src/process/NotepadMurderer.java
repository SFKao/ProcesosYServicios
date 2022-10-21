import java.io.IOException;

public class NotepadMurderer {
    public static void main(String[] args) {
        try{
            System.out.println("Abriendo notepad");
            String[] comando = {"notepad"};
            Process notepad = Runtime.getRuntime().exec(comando);
            Thread.sleep(2000);
            notepad.destroy();
            System.out.println("Asesinado");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
