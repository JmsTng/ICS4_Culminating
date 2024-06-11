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
}

class Mild extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 1;

    private int symptomPoints = SYMPTOM_BASE_POINTS;


    public Mild(String name) {
        super(name);
    }

    public Mild(String name, String description) {
        super(name, description);
    }

    public Mild(String name, String description, int points) {
        super(name, description);
        this.symptomPoints = points;
    }


    public int getSymptomPoints() {
        return symptomPoints;
    }
}

class Moderate extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 3;

    private int symptomPoints = SYMPTOM_BASE_POINTS;


    public Moderate(String name) {
        super(name);
    }

    public Moderate(String name, String description) {
        super(name, description);
    }

    public Moderate(String name, String description, int points) {
        super(name, description);
        this.symptomPoints = points;
    }


    public int getSymptomPoints() {
        return symptomPoints;
    }
}

class Severe extends Symptom {
    private final int SYMPTOM_BASE_POINTS = 5;

    private int symptomPoints = SYMPTOM_BASE_POINTS;


    public Severe(String name) {
        super(name);
    }

    public Severe(String name, String description) {
        super(name, description);
    }

    public Severe(String name, String description, int points) {
        super(name, description);
        this.symptomPoints = points;
    }


    public int getSymptomPoints() {
        return symptomPoints;
    }
}