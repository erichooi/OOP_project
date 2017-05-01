import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;
import java.util.ArrayList;

public class LoginWindow {
    private JFrame loginFrame;
    private JLabel headerLabel;
    private JPanel loginPanel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton adminButton;
    private JButton employeeButton;
    private String username;
    private String password;

    private String adminUsername = "jame";
    private String adminPassword = "admin";
    private String employeeUsername = "jame";
    private String employeePassword = "user";

    public LoginWindow(ArrayList<Employee> employees, ArrayList<Department> departments) {
        loginFrame = new JFrame("EMS");
        loginFrame.setSize(300, 100);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new BorderLayout());

        headerLabel = new JLabel("Choose your identity", JLabel.CENTER);

        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        adminButton = new JButton("Admin");
        employeeButton = new JButton("Employee");

        adminButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                InformationInput informationInput = new InformationInput(1, employees, departments);
            }
        });
        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                InformationInput informationInput = new InformationInput(2, employees, departments);
            }
        });

        loginPanel.add(adminButton);
        loginPanel.add(employeeButton);

        loginFrame.add(headerLabel, BorderLayout.PAGE_START);
        loginFrame.add(loginPanel, BorderLayout.CENTER);

        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private class InformationInput {
        public InformationInput(int iflag, ArrayList<Employee> employees, ArrayList<Department> departments) { // 1 for admin and 2 for employee
            JFrame informationFrame = new JFrame("Login");
            informationFrame.setSize(300, 100);
            informationFrame.setLayout(new GridLayout(3, 2));

            usernameField = new JTextField(20);
            passwordField = new JTextField(20);

            JButton submit = new JButton("Submit");
            submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    username = usernameField.getText();
                    password = passwordField.getText();

                    if (iflag == 1) {
                        if (username.equals(adminUsername) && password.equals(adminPassword)) {
                            informationFrame.dispose();
                            loginFrame.dispose();
                            AdminWindow adminWindow = new AdminWindow(employees, departments);
                        } else {
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                    } else if (iflag == 2) {
                        if (username.equals(employeeUsername) && password.equals(employeePassword)) {
                            informationFrame.dispose();
                            loginFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                    }
                }
            });

            informationFrame.add(new JLabel("Username"));
            informationFrame.add(usernameField);
            informationFrame.add(new JLabel("Password"));
            informationFrame.add(passwordField);
            informationFrame.add(new JLabel(""));
            informationFrame.add(submit);

            informationFrame.setLocationRelativeTo(null);
            informationFrame.setVisible(true);
        }
    }
}
