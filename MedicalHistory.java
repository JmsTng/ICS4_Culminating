import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(this.dir + this.path, true));) {
            fw.write(date + "\n");

            if (ward instanceof Emergency) { fw.write("Emergency"); }
            else if (ward instanceof Oncology) { fw.write("Oncology"); }
        } catch (IOException e) {}
    }
}
