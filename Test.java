public class Test {
    public static void main(String[] args) {
        Name name1 = new Name("Jame", "Bond");
        Address address1 = new Address("8, Jalan Sini", "Taman Sine", "81200", "Johor");
        Name name2 = new Name("Jame", "Bond 2");
        Address address2 = new Address("9, Jalan Sana", "Taman Sana", "81300", "Melaka");

        Employee employee1 = new Employee(address1, "0128765434", 200, "email@gmail.com");
        Employee employee2 = new Employee(address2, "0128765904", 2000, "this@gmail.com");

        Department department1 = new Department("Computer");
        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department1.addEmployee(employee2);
        department1.addEmployee(employee2);
        department1.addEmployee(employee2);

        department1.display();
    }
}
