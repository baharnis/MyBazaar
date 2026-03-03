public class Admin extends Employee {

    private String password;

    public Admin(String name, String email, String dateOfBirth, double salary, String password) {
        super(name, email, dateOfBirth, salary);
        this.password = password;
    }

    @Override
    public void displayPersonalData() {
        System.out.println("Admin " + name + " - " + email + " - " + dateOfBirth);
    }

    public String getPassword() {
        return password;
    }
}
