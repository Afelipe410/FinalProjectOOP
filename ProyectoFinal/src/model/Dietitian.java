public class Dietitian {

    // Attributes
    private int dietitianId = 0;
    private String name = "";
    private String specialty = "";

    // Constructor
    public Dietitian(int dietitianId, String name, String specialty) {
        this.dietitianId = dietitianId;
        this.name = name;
        this.specialty = specialty;

    }

    // Setters and Getters
    public int getDietitianId() {
        return dietitianId;
    }

    public void setDietitianId(int newDietitianId) {
        dietitianId = newDietitianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newDietitianName) {
        name = newDietitianName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String newDietitianSpecialty) {
        specialty = newDietitianSpecialty;
    }
}
