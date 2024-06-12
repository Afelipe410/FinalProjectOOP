import java.util.ArrayList;
import java.util.List;

public class DietplanAssistant {

    private List<DietPlan> DietPlans = new ArrayList<>();

    // Update patient information
    public void updateDietPlan(DietPlan dietPlan) {
        DietPlan existingDiet = findDietById(dietPlan.getPlanId());

        if (existingDiet != null) {
            existingDiet.setPatientId(dietPlan.getPatientID());
            existingDiet.setDietitianId(dietPlan.getDietitianId());
            existingDiet.setDailyCalories(dietPlan.getDailyCalories());
            existingDiet.setMacronutrientDistribution(dietPlan.getMacronutrientDistribution());
            existingDiet.setSpecificRecommendations(dietPlan.getSpecificRecommendations());
            Console.writeLine("Dieta actualizada correctamente.");
        } else {
            Console.writeLine("Error: No se encontro una dieta con esta id.");
        }
    }

    // Add Dietplans
    public void addDiet(DietPlan dietPlan) {
        if (isUniqueId(dietPlan.getPlanId())) {
            DietPlans.add(dietPlan);
            Console.writeLine("Dieta añadida correctamente. ");
        } else {
            Console.writeLine("Error: Ya existe una dieta con esta id.");
        }
    }

    // To know if the DietPlan ID is unique
    public boolean isUniqueId(int id) {
        for (DietPlan existingDiet : DietPlans) {
            if (existingDiet.getPlanId() == id) {
                return false;
            }
        }
        return true;
    }

    // find the diet by id
    private DietPlan findDietById(int planId) {
        for (DietPlan dietPlan : DietPlans) {
            if (dietPlan.getPlanId() == planId) {
                return dietPlan;
            }
        }
        return null;
    }

    // Create DietPlan
    public DietPlan createDiet(int planId, int patientID, int dietitianId, double dailyCalories,
            String macronutrientDistribution, String specificRecommendations) {
        return new DietPlan(planId, patientID, dietitianId, dailyCalories, macronutrientDistribution,
                specificRecommendations);
    }

    // List to display all DietPlans stored in this
    public List<DietPlan> getAllDietPlans() {
        return new ArrayList<>(DietPlans);
    }

}
