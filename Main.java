import javax.swing.SwingUtilities;

// Stage 1: The Entry Point
// This class's only job is to start our application.
public class Main {

    public static void main(String[] args) {
        // Swing applications should run on a special "Event Dispatch Thread" (EDT).
        // SwingUtilities.invokeLater() makes sure it does.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of our form
                RegistrationForm form = new RegistrationForm();
                // Make the form visible
                form.setVisible(true);
            }
        });
    }
}

