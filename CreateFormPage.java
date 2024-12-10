import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFormPage extends JFrame {

    private JFrame mainFrame; // Reference to the MainFrame

    public CreateFormPage(JFrame mainFrame) {
        this.mainFrame = mainFrame; // Store the reference to MainFrame

        setTitle("Create Form");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Main Panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#EAF6F6"));

        // Top Panel for Back Button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Color.decode("#EAF6F6"));

        JButton backButton = new JButton("← Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(Color.decode("#1995AD"));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.addActionListener(e -> {
            mainFrame.setVisible(true); // Show the MainFrame
            dispose(); // Close the CreateFormPage
        });

        topPanel.add(backButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Form Panel with GridLayout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.decode("#EAF6F6"));

        Font labelFont = new Font("Verdana", Font.BOLD, 14);
        Font inputFont = new Font("Arial", Font.PLAIN, 12);

        Dimension inputSize = new Dimension(200, 20);

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        formPanel.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setFont(inputFont);
        nameField.setPreferredSize(inputSize);
        formPanel.add(nameField);

        // Father Name field
        JLabel fatherNameLabel = new JLabel("Father Name:");
        fatherNameLabel.setFont(labelFont);
        formPanel.add(fatherNameLabel);
        JTextField fatherNameField = new JTextField();
        fatherNameField.setFont(inputFont);
        fatherNameField.setPreferredSize(inputSize);
        formPanel.add(fatherNameField);

        // CNIC field
        JLabel cnicLabel = new JLabel("CNIC:");
        cnicLabel.setFont(labelFont);
        formPanel.add(cnicLabel);
        JTextField cnicField = new JTextField();
        cnicField.setFont(inputFont);
        cnicField.setPreferredSize(inputSize);
        formPanel.add(cnicField);

        // Marriage status
        JLabel marriageStatusLabel = new JLabel("Marriage Status:");
        marriageStatusLabel.setFont(labelFont);
        formPanel.add(marriageStatusLabel);
        JPanel marriagePanel = new JPanel();
        marriagePanel.setBackground(Color.decode("#EAF6F6"));
        ButtonGroup marriageGroup = new ButtonGroup();
        JRadioButton marriedButton = new JRadioButton("Married");
        JRadioButton unmarriedButton = new JRadioButton("Unmarried");
        marriedButton.setBackground(Color.decode("#EAF6F6"));
        unmarriedButton.setBackground(Color.decode("#EAF6F6"));
        marriageGroup.add(marriedButton);
        marriageGroup.add(unmarriedButton);
        marriagePanel.add(marriedButton);
        marriagePanel.add(unmarriedButton);
        formPanel.add(marriagePanel);

        // Spouse Name
        JLabel spouseLabel = new JLabel("Spouse Name:");
        spouseLabel.setFont(labelFont);
        JTextField spouseField = new JTextField();
        spouseField.setFont(inputFont);
        spouseField.setPreferredSize(inputSize);
        spouseLabel.setEnabled(false);
        spouseField.setEnabled(false);
        formPanel.add(spouseLabel);
        formPanel.add(spouseField);

        // Number of Children
        JLabel childrenLabel = new JLabel("Number of Children:");
        childrenLabel.setFont(labelFont);
        JTextField childrenField = new JTextField();
        childrenField.setFont(inputFont);
        childrenField.setPreferredSize(inputSize);
        childrenLabel.setEnabled(false);
        childrenField.setEnabled(false);
        formPanel.add(childrenLabel);
        formPanel.add(childrenField);

        marriedButton.addActionListener(e -> {
            spouseLabel.setEnabled(true);
            spouseField.setEnabled(true);
            childrenLabel.setEnabled(true);
            childrenField.setEnabled(true);
        });

        unmarriedButton.addActionListener(e -> {
            spouseLabel.setEnabled(false);
            spouseField.setEnabled(false);
            childrenLabel.setEnabled(false);
            childrenField.setEnabled(false);
        });

        // Department field
        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setFont(labelFont);
        formPanel.add(departmentLabel);
        JTextField departmentField = new JTextField();
        departmentField.setFont(inputFont);
        departmentField.setPreferredSize(inputSize);
        formPanel.add(departmentField);

        // Designation field
        JLabel designationLabel = new JLabel("Designation:");
        designationLabel.setFont(labelFont);
        formPanel.add(designationLabel);
        JTextField designationField = new JTextField();
        designationField.setFont(inputFont);
        designationField.setPreferredSize(inputSize);
        formPanel.add(designationField);

        // House demand field
        JLabel houseDemandLabel = new JLabel("Specific House Demand:");
        houseDemandLabel.setFont(labelFont);
        formPanel.add(houseDemandLabel);
        JTextArea houseDemandArea = new JTextArea(3, 20);
        houseDemandArea.setFont(inputFont);
        houseDemandArea.setLineWrap(true);
        houseDemandArea.setWrapStyleWord(true);
        JScrollPane houseDemandScrollPane = new JScrollPane(houseDemandArea);
        formPanel.add(houseDemandScrollPane);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(Color.decode("#1995AD"));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setPreferredSize(new Dimension(100, 30));
        submitButton.addActionListener(e -> {
            if (nameField.getText().trim().isEmpty() ||
                fatherNameField.getText().trim().isEmpty() ||
                cnicField.getText().trim().isEmpty() ||
                (!marriedButton.isSelected() && !unmarriedButton.isSelected()) ||
                departmentField.getText().trim().isEmpty() ||
                designationField.getText().trim().isEmpty() ||
                (marriedButton.isSelected() && (spouseField.getText().trim().isEmpty() || childrenField.getText().trim().isEmpty()))) {
                
                JOptionPane.showMessageDialog(CreateFormPage.this, "Please fill in all required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(CreateFormPage.this, "Form submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.decode("#EAF6F6"));
        bottomPanel.add(submitButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
