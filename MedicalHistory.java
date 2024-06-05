/*
 * TITLE: MedicalHistory
 * NAME: James Tung
 * DATE: 06/05/2024
 * DESCRIPTION:
 */

public class MedicalHistory {
    private final String dir = "/medical-histories/";

    private String path;

    private Patient patient;


    public MedicalHistory(Patient patient) {
        this.patient = patient;
        this.path = patient.getName() + patient.getId();
    }


    public void saveRecord(String date)
}
