import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainScreen extends JFrame {

    // Constructor
    public MainScreen() {
        // Set frame properties
        setTitle("Welcome Screen");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new BorderLayout());

        // Add the top panel to the frame
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 350)); // Set height for spacing
        // Create a title label
        JLabel titleLabel = new JLabel("Create Application Form", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

                  ///////// form///////////

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;



        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
//input field
        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        JLabel fathernameLabel = new JLabel("Father Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(fathernameLabel, gbc);

        JTextField fathernameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(fathernameField, gbc);

        JLabel ApplicantCnicLabel = new JLabel("CNIC:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(ApplicantCnicLabel, gbc);

        JTextField ApplicantCnicField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(ApplicantCnicField, gbc);
     
        add(formPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);
        
        

        // Set frame visibility
        setVisible(true);
    }
}