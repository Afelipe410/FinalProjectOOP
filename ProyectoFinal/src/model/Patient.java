public class Patient {

    // Attributes
    private int patientId = 0;
    private String name = "";
    private int age = 0;
    private double weight;
    private double height;
    private String preexistingConditions = "";

    // Constructor
    public Patient(int patientId, String name, int age, double weight, double height, String preexistingConditions) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.preexistingConditions = preexistingConditions;
    }

    // Setters and Getters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int newPatientId) {
        patientId = newPatientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String patientName) {
        name = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int patientAge) {
        age = patientAge;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double patientWeight) {
        weight = patientWeight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double patientHeight) {
        height = patientHeight;
    }

    public String getPreexistingConditions() {
        return preexistingConditions;
    }

    public void setPreexistingConditions(String newPreexistingConditions) {
        preexistingConditions = newPreexistingConditions;
    }

}
