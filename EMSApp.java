import java.util.ArrayList;

public class EMSApp {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>(10);
        ArrayList<Department> departments = new ArrayList<Department>(3);
        LoginWindow loginWindow = new LoginWindow(employees, departments);
    }
}
