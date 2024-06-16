/*
 * Symptom.java
 * James Tung
 * June 7th, 2024
 */

/**
 * This abstract class represents a Symptom in a hospital management system.
 * It contains information about the symptom's name and description.
 */
public abstract class Symptom {
    private String name; // The name of the symptom
    private String description; // The description of the symptom

    /**
     * Constructs a Symptom object with a name.
     * @param name the name of the Symptom
     */
    public Symptom(String name) {
        this.name = name;
    }

    /**
     * Constructs a Symptom object with a name and description.
     * @param name the name of the Symptom
     * @param description the description of the Symptom
     */
    public Symptom(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Retrieve the Symptom's name.
     * @return the name of the Symptom
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the Symptom's description.
     * @return the description of the Symptom
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieve the cost of the Symptom.
     * This method is abstract and must be implemented by subclasses.
     * @return the cost of the Symptom
     */
    public abstract double getCost();

    /**
     * Retrieve the triage points of the Symptom.
     * This method is abstract and must be implemented by subclasses.
     * @return the triage points of the Symptom
     */
    public abstract int getTriage();

    /**
     * Convert the Symptom to a String.
     * This method is abstract and must be implemented by subclasses.
     * @return the Symptom as a String
     */
    public abstract String toString(); // Added for file writing
}

/**
 * This class represents a Mild Symptom in a hospital management system.
 * It extends the Symptom class and overrides its abstract methods.
 */
class Mild extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 1; // The base triage points for a mild symptom
    private final double BASE_COST = 25; // The base cost for a mild symptom

    /**
     * Constructs a Mild Symptom object with a name.
     * @param name the name of the Symptom
     */
    public Mild(String name) {
        super(name);
    }

    /**
     * Constructs a Mild Symptom object with a name and description.
     * @param name the name of the Symptom
     * @param description the description of the Symptom
     */
    public Mild(String name, String description) {
        super(name, description);
    }

    /**
     * Retrieve the cost of the Mild Symptom.
     * @return the cost of the Symptom
     */
    public double getCost() {
        return BASE_COST;
    }

    /**
     * Retrieve the triage points of the Mild Symptom.
     * @return the triage points of the Symptom
     */
    public int getTriage() {
        return SYMPTOM_BASE_POINTS;
    }

    /**
     * Convert the Mild Symptom to a String.
     * @return the Symptom as a String
     */
    public String toString() {
        // Severity, Name[, Description]
        return "1," + this.getName() + (this.getDescription() == null ? "" : ("," + this.getDescription()));
    }
}

/**
 * This class represents a Moderate Symptom in a hospital management system.
 * It extends the Symptom class and overrides its abstract methods.
 */
class Moderate extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 3; // The base triage points for a moderate symptom
    private final double BASE_COST = 70; // The base cost for a moderate symptom

    /**
     * Constructs a Moderate Symptom object with a name.
     * @param name the name of the Symptom
     */
    public Moderate(String name) {
        super(name);
    }

    /**
     * Constructs a Moderate Symptom object with a name and description.
     * @param name the name of the Symptom
     * @param description the description of the Symptom
     */
    public Moderate(String name, String description) {
        super(name, description);
    }

    /**
     * Retrieve the cost of the Moderate Symptom.
     * @return the cost of the Symptom
     */
    public double getCost() {
        return BASE_COST;
    }

    /**
     * Retrieve the triage points of the Moderate Symptom.
     * @return the triage points of the Symptom
     */
    public int getTriage() {
        return SYMPTOM_BASE_POINTS;
    }

    /**
     * Convert the Moderate Symptom to a String.
     * @return the Symptom as a String
     */
    public String toString() {
        // Severity, Name[, Description]
        return "2," + this.getName() + (this.getDescription() == null ? "" : ("," + this.getDescription()));
    }
}

/**
 * This class represents a Severe Symptom in a hospital management system.
 * It extends the Symptom class and overrides its abstract methods.
 */
class Severe extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 5; // The base triage points for a severe symptom
    private final double BASE_COST = 200; // The base cost for a severe symptom

    /**
     * Constructs a Severe Symptom object with a name.
     * @param name the name of the Symptom
     */
    public Severe(String name) {
        super(name);
    }

    /**
     * Constructs a Severe Symptom object with a name and description.
     * @param name the name of the Symptom
     * @param description the description of the Symptom
     */
    public Severe(String name, String description) {
        super(name, description);
    }

    /**
     * Retrieve the cost of the Severe Symptom.
     * @return the cost of the Symptom
     */
    public double getCost() {
        return BASE_COST;
    }

    /**
     * Retrieve the triage points of the Severe Symptom.
     * @return the triage points of the Symptom
     */
    public int getTriage() {
        return SYMPTOM_BASE_POINTS;
    }

    /**
     * Convert the Severe Symptom to a String.
     * @return the Symptom as a String
     */
    public String toString() {
        // Severity, Name[, Description]
        return "3," + this.getName() + (this.getDescription() == null ? "" : ("," + this.getDescription()));
    }
}