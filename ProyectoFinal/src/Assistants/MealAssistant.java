import java.util.ArrayList;
import java.util.List;

public class MealAssistant {

    private List<Meal> meals = new ArrayList<>();

    // Add meals
    public void addMeal(Meal meal) {
        if (isUniqueId(meal.getMealId())) {
            meals.add(meal);
            Console.writeLine("Comida añadida correctamente. ");
        } else {
            Console.writeLine("Error: Ya existe una comida con esta id.");
        }
    }

    // To know if the meal ID is unique
    public boolean isUniqueId(int id) {
        for (Meal existingMeal : meals) {
            if (existingMeal.getMealId() == id) {
                return false;
            }
        }
        return true;
    }

    // Create Meals
    public Meal createMeal(int mealId, String name, int patientId, String macronutrients, double calories,
            String timeOfDay) {
        return new Meal(mealId, name, patientId, macronutrients, calories, timeOfDay);
    }

    // List to display all meals stored in this
    public List<Meal> getAllMeals() {
        return new ArrayList<>(meals);
    }

}
