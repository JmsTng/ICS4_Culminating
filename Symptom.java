public abstract class Symptom {
    private String name;
    private String description;
    

    public Symptom(String name) {
        this.name = name;
    }

    public Symptom(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract double getCost();

    public abstract int getTriage();

    public abstract String toString(); // Added for file writing
}

class Mild extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 1;
    private final double BASE_COST = 25;


    public Mild(String name) {
        super(name);
    }

    public Mild(String name, String description) {
        super(name, description);
    }


    public double getCost() {
        return BASE_COST;
    }

    public int getTriage() {
        return SYMPTOM_BASE_POINTS;
    }

    public String toString() {
        // Severity, Name[, Description]
        return "1," + this.getName() + (this.getDescription() == null ? "" : "," + this.getDescription());
    }
}

class Moderate extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 3;
    private final double BASE_COST = 70;


    public Moderate(String name) {
        super(name);
    }

    public Moderate(String name, String description) {
        super(name, description);
    }


    public double getCost() {
        return BASE_COST;
    }

    public int getTriage() {
        return SYMPTOM_BASE_POINTS;
    }

    public String toString() {
        // Severity, Name[, Description]
        return "2," + this.getName() + (this.getDescription() == null ? "" : "," + this.getDescription());
    }
}

class Severe extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 5;
    private final double BASE_COST = 200;


    public Severe(String name) {
        super(name);
    }

    public Severe(String name, String description) {
        super(name, description);
    }


    public double getCost() {
        return BASE_COST;
    }

    public int getTriage() {
        return SYMPTOM_BASE_POINTS;
    }

    public String toString() {
        // Severity, Name[, Description]
        return "3," + this.getName() + (this.getDescription() == null ? "" : "," + this.getDescription());
    }
}
