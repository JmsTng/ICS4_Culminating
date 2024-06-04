public class Patient {
    public final double BASE_COST = 0;
    
    private static int idCount = 0;
    
    private String name;
    private String id;
    
    
    public Patient(String name) {
        this.name = name;
        this.id = ("%0" + 4 + "x").formatted(idCount);
        idCount++;
    }
    
    
}