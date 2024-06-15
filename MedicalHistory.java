import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MedicalHistory {
    private final String dir = "/medical-histories/";

    private String path;

    private Patient patient;


    public MedicalHistory(Patient patient) {
        this.patient = patient;
        this.path = patient.getName() + patient.getId();
    }


    public void saveRecord(String date) {
        Ward ward = this.patient.getWard();
        ArrayList<Symptom> symptoms = this.patient.getSymptoms();
        ArrayList<Medical> staff = this.patient.getMedicalPersonnel();

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(this.dir + this.path, true));) {
            fw.write(date + "\n");

            // TODO: Needs fixing
            if (ward instanceof Emergency) { fw.write("Emergency"); }
            else if (ward instanceof ICU) { fw.write("ICU"); }
            else if (ward instanceof Oncology) { fw.write("Oncology"); }
            else if (ward instanceof Paedology) { fw.write("Paedology"); }
            else if (ward instanceof Ward) { fw.write("General"); }

            fw.write("%d".formatted(symptoms.size()));
            for (Symptom s : symptoms) {
                fw.write(s.toString());
            }

            fw.write("%d".formatted(staff.size()));
            for (Medical s : staff) {
                fw.write(s.getEmployeeNum());
                fw.write(s.getName());
            }
        } catch (IOException e) {}
    }
}
