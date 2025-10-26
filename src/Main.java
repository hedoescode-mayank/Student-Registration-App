import javax.swing.SwingUtilities;

// Stage 2: The Entry Point (Updated)
// Humara main class ab DatabaseManager ko bhi initialize karega.
public class Main {

    public static void main(String[] args) {

        // 1. Initialize the Database Manager first
        // Yeh connection banayega aur table create karega app start hote hi.
        DatabaseManager dbManager = new DatabaseManager();

        // 2. Run the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of our form
                // Aur ab hum form ko dbManager ka reference denge
                RegistrationForm form = new RegistrationForm(dbManager);
                // Make the form visible
                form.setVisible(true);
            }
        });
    }
}

