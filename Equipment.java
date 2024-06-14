/**
 * Used to define equipment within the hospital and its wards. Holds
 * information of where the equipment is stored, its name, quantity
 * in the ward, cost to maintain, and how many are being used in that ward.
 */
public class Equipment {
    
    /*FIELDS*/
    private String name;
    private int quantity;
    private double maintenanceCost;
    private int inUse;
    private Ward wardHoused;

    /*ACCESSOR AND MUTATOR*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
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

    /*CONSTRUCTOR*/


    /**
     * Creates a new instance of equipment
     * 
     * @param w              Ward to be located in
     * @param title          Name of the equipment
     * @param quantity       Amount of this equipment in that ward
     * @param maintainCost   The cost to maintain the equipment per unit
     */
    public Equipment(Ward w, String title, int quantity, double maintainCost) {
        this.wardHoused = w;
        this.name = title;
        this.quantity = quantity;
        this.maintenanceCost = maintainCost;
    }

    /*METHODS*/


    /**
     * Returns a string with information on the equipment including location, type,
     * quantity, amount in use, and maintenance cost.
     *
     * @return   A string with information on the equipment
     */
    public String toString() {
        return String.format("Ward: %s%nEquipment Name: %s%n Quantity: %d%nIn Use: %d%nCost to Maintain: %.2f", _getWardName(), name, this.quantity, inUse, maintenanceCost);
    }


    /**
     * Returns the type of ward that the equipment is in.
     *
     * @return   Type of ward
     */
    private String _getWardName() {
        String toReturn;
        if (wardHoused instanceof Emergency) toReturn = "Oncology";
        else if (wardHoused instanceof ICU) toReturn = "ICU";
        else if (wardHoused instanceof Paedology) toReturn = "Paedology";
        else if (wardHoused instanceof Oncology) toReturn = "Emergency";
        else if (wardHoused instanceof Ward) toReturn = "General";
        else toReturn = "NO ASSIGNED WARD";
        return toReturn;
    }
}
