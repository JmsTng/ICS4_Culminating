/*
 * TITLE: MedicalHistory
 * NAME: James Tung
 * DATE: 06/05/2024
 * DESCRIPTION:
 */

import java.io.BufferedReader;
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
        String ward;

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(this.dir + this.path, true));) {
            fw.write(date + "\n");

            switch (this.patient.getWard().getClass()) {
                case Ward.class -> ward = "General";
            }
        } catch (IOException e) {}
    }
}
