public abstract class Employee extends User {

    protected double salary;

    public Employee(String name, String email, String dateOfBirth, double salary) {
        super(name, email, dateOfBirth);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
