public class Technician extends Employee {

    private boolean senior;

    public Technician(String name, String email, String dateOfBirth, double salary, boolean senior) {
        super(name, email, dateOfBirth, salary);
        this.senior = senior;
    }

    public boolean isSenior() {
        return senior;
    }
}
