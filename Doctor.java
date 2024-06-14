/**
 * Subclass of Medical and Staff. Holds information on speciality
 * for Medical staff who are doctors and resets some values.
 */
public class Doctor extends Medical {

    /*FIELDS*/
    private String speciality;

    public int patientCap = 5;

    /*CONSTRUCTOR*/

    /**
     * Creates a new doctor staff member.
     *
     * @param name             The name of the employee housed in a string
     * @param employeeNum      Employee number that is unique to each separate employee
     * @param salary           Used to calculate cost to hospital
     * @param overtimeSalary   Used to calculate cost to hospital
     * @param speciality       Speciality of the Doctor, used in assigning staff
     */
    public Doctor (String name, String employeeNum, double salary, double overtimeSalary, String speciality) {
        super (name, employeeNum, salary, 0);
        this.speciality = speciality;
    }

    /*ACCESSOR AND MUTATOR*/
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String s) {
        speciality = s;
    }

    /*METHODS*/

    /**
     * Returns a String with all staff and medical staff information
     * plus the speciality of the doctor.
     *
     * @return   String with information on the Doctor
     */
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality;
    }

}
