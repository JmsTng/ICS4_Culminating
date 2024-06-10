public class Hospital {
    public final int MAX_WARDS;
    public final int PATIENT_CAP;
    public final int STAFF_CAP;

    private String name;
    private double budget;
    private int numWards;
    private int numPatients;
    private int numStaff;
    
    private Equipment[] equipment;
    private Patient[] patients;
    private Staff[] staff;
    private Ward[] wards;

    public Hospital(int maxWards, int patientCap, int staffCap, String name, double budget, int numWards, int numPatients, int numStaff) {
        MAX_WARDS = maxWards;
        PATIENT_CAP = patientCap;
        STAFF_CAP = staffCap;
        this.name = name;
        this.budget = budget;
        this.numWards = numWards;
        this.numPatients = numPatients;
        this.numStaff = numStaff;
    }

    public void createWard() {
        ...
    }
    
    public void destroyWard() {
        ...
    }
    
    public void addStaff() {
        ...
    }
    
    public void removeStaff() {
        ...
    }
    
    public void addEquipment() {
        ...
    }
    
    public void removeEquipment() {
        ...
    }
    
    public void addPatient() {
        ...
    }
    
    public void removePatient() {
        ...
    }
    
    public Patient searchPatient() {
        ...
    }
    
    public Staff searchStaff() {
        ...
    }
    
    public Equipment searchEquipment() {
        ...
    }
    
    public Patient[] sortPatient() {
        ...
    }
    
    public Staff[] sortStaff() {
        ...
    }
    
    public double calculateProfit() {
        ...
    }
    
    
    private void assignEquipment() {
        ...
    }
}