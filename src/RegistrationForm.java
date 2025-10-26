import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Stage 1: The View (GUI)
// This class creates the main window for our application.
public class RegistrationForm extends JFrame {

    // 1. Declare all the GUI components (labels, text fields, buttons)
    private JLabel titleLabel, nameLabel, idLabel, emailLabel, phoneLabel;
    private JTextField nameField, idField, emailField, phoneField;
    private JButton submitButton;
    private JPanel panel; // A panel to hold all the components

    public RegistrationForm() {
        // --- Basic Window Setup ---
        setTitle("Student Registration Form");
        setSize(500, 400); // Set window size (width, height)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when 'X' is clicked
        setLocationRelativeTo(null); // Center the window on the screen

        // --- Create the Panel and Layout Manager ---
        // We'll use GridBagLayout for a clean, aligned form.
        panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components fill horizontal space
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing between components

        // --- 2. Initialize all components ---

        // Title Label
        titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the title
        panel.add(titleLabel, gbc);

        // Reset constraints for other components
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START; // Align components to the left

        // Name Row
        nameLabel = new JLabel("Full Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        nameField = new JTextField(20); // 20 is the preferred width
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nameField, gbc);

        // Student ID Row
        idLabel = new JLabel("Student ID:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(idLabel, gbc);

        idField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(idField, gbc);

        // Email Row
        emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(emailField, gbc);

        // Phone Row
        phoneLabel = new JLabel("Phone Number:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(phoneLabel, gbc);

        phoneField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(phoneField, gbc);

        // Submit Button
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Span both columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        panel.add(submitButton, gbc);

        // --- 3. Add the panel to the frame ---
        add(panel);

        // --- 4. Add the 'ActionListener' to the button ---
        // This is what happens when the button is clicked.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This is the logic that runs on click.
                handleSubmit();
            }
        });
    }

    // This method is called when the submit button is clicked
    private void handleSubmit() {
        // Get the text from each text field
        String name = nameField.getText();
        String studentId = idField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        // --- Placeholder for next stages ---
        // For now, just print the data to the console to confirm it works.
        System.out.println("--- New Student Submission ---");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("---------------------------------");

        // In the next stage, we will add validation here.
        // After validation, we'll create a Student object and send it to the DatabaseManager.

        // We can also add a simple popup to tell the user it worked
        JOptionPane.showMessageDialog(this, "Data Printed to Console (Not Saved Yet)", "Submission", JOptionPane.INFORMATION_MESSAGE);

        // Optional: Clear fields after submission
        nameField.setText("");
        idField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }
}
