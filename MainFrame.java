import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Main Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton createFormButton = new JButton("Create Form");
        createFormButton.setFont(new Font("Arial", Font.BOLD, 14));
        createFormButton.setBackground(Color.decode("#1995AD"));
        createFormButton.setForeground(Color.WHITE);
        createFormButton.setFocusPainted(false);
        createFormButton.setPreferredSize(new Dimension(150, 40));

        createFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateFormPage(MainFrame.this); // Open CreateFormPage and pass MainFrame as reference
                setVisible(false); // Hide MainFrame
            }
        });

        setLayout(new GridBagLayout());
        add(createFormButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame(); // Start with MainFrame
    }
}
