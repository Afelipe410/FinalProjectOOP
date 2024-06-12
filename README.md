# FinalProjectOOP
Final Project OOP
Patient: The Patient class represents a patient. Includes methods to register, update, and delete patients.

It has the following attributes: private patientId; private String name; private age; private double weight; double height private; Private String preesxtingConditions;

The constructor of the Patient class initializes the attributes as follows: public Patient(int patientId, string name, int age, double weight, double height, List of pre-existing conditions) { this.patientId = patientId; this.name = name; this.age = age; this.weight = weight; this.height = height; this.preexistingConditions = preexistingconditions; }

The Patient class provides the following methods: getPatientId(): Returns the patient identifier. setName(): Sets the patient name. getName(): Returns the name of the patient. setAge(): sets the age of the patient. getAge(): Returns the age of the patient. setWeight(): Sets the patient's weight. getWeight(): Returns the patient's weight. setHeight(): Sets the height of the patient. getHeight(): Returns the height of the patient. setPreexistingConditions(): Sets the patient's preexisting medical conditions. getPreexistingConditions(): Returns the patient's preexisting medical conditions.

Dietitian class

Dietitian: Contains methods to register and manage nutritionists.

It has the following attributes: private int dietitianId; private String name; private string specialty;

The constructor of the Dietitian class initializes the attributes as follows: public Dietitian(int dietitianId, string name, string specialty) { this.dietistaId = dietitianId; this.name = name; this.specialty = specialty; }

The Dietitian class provides the following methods: getDietitianId(): Returns the ID of the nutritionist. setName(): Sets the name of the nutritionist. getName(): Returns the name of the nutritionist. setSpecialty(): Sets the specialty of the nutritionist. getSpecialty(): Returns the specialty of the nutritionist.

DietPlan: Contains methods for creating and adjusting meal plans.

It has the following attributes: private int planId; private int patientId; private dietitianId; private int dailycalories; Private String macronutrientDistribution; Private String specificRecommendations;

The DietPlan class constructor initializes the attributes as follows: public DietPlan(int planId, intpatientId, int dietitianId, int dailyCalories, macronutrientDistribution, specificRecommendations) { this.planId = planId; this.patientId = patientId; this.dietitianId = dietitianId; this.dailyCalories = daily calories; this.macronutrientDistribution = macronutrientDistribution; this.specificRecommendations = specific recommendations; }

The DietPlan class provides the following methods: getPlanId(): Returns the identifier of the diet plan. setPatientId() – Sets the patient identifier associated with the diet plan. getPatientId(): Returns the patient identifier associated with the diet plan. setDietitianId(): Sets the ID of the nutritionist associated with the diet plan. getDietitianId(): Returns the identifier

Meal: Represents a meal with attributes such as mealId, name, patient Id, macronutrients, calories, and time of day.

It has the following attributes: private int mealId; private String name; Private String macronutrients; private Double calories; private String timeOfDay;

The constructor of the Meal class initializes the attributes as follows: public Meal(int meatId, String name, int patienId, String macronutrients, Double calories, String timeOfDay) { this.mealId = MealId; this.name = name; this.patientId=patientId; this.macronutrients = macronutrients; this.calories = calories; this.timeOfDay = timeOfDay; }

The Meal class provides the following methods: getmealId(): Returns the identifier of the meal. setName(): Sets the name of the meal.getName(): Returns the name of the meal. setMacronutrients(): Sets the macronutrients contained in the meal. getMacronutrients(): Returns the macronutrients contained in the meal. setCalories(): Sets the calories of the meal.getCalories(): Returns the calories of the meal.setTimeOfDay() – Sets the time of day the food should be consumed. getTimeOfDay(): Returns the time of day when the meal should be consumed.

Csv File Manager – Provides methods for reading and writing data to CSV files.

Console Interface: It is responsible for user interaction through the console. Contains methods for managing patients, nutritionists, meals and diet plans.
