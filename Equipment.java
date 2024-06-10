public class Equipment {
    private String name;
    private int quantity;
    private double maintenanceCost;
    private int inUse;
    private Ward wardHoused;

    public Equipment (Ward w, String title, int quant, double maintainCost) {
        wardHoused = w;
        name = title;
        quantity = quant;
        maintenanceCost = maintainCost;
    }


}
