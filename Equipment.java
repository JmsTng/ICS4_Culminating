public class Equipment {
    private String name;
    private int quantity;
    private double maintenanceCost;
    private int inUse;
    private Ward wardHoused;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInUse() {
        return inUse;
    }

    public void setInUse(int inUse) {
        this.inUse = inUse;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public Ward getWardHoused() {
        return wardHoused;
    }

    public void setWardHoused(Ward wardHoused) {
        this.wardHoused = wardHoused;
    }

    public Equipment (Ward w, String title, int quant, double maintainCost) {
        this.wardHoused = w;
        this.name = title;
        this.quantity = quant;
        this.maintenanceCost = maintainCost;
    }

}
