import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WordLength {
    public static void main(String[] args) {
        // Pide al usuario que ingrese una palabra
        String word = JOptionPane.showInputDialog(null, "Introduce una palabra:", "Longitud de palabra", JOptionPane.QUESTION_MESSAGE);

        if (word != null && !word.trim().isEmpty()) {
            try {
                // Construye y ejecuta el comando
                String command[] = {"elixir", "word_length.exs", word};
                Process process = Runtime.getRuntime().exec(command);

                // Lee la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String lengthStr = reader.readLine();

                process.waitFor();

                // Mostrar resultado

                JOptionPane.showMessageDialog(null, "La longitud de la palabra " + word + " es: " + lengthStr, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();

                JOptionPane.showMessageDialog(null, "Algo mal ocurrió. El programa falló, revise stacktrace.", "ERR: Uncompleted action", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresó ninguna palabra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}