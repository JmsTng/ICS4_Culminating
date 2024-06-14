/**
 * Staff is a base class for all staff personnel within the hospital. It
 * serves as a shell for all general employees and a starting point to those
 * who have greater informational needs.
 * */
public class Staff {

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

    /**
     * Creates a new Staff member using inputted parameters to designate a name,
     * employee number, salary, as well as an overtime salary.
     *
     * @param name             The name of the employee housed in a string
     * @param employeeNum      Employee number that is unique to each separate employee
     * @param salary           Used to calculate cost to hospital
     * @param overtimeSalary   Used to calculate cost to hospital
     * */
    public Staff(String name, String employeeNum, double salary, double overtimeSalary) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.salary = salary;
        this.overtimeSalary = overtimeSalary;
        this.hoursWorked = 0;
        this.overtimeWorked = 0;
    }

    /*METHODS*/

    /**
     * Adds to the hours that this staff member has worked
     *
     * @param hours   The amount of hours to add to the staffs worked hours
     *
     * @return        Whether the hours have been successfully added
     * */
    public boolean enterHours(double hours) {
        double newHours = this.getHoursWorked() + hours;
        this.setHoursWorked(newHours);
        return true;
    }

    /**
     * Adds to the overtime hours that this staff member has worked
     *
     * @param hours   The amount of hours to add to the staffs worked hours
     *
     * @return        Whether the hours have been successfully added
     * */
    public boolean enterOverTimeHours(double hours) {
        double newHours = this.getOvertimeWorked() + hours;
        this.setOvertimeWorked(newHours);
        return true;
    }

    /**
     * Calculates the monthly salary of the Staff using the inputted hours and salaries
     *
     * @return the income of the staff member
     * */
    public double getMonthlySalary() {
        return (this.getSalary() * this.getHoursWorked()) + (this.getOvertimeSalary() * this.getOvertimeWorked());
    }

    /**
     * Returns whether 2 names are the same or similar
     *
     * @param name   The name to match to this staff members name
     *
     * @return       Whether the 2 names match
     * */
    public boolean matchName(String name) {
        if (name == null) return false;

        for (int i = 0; i < name.length(); i++) {
            if (this.name.charAt(i) != name.charAt(i)) return false;
        }
        return true;
    }


    /**
     * Returns whether 2 employee numbers are the same
     *
     * @param num   The employee number to match to this staff members
     *
     * @return       Whether the 2 numbers match
     * */
    public boolean matchEmployeeNum(String num) {
        if (num == null || employeeNum.length() != num.length()) return false;

        for (int i = 0; i < employeeNum.length(); i++) {
            if(employeeNum.charAt(i) != num.charAt(i)) return false;
        }
        return true;
    }

    /**
     * Returns the difference between this staff members name and another
     *
     * @param s   The staff member to compare to
     *
     * @return    The difference between the 2 names as dictated by compareToIgnoreCase()
     * */
    public int compareName(Staff s) {
        return this.name.compareToIgnoreCase(s.getName());
    }

    /**
     * Returns the difference between this staff members employee number and another
     *
     * @param s   The staff member to compare to
     *
     * @return    The difference between the 2 numbers as dictated by compareToIgnoreCase()
     * */
    public int compareEmployeeNum(Staff s) {
        return this.employeeNum.compareToIgnoreCase(s.getEmployeeNum());
    }

    /**
     * Returns the difference between this staff members salary and another, only calculates
     * for normal salary.
     *
     * @param s   The staff member to compare to
     *
     * @return    The difference between the 2 salary's as dictated by compareToIgnoreCase()
     * */
    public double compareSalary(Staff s) {
        return this.salary - s.getSalary();
    }

    /**
     * Resets the number of hours worked in both overtime and regular to 0.
     *
     * @return whether the hours have been reset
     * */
    public boolean resetHours() {
        overtimeWorked = 0;
        hoursWorked = 0;
        return overtimeWorked == 0 && hoursWorked == 0;
    }

    /**
     * Returns a string containing name, number, salary, and hourly information when the staff
     * member is to be printed.
     *
     * @return   A string with information on the staff
     * */
    public String toString() {
        return String.format("Name: %s\nEmployee Number: %s\nSalary: %2.2f\nHours Worked: %.2f\nOvertime Salary: %2.2f\nOvertime Hours Worked: %.2f", name, employeeNum, salary, hoursWorked, overtimeSalary, overtimeWorked);
    }

}