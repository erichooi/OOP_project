import java.util.ArrayList;

public class Department {
    private int departmentID;
    private String departmentName;
    private int totalEmployee;
    private ArrayList<Employee> employees;
    private int employeeNum;
    public static int dID = 1;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentID = dID;
        this.employees = new ArrayList<Employee>(10); // a department can only accommodate 10 employee
        employeeNum = 0;
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

    public void addEmployee(Employee employee) {
        if (this.employeeNum < 10) {
            this.employees.add(employee);
            this.employeeNum++;
        } else {
            System.out.println("Department exceed the maximum allow employee");
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
            this.employeeNum--;
        }
    }
}
