import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Echo {
    public static void main(String[] args) {
        // Pedir datos al usuario
        String messageToSend = JOptionPane.showInputDialog(null, "Ingrese cualquier texto:", "Ingresar texto", JOptionPane.QUESTION_MESSAGE);

        if (messageToSend != null && !messageToSend.strip().isEmpty()) {

        try {
            // Aquí se construye el comando para ejecutar el script de Elixir
            String command[] = {"elixir", "echo.exs", messageToSend};

            Process process = Runtime.getRuntime().exec(command);

            // Lee la salida del script de Elixir
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String response = reader.readLine();

            // Espera a que el proceso termine
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // Mostrar la respuesta del programa Elixir

                JOptionPane.showMessageDialog(null, "Respuesta de Elixir: " + response, "Eco", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Algo mal ocurrió, error al ejecutar script de Elixir.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Algo mal ocurrió, excepción: " + e.getMessage(), "ERR: Excepción", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "No ingresó caracteres, programa cerrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }
}