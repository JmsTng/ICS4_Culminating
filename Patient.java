import java.util.ArrayList;
import Staff.Medical;

public class Patient {
    public final double BASE_COST = 0;
    
    private static int idCount = 0;
    
    private String name;
    private String id;
    private ArrayList<Symptom> symptoms;
    private ArrayList<Medical> medicalPersonnel;
    private Ward ward;

    
    public Patient(String name) {
        this.name = name;
        this.id = ("%0" + 5 + "x").formatted(idCount); // Stores 1048576 patients
        idCount++;
        symptoms = new ArrayList<Symptom>();
        medicalPersonnel = new ArrayList<Medical>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Medical> getMedicalPersonnel() {
        return medicalPersonnel;
    }

    public ArrayList<Symptom> getSymptoms() {
        return symptoms;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }


    public boolean addSymptom(int severity, String name, String description) {
        switch (severity) {
            case 0 -> { symptoms.add(new Mild(name, description)); }
            case 1 -> { symptoms.add(new Moderate(name, description)); }
            case 2 -> { symptoms.add(new Severe(name, description)); }
            default -> {
                System.out.println("Invalid severity level.");
                return false;
            }
        }

        return true;
    }

    public boolean addSymptom(int severity, String name) {
        switch (severity) {
            case 0 -> { symptoms.add(new Mild(name)); }
            case 1 -> { symptoms.add(new Moderate(name)); }
            case 2 -> { symptoms.add(new Severe(name)); }
            default -> {
                System.out.println("Invalid severity level.");
                return false;
            }
        }

        return true;
    }

    public boolean removeSymptom(String name) {
        int i = _searchSymptom(name);

        if (i != -1) {
            symptoms.remove(i);
            return true;
        }

        return false;
    }

    public boolean assignWard(Ward ward) {
        return ward.addPatient(this);
    }




    private int _searchSymptom(String name) {  // Added to assist in finding symptoms to delete
        for (int i = 0; i < symptoms.size(); i++) {
            if (symptoms.get(i).getName().equals(name)) return i;
        }

        return -1;
    }
}