import java.util.ArrayList;
import java.util.List;

public class DietitianAssistant {

    private List<Dietitian> dietitians = new ArrayList<>();

    // Add dietitians
    public void addDietitian(Dietitian dietitian) {
        if (isUniqueId(dietitian.getDietitianId())) {
            dietitians.add(dietitian);
            Console.writeLine("Nutricionista añadido correctamente.");
        } else {
            Console.writeLine("Error: Ya existe un nutricionista con esta id.");
        }
    }

    // If the dietitian ID is unique
    public boolean isUniqueId(int id) {
        for (Dietitian existingDietitian : dietitians) {
            if (existingDietitian.getDietitianId() == id) {
                return false;
            }
        }
        return true;
    }

    public Dietitian createDietitian(int dietitianId, String name, String specialty) {
        return new Dietitian(dietitianId, name, specialty);
    }

    // List to display all dietitians stored in this
    public List<Dietitian> getAllDietitians() {
        return new ArrayList<>(dietitians);
    }
}
