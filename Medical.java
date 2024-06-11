import java.util.ArrayList;

public class Medical extends Staff {

    private static int patientCap = 10;
    private int patientNum;
    private ArrayList<Patient> patients;
    private Ward ward;

    public Medical (String name, String employeeNum, double salary, double overtimeSalary) {
        super (name, employeeNum, salary, overtimeSalary);
        patientNum = 0;
        patients = new ArrayList<Patient>();
    }

    public void changePatientCap (int newCap) {
        patientCap = newCap;
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

    public boolean addPatient (String id, Patient[] patientList) {
        if (patientNum < patientCap) {
            for (int i = 0; i < patientList.length; i++) {
                if (patientList[i].getId().equals(id)) {
                    patients.add(patientList[i]);
                    patientNum++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removePatient (String id) {
        for (int i = 0; i < patientNum; i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.remove(i);
                patientNum--;
                return true;
            }
        }
        return false;
    }

    public boolean setWard (Ward w) {
        if (w.addStaff(this)) {
            ward = w;
            return true;
        } else {
            return false;
        }
    }

    public boolean useEquipment(String name, int quant) {
        Equipment e = ward.getEquipment(name);
        if (e == null) return false;

        if ((e.getInUse() + quant) <= e.getQuantity()) {
            e.setInUse(e.getInUse()+quant);
            return true;
        }
        else return false;
    }

    public String toString() {
        super.toString() + "\nWard: " + ward.get
    }

    private String _getWardName() {
        String toReturn;
        if (ward instanceof Oncology) toReturn = "Oncology";
        else if (ward instanceof ICU) toReturn = "ICU";
        else if (ward instanceof Paedology) toReturn = "Paedology";
        else if
    }
}

class Doctor extends Medical {

    private String speciality;

    public static int patientCap = 5;

    public Doctor (String name, String employeeNum, double salary, double overtimeSalary, String speciality) {
        super (name, employeeNum, salary, overtimeSalary);
        this.speciality = speciality;
    }

    public void setSpeciality(String s) {
        speciality = s;
    }

}
