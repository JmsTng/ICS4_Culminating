import java.util.Scanner;

/**
 * Admin is a subclass of Staff. They have a log in that is used
 * to verify if the user has the power to change things within
 * the hospital.
 */
class Admin extends Staff {

    /*FIELDS*/
    private String userName;
    private String password;

    /*ACCESSOR AND MUTATORS*/
    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*CONSTRUCTOR*/

    /**
     * Creates a new admin type staff, sets up a username and password
     * that is unique to each admin as a verification step.
     *
     * @param name        The name of the employee housed in a string
     * @param sal         Used to calculate cost to hospital
     * @param overTimeSal Used to calculate cost to hospital
     */
    public Admin(String name, double sal, double overTimeSal) {
        super(name, sal, overTimeSal);
        Scanner sc = new Scanner(System.in);
        userName = getEmployeeNum();
        System.out.print("Password: ");
        password = sc.nextLine();
    }

    /**
     * Prompts for the admins username and password
     * and returns whether it was correct or not.
     *
     * @return Whether the username and password were correct
     */
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        String user, pass;
        System.out.print("Username: ");
        user = sc.nextLine();
        System.out.print("Password: ");
        pass = sc.nextLine();

        return user.equals(userName) && pass.equals(password);
    }

}
