import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NetSalary {
    public static void main(String[] args) {
        // Crear un panel para el formulario.
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nameField = new JTextField(10);
        JTextField hoursField = new JTextField(10);
        JTextField rateField = new JTextField(10);

        panel.add(new JLabel("Nombre del empleado:"));
        panel.add(nameField);
        panel.add(new JLabel("Horas trabajadas:"));
        panel.add(hoursField);
        panel.add(new JLabel("Valor por hora:"));
        panel.add(rateField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Calcular Salario Neto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String hours = hoursField.getText();
            String rate = rateField.getText();

            if (name.isEmpty() || hours.isEmpty() || rate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Construye el comando con los tres argumentos.
                String[] command = {
                    "elixir",
                    "net_salary.exs",
                    name,
                    String.valueOf(hours),
                    String.valueOf(rate)
                };

                Process process = Runtime.getRuntime().exec(command);

                // Leer la respuesta del script.
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String response = reader.readLine();
                
                process.waitFor();
                
                // Mostrar el resultado final.
                JOptionPane.showMessageDialog(null, response, "Salario Neto Calculado", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al ejecutar el script de Elixir.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}