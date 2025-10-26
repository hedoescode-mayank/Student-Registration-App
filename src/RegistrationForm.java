import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Stage 1: The View (GUI) - Updated for Stage 2
public class RegistrationForm extends JFrame {

    private JLabel titleLabel, nameLabel, idLabel, emailLabel, phoneLabel;
    private JTextField nameField, idField, emailField, phoneField;
    private JButton submitButton;
    private JPanel panel;

    // --- STAGE 2 UPDATE ---
    // DatabaseManager ke liye ek reference variable
    private DatabaseManager dbManager;

    // --- STAGE 2 UPDATE ---
    // Constructor ko update kiya taaki woh DatabaseManager ko receive kar sake
    public RegistrationForm(DatabaseManager dbManager) {
        this.dbManager = dbManager; // Store the reference

        // --- Basic Window Setup ---
        setTitle("Student Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Create the Panel and Layout Manager ---
        panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // --- 2. Initialize all components ---

        // Title Label
        titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Reset constraints
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;

        // Name Row
        nameLabel = new JLabel("Full Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        nameField = new JTextField(20);
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
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        // --- 3. Add the panel to the frame ---
        add(panel);

        // --- 4. Add the 'ActionListener' to the button ---
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    // --- STAGE 2 UPDATE ---
    // handleSubmit method ko update kiya gaya hai
    private void handleSubmit() {
        // Get the text from each text field
        String name = nameField.getText();
        String studentId = idField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        // Basic Validation (Stage 3 mein ise behtar karenge)
        if (name.isEmpty() || studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Student ID are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop the method
        }

        // 1. Create a new Student object
        Student newStudent = new Student(name, studentId, email, phone);

        // 2. Use DatabaseManager to add the student
        boolean success = dbManager.addStudent(newStudent);

        // 3. Show feedback to the user
        if (success) {
            JOptionPane.showMessageDialog(this, "Student registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Clear fields after successful submission
            nameField.setText("");
            idField.setText("");
            emailField.setText("");
            phoneField.setText("");
        } else {
            // Error message (e.g., duplicate ID)
            JOptionPane.showMessageDialog(this, "Failed to register student. Student ID might already exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
