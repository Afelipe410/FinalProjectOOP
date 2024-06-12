public class Meal {

    // Attributes
    private int mealId = 0;
    private String name = "";
    private int patientId = 0;
    private String macronutrients = "";
    private Double calories = 0.0;
    private String timeOfDay = "";

    // Constructor
    public Meal(int mealId, String name, int patientId, String macronutrients, double calories, String timeOfDay) {
        this.mealId = mealId;
        this.name = name;
        this.patientId = patientId;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }

    // Setters and Getters
    public String getName() {
        return name;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int newMealId) {
        mealId = newMealId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int newPatientId) {
        patientId = newPatientId;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getMacronutrients() {
        return macronutrients;
    }

    public void setMacronutrients(String mealMacronutrients) {
        macronutrients = mealMacronutrients;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double mealCalories) {
        calories = mealCalories;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String mealTimeOfDay) {
        timeOfDay = mealTimeOfDay;
    }

}