import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWindow {
    private JFrame adminFrame;
    private JLabel headerLabel;
    private JPanel adminPanel;

    private JButton cEmployeeButton;
    private JButton rEmployeeButton;
    private JButton uEmployeeButton;
    private JButton dEmployeeButton;

    private JButton cDepartmentButton;
    private JButton rDepartmentButton;
    private JButton uDepartmentButton;
    private JButton dDepartmentButton;

    private int choice;

    public AdminWindow(ArrayList<Employee> employees, ArrayList<Department> departments) {
        adminFrame = new JFrame("Admin");
        adminFrame.setSize(250, 300);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(new BorderLayout());

        headerLabel = new JLabel("Choose what you want to do", JLabel.CENTER);

        adminPanel = new JPanel();
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));

        cEmployeeButton = new JButton("Create Employee");
        cEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Employee employee = new Employee();
                employees.add(employee);
            }
        });
        rEmployeeButton = new JButton("Show Employee");
        rEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame employeeChoiceList = new JFrame("Show Employee");
                employeeChoiceList.setSize(300, 200);
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                for (int i = 0; i < employees.size(); i++) {
                    JButton employeeButton = new JButton(employees.get(i).getEmployeeName().toString());
                    employeeButton.setActionCommand(Integer.toString(i));
                    employeeButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            choice = Integer.parseInt(event.getActionCommand());
                            EmployeeInformationShow employeeInformationInput = new EmployeeInformationShow(employees.get(choice));
                            employeeChoiceList.dispose();
                        }
                    });
                    employeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                    panel.add(employeeButton);
                }

                employeeChoiceList.add(panel);
                employeeChoiceList.setVisible(true);
            }
        });
        uEmployeeButton = new JButton("Update Employee");
        uEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame employeeChoiceList = new JFrame("Update Employee");
                employeeChoiceList.setSize(300, 200);
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                for (int i = 0; i < employees.size(); i++) {
                    JButton employeeButton = new JButton(employees.get(i).getEmployeeName().toString());
                    employeeButton.setActionCommand(Integer.toString(i));
                    employeeButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            choice = Integer.parseInt(event.getActionCommand());
                            EmployeeInformationInput employeeInformationInput = new EmployeeInformationInput(employees.get(choice));
                            employeeChoiceList.dispose();
                        }
                    });
                    employeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                    panel.add(employeeButton);
                }

                employeeChoiceList.add(panel);
                employeeChoiceList.setVisible(true);
            }
        });
        dEmployeeButton = new JButton("Delete Employee");
        dEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame employeeChoiceList = new JFrame("Delete Employee");
                employeeChoiceList.setSize(300, 200);
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                for (int i = 0; i < employees.size(); i++) {
                    JButton employeeButton = new JButton(employees.get(i).getEmployeeName().toString());
                    employeeButton.setActionCommand(Integer.toString(i));
                    employeeButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            choice = Integer.parseInt(event.getActionCommand());
                            employees.remove(choice);
                            employeeChoiceList.dispose();
                        }
                    });
                    employeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                    panel.add(employeeButton);
                }

                employeeChoiceList.add(panel);
                employeeChoiceList.setVisible(true);
            }
        });

        cDepartmentButton = new JButton("Create Department");
        cDepartmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // JFrame inputFrame = new JFrame();
                String departmentName = JOptionPane.showInputDialog(
                    null,
                    "Enter the new department's name",
                    "New Department"
                );
                Department department = new Department(departmentName);
                departments.add(department);
            }
        });
        rDepartmentButton = new JButton("Show Department");
        rDepartmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame DepartmentList = new JFrame("Show Department");
                DepartmentList.setSize(300, 200);
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                for (int i = 0; i < departments.size(); i++) {
                    JButton departmentButton = new JButton(departments.get(i).getDepartmentName());
                    departmentButton.setActionCommand(Integer.toString(i));
                    departmentButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            choice = Integer.parseInt(event.getActionCommand());
                            EmployeeInformationShow employeeInformationInput = new EmployeeInformationShow(employees.get(choice));
                            DepartmentList.dispose();
                        }
                    });
                    departmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                    panel.add(departmentButton);
                }

                DepartmentList.add(panel);
                DepartmentList.setVisible(true);
            }
        });
        uDepartmentButton = new JButton("Update Department");
        dDepartmentButton = new JButton("Delete Department");

        cEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        uEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cDepartmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rDepartmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        uDepartmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dDepartmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        adminPanel.add(cEmployeeButton);
        adminPanel.add(rEmployeeButton);
        adminPanel.add(uEmployeeButton);
        adminPanel.add(dEmployeeButton);

        adminPanel.add(cDepartmentButton);
        adminPanel.add(rDepartmentButton);
        adminPanel.add(uDepartmentButton);
        adminPanel.add(dDepartmentButton);

        adminFrame.add(headerLabel, BorderLayout.PAGE_START);
        adminFrame.add(adminPanel, BorderLayout.CENTER);

        adminFrame.setVisible(true);
    }

    private class EmployeeInformationInput {
        public EmployeeInformationInput(Employee employee) {
            JFrame employeeInformationFrame = new JFrame("Employee Information");
            employeeInformationFrame.setSize(580, 320);
            employeeInformationFrame.setLayout(new GridLayout(10, 2));

            JTextField employeeAddress1 = new JTextField(employee.getEmployeeAddress().getAddress1());
            JTextField employeeAddress2 = new JTextField(employee.getEmployeeAddress().getAddress2());
            JTextField employeeZipCode = new JTextField(employee.getEmployeeAddress().getZipCode());
            JTextField employeeState = new JTextField(employee.getEmployeeAddress().getState());
            JTextField employeeSalary = new JTextField(Double.toString(employee.getEmployeeSalary()));
            JTextField employeeEmail = new JTextField(employee.getEmployeeEmail());
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String address1 = employeeAddress1.getText();
                    String address2 = employeeAddress2.getText();
                    String zipCode = employeeZipCode.getText();
                    String state = employeeState.getText();
                    String salary = employeeSalary.getText();
                    String email = employeeEmail.getText();

                    Address address = new Address(address1, address2, zipCode, state);
                    employee.setEmployeeAddress(address);
                    employee.setEmployeeSalary(Double.parseDouble(salary));
                    employee.setEmployeeEmail(email);

                    employeeInformationFrame.dispose();
                }
            });

            employeeInformationFrame.add(new JLabel("ID"));
            employeeInformationFrame.add(new JLabel(Integer.toString(employee.getEmployeeID())));
            employeeInformationFrame.add(new JLabel("First Name"));
            employeeInformationFrame.add(new JLabel(employee.getEmployeeName().getFirstName()));
            employeeInformationFrame.add(new JLabel("Last Name"));
            employeeInformationFrame.add(new JLabel(employee.getEmployeeName().getLastName()));
            employeeInformationFrame.add(new JLabel("Address 1"));
            employeeInformationFrame.add(employeeAddress1);
            employeeInformationFrame.add(new JLabel("Address 2"));
            employeeInformationFrame.add(employeeAddress2);
            employeeInformationFrame.add(new JLabel("Zip Code"));
            employeeInformationFrame.add(employeeZipCode);
            employeeInformationFrame.add(new JLabel("State"));
            employeeInformationFrame.add(employeeState);
            employeeInformationFrame.add(new JLabel("Salary"));
            employeeInformationFrame.add(employeeSalary);
            employeeInformationFrame.add(new JLabel("Email"));
            employeeInformationFrame.add(employeeEmail);
            employeeInformationFrame.add(new JLabel(""));
            employeeInformationFrame.add(submitButton);

            employeeInformationFrame.setVisible(true);
        }
    }

    private class EmployeeInformationShow {
        public EmployeeInformationShow(Employee employee) {
            JFrame employeeInformationFrame = new JFrame("Employee Information");
            employeeInformationFrame.setSize(580, 320);
            employeeInformationFrame.setLayout(new GridLayout(10, 2));

            JLabel employeeAddress1 = new JLabel(employee.getEmployeeAddress().getAddress1());
            JLabel employeeAddress2 = new JLabel(employee.getEmployeeAddress().getAddress2());
            JLabel employeeZipCode = new JLabel(employee.getEmployeeAddress().getZipCode());
            JLabel employeeState = new JLabel(employee.getEmployeeAddress().getState());
            JLabel employeeSalary = new JLabel(Double.toString(employee.getEmployeeSalary()));
            JLabel employeeEmail = new JLabel(employee.getEmployeeEmail());
            JButton submitButton = new JButton("OK");
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    employeeInformationFrame.dispose();
                }
            });

            employeeInformationFrame.add(new JLabel("ID"));
            employeeInformationFrame.add(new JLabel(Integer.toString(employee.getEmployeeID())));
            employeeInformationFrame.add(new JLabel("First Name"));
            employeeInformationFrame.add(new JLabel(employee.getEmployeeName().getFirstName()));
            employeeInformationFrame.add(new JLabel("Last Name"));
            employeeInformationFrame.add(new JLabel(employee.getEmployeeName().getLastName()));
            employeeInformationFrame.add(new JLabel("Address 1"));
            employeeInformationFrame.add(employeeAddress1);
            employeeInformationFrame.add(new JLabel("Address 2"));
            employeeInformationFrame.add(employeeAddress2);
            employeeInformationFrame.add(new JLabel("Zip Code"));
            employeeInformationFrame.add(employeeZipCode);
            employeeInformationFrame.add(new JLabel("State"));
            employeeInformationFrame.add(employeeState);
            employeeInformationFrame.add(new JLabel("Salary"));
            employeeInformationFrame.add(employeeSalary);
            employeeInformationFrame.add(new JLabel("Email"));
            employeeInformationFrame.add(employeeEmail);
            employeeInformationFrame.add(new JLabel(""));
            employeeInformationFrame.add(submitButton);

            employeeInformationFrame.setVisible(true);
        }
    }
}
