import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Employee {
    private String firstName;
    private String lastName;
    private int employeeID;
    private Name employeeName;
    private Address employeeAddress;
    private String employeePhone;
    private double employeeSalary;
    private String employeeEmail;
    public static int eID = 1;

    public Employee() {
        this.getEmployeeFirstAndLastName();
        this.employeeAddress = new Address();
        this.employeePhone = "";
        this.employeeSalary = 0;
        this.employeeEmail = "";
        this.employeeID = eID;
        eID++;
    }

    public Employee(Address employeeAddress,
        String employeePhone, double employeeSalary, String employeeEmail) {

        this.getEmployeeFirstAndLastName();
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
        this.employeeID = eID;
        eID++;
    }

    public void getEmployeeFirstAndLastName() {
        JFrame firstLastFrame = new JFrame("Name");
        firstLastFrame.setSize(200, 100);
        firstLastFrame.setLayout(new GridLayout(3, 2));

        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);

        JButton submit = new JButton("Submit");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                if (firstName.equals("") || lastName.equals("")) {
                    JOptionPane.showMessageDialog(
                        null,
                        "First name or Last name not enter",
                        "Error message",
                        JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    employeeName = new Name(firstName, lastName);
                    firstLastFrame.dispose();
                }
            }
        });

        firstLastFrame.add(new JLabel("First Name"));
        firstLastFrame.add(firstNameField);
        firstLastFrame.add(new JLabel("Last Name"));
        firstLastFrame.add(lastNameField);
        firstLastFrame.add(new JLabel(""));
        firstLastFrame.add(submit);

        firstLastFrame.pack();
        firstLastFrame.setLocationRelativeTo(null);
        firstLastFrame.setVisible(true);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeName(Name employeeName) {
        this.employeeName = employeeName;
    }

    public Name getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeAddress(Address employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Address getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }
}
