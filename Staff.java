import java.util.*;

public abstract class Staff {

    /*FIELDS*/
    private String name;
    private String employeeNum;
    private double salary;
    private double overtimeSalary;
    private double hoursWorked;
    private double overtimeWorked;

    /*ACCESSOR & MUTATORS*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public void setOvertimeSalary(double overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeWorked() {
        return overtimeWorked;
    }

    public void setOvertimeWorked(double overtimeWorked) {
        this.overtimeWorked = overtimeWorked;
    }

    /*CONSTRUCTOR*/
    public Staff(String name, String employeeNum, double salary, double overtimeSalary) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.salary = salary;
        this.overtimeSalary = overtimeSalary;
        this.hoursWorked = 0;
        this.overtimeWorked = 0;
    }

    /*METHODS*/
    public abstract boolean enterHours(double hours);

    public abstract boolean enterOverTimeHours(double hours);

    public abstract double getMonthlySalary();

}



class Admin extends Staff {

    private String userName;
    private String password;

    public Admin(String name, String num, double sal, double overTimeSal, String password) {
        super(name, num, sal, overTimeSal);
        userName = getEmployeeNum();
        this.password = password;
    }

    public boolean enterHours(double hours) {
        double newHours = this.getHoursWorked() + hours;
        this.setHoursWorked(newHours);
        return true;
    }

    public boolean enterOverTimeHours(double hours) {
        double newHours = this.getOvertimeWorked() + hours;
        this.setOvertimeWorked(newHours);
        return true;
    }

    public double getMonthlySalary() {
        return (this.getSalary() * this.getHoursWorked()) + (this.getOvertimeSalary() * this.getOvertimeWorked());
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        String user, pass;
        System.out.print("UserName: ");
        user = sc.nextLine();
        System.out.print("Password: ");
        pass = sc.nextLine();

        return user.equals(userName) && pass.equals(password);
    }
}
