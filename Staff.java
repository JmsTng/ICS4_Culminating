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

    public boolean matchName(String name) {
        if (name == null) return false;

        for (int i = 0; i < name.length(); i++) {
            if (this.name.charAt(i) != name.charAt(i)) return false;
        }
        return true;
    }

    public boolean matchEmployeeNum(String num) {
        if (num == null || employeeNum.length() != num.length()) return false;

        for (int i = 0; i < employeeNum.length(); i++) {
            if(employeeNum.charAt(i) != num.charAt(i)) return false;
        }
        return true;
    }

    public int compareName(Staff s) {
        return this.name.compareToIgnoreCase(s.getName());
    }

    public int compareId(Staff s) {
        return this.employeeNum.compareToIgnoreCase(s.getEmployeeNum());
    }

    public double compareSalary(Staff s) {
        return this.salary - s.getSalary();
    }

    public String toString() {
        return String.format("Name: %s\nEmployee Number: %s\nSalary: %2.2f\nHours Worked: %.2f\nOvertime Salary: %2.2f\nOvertime Hours Worked: %.2f", name, employeeNum, salary, hoursWorked, overtimeSalary, overtimeWorked);
    }

}



class Admin extends Staff {

    private String userName;
    private String password;

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
