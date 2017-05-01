import java.util.ArrayList;
import javax.swing.*;

public class Department {
    private int departmentID;
    private String departmentName;
    private ArrayList<Employee> employees;
    private int totalEmployee;
    public static int dID = 1;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentID = dID;
        this.employees = new ArrayList<Employee>(10); // a department can only accommodate 10 employee
        totalEmployee = 0;
        dID++;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setTotalEmployee(int totalEmployee) {
        this.totalEmployee = totalEmployee;
    }

    public int getTotalEmployee() {
        return totalEmployee;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public void addEmployee(Employee employee) {
        boolean duplicate = false;
        for (Employee e : this.employees) {
            if (e.getEmployeeID() == employee.getEmployeeID()) {
                duplicate = true;
            }
        }
        if (this.totalEmployee < 10 && duplicate == false) {
            this.employees.add(employee);
            this.totalEmployee++;
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Failed to add\nMaybe due to:\n\t1. Exceed max number\n\t2. Already exist",
                "Error Message",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void removeEmployee(Employee employee) {
        boolean exist = false;
        for (Employee e : this.employees) {
            if (e.getEmployeeName().equals(employee.getEmployeeName())) {
                exist = true;
            }
        }
        if (exist) {
            this.employees.remove(employee);
            this.totalEmployee--;
        }
    }
}
