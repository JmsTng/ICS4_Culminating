import java.util.*;

/**
 * Staff is a base class for all staff personnel within the hospital. It
 * serves as a shell for all general employees and a starting point to those
 * who have greater informational needs.
 * */
public class Staff {

    /*FIELDS*/
    private static int numCount;
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
     * @param salary           Used to calculate cost to hospital
     * @param overtimeSalary   Used to calculate cost to hospital
     * */
    public Staff(String name, double salary, double overtimeSalary) {
        this.name = name;
        this.salary = salary;
        this.overtimeSalary = overtimeSalary;
        this.hoursWorked = 0;
        this.overtimeWorked = 0;
        employeeNum = String.format("%5d", numCount);
        numCount++;
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
     * Allows the user to change specific information about the staff member.
     * */
    public void updateInformation() {
        boolean done = false;
        char choice;
        Scanner sc = new Scanner(System.in);

        while (!done) {
            System.out.println("What information would you like to change:" +
                    "\n0. Name" +
                    "\n1. Salary" +
                    "\n2. Overtime Salary" +
                    "\n3. Add to hours worked" +
                    "\n4. Add to overtime hours worked");
            if (this instanceof Doctor) System.out.println("5. Change speciality\n\n6. Exit");

            do {
                System.out.print("Enter a Choice: ");
                choice = sc.nextLine().charAt(0);
            } while (choice < '0' || choice > '6');

            switch (choice) {
                case '0':
                    System.out.println("Old Name: " + name);
                    System.out.print("New Name: ");
                    setName(sc.nextLine());

                case '1':
                    System.out.printf("Old Salary: %.2f\n", salary);
                    System.out.print("New Salary: ");
                    setSalary(sc.nextDouble());

                case '2':
                    System.out.printf("Old Overtime Salary: %.2f\n", overtimeSalary);
                    System.out.print("New Overtime Salary: ");
                    setOvertimeSalary(sc.nextDouble());

                case '3':
                    System.out.printf("Hours Worked: %.2f", hoursWorked);
                    System.out.print("New Hours: ");
                    enterHours(sc.nextDouble());

                case '4':
                    System.out.printf("Overtime Hours Worked: %.2f", overtimeWorked);
                    System.out.print("New Overtime Hours: ");
                    enterOverTimeHours(sc.nextDouble());

                case '5':
                    if (this instanceof Doctor) {
                        System.out.println("Old Speciality: " + ((Doctor) this).getSpeciality());
                        System.out.print("New Speciality: ");
                        ((Doctor) this).setSpeciality(sc.nextLine());
                    }
                    else done = true;

                default:
                    done = true;
            }
        }
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