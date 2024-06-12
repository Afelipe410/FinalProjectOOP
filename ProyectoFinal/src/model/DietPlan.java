public class DietPlan {

    // Attributes
    private int planId = 0;   
    private int patientID = 0;
    private int dietitianId = 0;
    private double dailyCalories = 0.0;
    private String macronutrientDistribution = "";
    private String specificRecommendations = "";

    // Constructor
    public DietPlan(int planId, int PatientID, int dietitianID, double dailyCalories,
            String macronutrientDistribution, String specificRecommendations) {
        this.planId = planId;
        this.patientID = PatientID;
        this.dietitianId = dietitianID;
        this.dailyCalories = dailyCalories;
        this.macronutrientDistribution = macronutrientDistribution;
        this.specificRecommendations = specificRecommendations;
    }

    // Setters and Getters
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int newPlanId) {
        planId = newPlanId;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientId(int newPatientID) {
        patientID = newPatientID;
    }

    public int getDietitianId() {
        return dietitianId;
    }

    public void setDietitianId(int newDietitian) {
        dietitianId = newDietitian;
    }

    public double getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(double newDailyCalories) {
        dailyCalories = newDailyCalories;
    }

    public String getMacronutrientDistribution() {
        return macronutrientDistribution;
    }

    public void setMacronutrientDistribution(String newMacronutrientDistribution) {
        macronutrientDistribution = newMacronutrientDistribution;
    }

    public String getSpecificRecommendations() {
        return specificRecommendations;
    }

    public void setSpecificRecommendations(String newSpecificRecommendations) {
        specificRecommendations = newSpecificRecommendations;
    }
}
