import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static PatientAssistant patientAssistant = new PatientAssistant();
    private static DietitianAssistant dietitianAssistant = new DietitianAssistant();
    private static MealAssistant mealAssistant = new MealAssistant();
    private static DietplanAssistant dietplanAssistant = new DietplanAssistant();
    private final String FILE_PATH_PATIENTS = "data/patients.csv";
    private final String FILE_PATH_DIETITIANS = "data/dietitians.csv";
    private final String FILE_PATH_MEALS = "data/meal.csv";
    private final String FILE_PATH_DIETPLAN = "data/diet.csv";
    private CSVCoder<Patient> patientsCoder = null;
    private CSVCoder<Dietitian> dietitiansCoder = null;
    private CSVCoder<DietPlan> dietCoder = null;
    private CSVCoder<Meal> mealCoder = null;

    public Main() {
        initializePatientCoder();
        initializeDietitianCoder();
        initializeMealCoder();
        initializeDietCoder();
    }
    // Load and save info the patients, dietitians, meals, diets

    private void initializePatientCoder() {
        patientsCoder = new CSVCoder<>(';') {
            @Override
            public String[] encode(Patient patient) {
                return new String[] {
                        String.valueOf(patient.getPatientId()),
                        patient.getName(),
                        String.valueOf(patient.getAge()),
                        String.valueOf(patient.getWeight()),
                        String.valueOf(patient.getHeight()),
                        patient.getPreexistingConditions()
                };
            }

            @Override
            public Patient decode(String[] values) {
                int patientId = Integer.parseInt(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                double weight = Double.parseDouble(values[3]);
                double height = Double.parseDouble(values[4]);
                String preexistingConditions = values[5];

                return new Patient(patientId, name, age, weight, height, preexistingConditions);
            }

        };
    }

    private void initializeDietitianCoder() {
        dietitiansCoder = new CSVCoder<>(';') {
            @Override
            public String[] encode(Dietitian dietitian) {
                return new String[] {
                        String.valueOf(dietitian.getDietitianId()),
                        dietitian.getName(),
                        dietitian.getSpecialty()
                };
            }

            @Override
            public Dietitian decode(String[] values) {
                int dietitianID = Integer.parseInt(values[0]);
                String name = values[1];
                String specialty = values[2];

                return new Dietitian(dietitianID, name, specialty);
            }
        };
    }

    private void initializeMealCoder() {
        mealCoder = new CSVCoder<>(';') {
            @Override
            public String[] encode(Meal meal) {
                return new String[] {
                        String.valueOf(meal.getMealId()),
                        meal.getName(),
                        String.valueOf(meal.getPatientId()),
                        meal.getMacronutrients(),
                        String.valueOf(meal.getCalories()),
                        meal.getTimeOfDay()
                };
            }

            @Override
            public Meal decode(String[] values) {
                int mealId = Integer.parseInt(values[0]);
                String name = values[1];
                int patientId = Integer.parseInt(values[2]);
                String macronutrients = values[3];
                double calories = Double.parseDouble(values[4]);
                String timeOfDay = values[5];

                return new Meal(mealId, name, patientId, macronutrients, calories, timeOfDay);
            }
        };
    }

    private void initializeDietCoder() {
        dietCoder = new CSVCoder<>(';') {
            @Override
            public String[] encode(DietPlan dietPlan) {
                return new String[] {
                        String.valueOf(dietPlan.getPlanId()),
                        String.valueOf(dietPlan.getPatientID()),
                        String.valueOf(dietPlan.getDietitianId()),
                        String.valueOf(dietPlan.getDailyCalories()),
                        String.valueOf(dietPlan.getMacronutrientDistribution()),
                        dietPlan.getSpecificRecommendations()
                };
            }

            @Override
            public DietPlan decode(String[] values) {
                int planId = Integer.parseInt(values[0]);
                int patientID = Integer.parseInt(values[1]);
                int dietitianId = Integer.parseInt(values[2]);
                double dailyCalories = Double.parseDouble(values[3]);
                String macronutrientDistribution = values[4];
                String specificRecommendation = values[5];

                return new DietPlan(planId, patientID, dietitianId, dailyCalories, macronutrientDistribution,
                        specificRecommendation);
            }

        };
    }

    public void loadPatientInfo() {
        List<Patient> patients = new ArrayList<>();
        try {
            patientsCoder.readFromFile(FILE_PATH_PATIENTS, patients);
            patientAssistant = new PatientAssistant();
            for (Patient patient : patients) {
                patientAssistant.addPatient(patient);
            }
            Console.writeLine("Información de pacientes cargada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar leer el archivo de pacientes.");
        }
    }

    public void savePatientInfo() {
        try {
            patientsCoder.writeToFile(FILE_PATH_PATIENTS, patientAssistant.getAllPatients());
            Console.writeLine("Información de pacientes guardada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar guardar el archivo de pacientes.");
        }
    }

    public void loadDietitianInfo() {
        List<Dietitian> dietitians = new ArrayList<>();
        try {
            dietitiansCoder.readFromFile(FILE_PATH_DIETITIANS, dietitians);
            dietitianAssistant = new DietitianAssistant();
            for (Dietitian dietitian : dietitians) {
                dietitianAssistant.addDietitian(dietitian);
            }
            Console.writeLine("Información de dietistas cargada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar leer el archivo de dietistas.");
        }
    }

    public void saveDietitianInfo() {
        try {
            dietitiansCoder.writeToFile(FILE_PATH_DIETITIANS, dietitianAssistant.getAllDietitians());
            Console.writeLine("Información de nutricionistas guardada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar guardar el archivo de nutricionistas.");
        }

    }

    public void loadMealInfo() {
        List<Meal> meals = new ArrayList<>();
        try {
            mealCoder.readFromFile(FILE_PATH_MEALS, meals);
            for (Meal meal : meals) {

                mealAssistant.addMeal(meal);
            }
            Console.writeLine("Información de comidas cargada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar leer el archivo de comidas.");
        }
    }

    public void saveMealInfo() {
        try {
            mealCoder.writeToFile(FILE_PATH_MEALS, mealAssistant.getAllMeals());
            Console.writeLine("Información de comidas guardada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar guardar el archivo de comidas.");
        }
    }

    public void loadDietInfo() {
        List<DietPlan> dietPlans = new ArrayList<>();
        try {
            dietCoder.readFromFile(FILE_PATH_DIETPLAN, dietPlans);
            dietplanAssistant = new DietplanAssistant();
            for (DietPlan dietplan : dietPlans) {
                dietplanAssistant.addDiet(dietplan);
            }
            Console.writeLine("Información de dietas cargada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar leer el archivo de dietas.");
        }
    }

    public void saveDietInfo() {
        try {
            dietCoder.writeToFile(FILE_PATH_DIETPLAN, dietplanAssistant.getAllDietPlans());
            Console.writeLine("Información de dietas guardada correctamente.");
        } catch (IOException e) {
            Console.writeLine("Error al intentar guardar el archivo de dietas.");
        }
    }

    public void showMenu() {
        String option = "";

        do {
            // User menu
            Console.writeLine();
            Console.writeLine("------------------------------------------");
            Console.writeLine("BIENVENIDO AL MENU PRINCIPAL");
            Console.writeLine("------------------------------------------");
            Console.writeLine("1.  Agregar un paciente: "); // SI
            Console.writeLine("2.  Actualizar paciente: "); // SI
            Console.writeLine("3.  Eliminar informacion de un paciente: "); // SI
            Console.writeLine("4.  Agregar un nutricionista: "); // SI
            Console.writeLine("5.  Crear plan de alimentacion: "); // SI
            Console.writeLine("6.  Ajustar plan de alimentacion: "); // SI
            Console.writeLine("7.  Crear plan de comidas diarias: "); // SI
            Console.writeLine("8.  Mostrar todos los pacientes: "); // SI
            Console.writeLine("9.  Cargar informacion de los pacientes: "); // SI
            Console.writeLine("10. Guardar informacion de los pacientes : "); // SI
            Console.writeLine("11. Mostrar todos los nutricionistas: "); // SI
            Console.writeLine("12. Cargar Informacion de los Nutricionistas: "); // SI
            Console.writeLine("13. Guardar informacion de los nutricionistas: "); // SI
            Console.writeLine("14. Cargar informacion de las comidas : "); // SI
            Console.writeLine("15. Guardar informacion de las comidas: "); // SI
            Console.writeLine("16. Mostrar todas las comidas: "); // SI
            Console.writeLine("17. Cargar informacion de las dietas: "); // SI
            Console.writeLine("18. Guardar informacion de las dietas: "); // SI
            Console.writeLine("19. Mostrar todas las dietas: "); // SI
            Console.writeLine("0.  Salir");
            Console.writeLine("------------------------------------------");
            Console.writeLine("INGRESE UNA OPCION Y PRESIONE [ENTER]");
            Console.writeLine("------------------------------------------");
            Console.write("OPCION --------> ");
            option = Console.readLine();

            // Options
            switch (option) {

                case "1":
                    addPatient();
                    break;

                case "2":
                    updatePatient();
                    break;

                case "3":
                    removePatient();
                    break;

                case "4":
                    addDietitian();
                    break;

                case "5":
                    addDiet();
                    break;

                case "6":
                    updateDietPlan();
                    break;

                case "7":
                    addmeal();
                    break;

                case "8":
                    showAllPatients();
                    break;

                case "9":
                    loadPatientInfo();
                    break;

                case "10":
                    savePatientInfo();
                    break;

                case "11":
                    showAllDietitians();
                    break;

                case "12":
                    loadDietitianInfo();
                    break;

                case "13":
                    saveDietitianInfo();
                    break;

                case "14":
                    loadMealInfo();
                    break;

                case "15":
                    saveMealInfo();
                    break;

                case "16":
                    showAllMeals();
                    break;

                case "17":
                    loadDietInfo();
                    break;

                case "18":
                    saveDietInfo();
                    break;

                case "19":
                    showAllDiets();
                    break;

                default:
                    if (!option.matches("[0-19]")) {
                        Console.writeLine("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        Console.writeLine("Opcion invalida, intentelo de nuevo");
                        Console.writeLine("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        Console.writeLine();
                    }
            }

        } while (!option.equals("0"));

        Console.writeLine("------------------------------------------");
        Console.writeLine(" Gracias por usar nuestro programa ");
        Console.writeLine("------------------------------------------");
    }

    private void addPatient() {
        Console.writeLine("Ingrese el id del paciente: ");
        int patientId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el nombre del paciente: ");
        String name = Console.readLine();
        Console.writeLine("Ingrese la edad del paciente: ");
        int age = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el peso del paciente: ");
        double weight = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese la altura del paciente: ");
        double height = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese las condiciones preexistentes del paciente: ");
        String preexistingConditions = Console.readLine();

        Patient patient = new Patient(patientId, name, age, weight, height, preexistingConditions);
        patientAssistant.addPatient(patient);
    }

    private static void updatePatient() {
        Console.writeLine("EN CASO DE QUE NO TENGA QUE CAMBIAR NADA INGRESE EL DATO SIN MODIFICAR");
        Console.writeLine("Ingrese el id del paciente: ");
        int patientId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el nuevo nombre del paciente: ");
        String name = Console.readLine();
        Console.writeLine("Ingrese la nueva edad del paciente: ");
        int age = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el nuevo peso del paciente: ");
        double weight = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese la nueva altura del paciente: ");
        double height = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese las nuevas condiciones preexistentes del paciente: ");
        String preexistingConditions = Console.readLine();

        Patient patient = new Patient(patientId, name, age, weight, height, preexistingConditions);
        patientAssistant.updatePatient(patient);
    }

    private static void updateDietPlan() {
        Console.writeLine("EN CASO DE QUE NO TENGA QUE CAMBIAR NADA INGRESE EL DATO SIN MODIFICAR");
        Console.writeLine("Ingrese el id de la dieta: ");
        int planId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el id del paciente: ");
        int patientID = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el id del nutricionista: ");
        int dietitianId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese las calorias de la dieta: ");
        double dailyCalories = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese los macronutrientes de la dieta: ");
        String macronutrientDistribution = Console.readLine();
        Console.writeLine("Ingrese las recomendaciones especificas de la dieta: ");
        String specificRecommendation = Console.readLine();

        DietPlan dietPlan = new DietPlan(planId, patientID, dietitianId, dailyCalories, macronutrientDistribution,
                specificRecommendation);
        dietplanAssistant.updateDietPlan(dietPlan);

    }

    private void showAllPatients() {
        Console.writeLine("PACIENTES:");
        for (Patient patient : patientAssistant.getAllPatients()) {
            Console.writeLine("Nombre: " + patient.getName());
            Console.writeLine("ID: " + patient.getPatientId());
            Console.writeLine("Edad: " + patient.getAge());
            Console.writeLine("Peso: " + patient.getWeight());
            Console.writeLine("Altura: " + patient.getHeight());
            Console.writeLine("Condiciones: " + patient.getPreexistingConditions());
            Console.writeLine("------------------------------------------");
        }
    }

    private void showAllDietitians() {
        Console.writeLine("NUTRICIONISTAS:");
        for (Dietitian dietitian : dietitianAssistant.getAllDietitians()) {
            Console.writeLine("Nombre: " + dietitian.getName());
            Console.writeLine("ID: " + dietitian.getDietitianId());
            Console.writeLine("Especialidad: " + dietitian.getSpecialty());
            Console.writeLine("------------------------------------------");
        }
    }

    private void showAllMeals() {
        Console.writeLine("COMIDAS:");
        for (Meal meal : mealAssistant.getAllMeals()) {
            Console.writeLine("ID de la comida: " + meal.getMealId());
            Console.writeLine("Nombre: " + meal.getName());
            Console.writeLine("ID del paciente: " + meal.getPatientId());
            Console.writeLine("Macronutrientes: " + meal.getMacronutrients());
            Console.writeLine("Calorias: " + meal.getCalories());
            Console.writeLine("Tiempo del dia para comer: " + meal.getTimeOfDay());
            Console.writeLine("------------------------------------------");
        }
    }

    private void showAllDiets() {
        Console.writeLine("DIETAS:");
        for (DietPlan dietPlan : dietplanAssistant.getAllDietPlans()) {
            Console.writeLine("ID de la dieta " + dietPlan.getPlanId());
            Console.writeLine("ID del paciente: " + dietPlan.getPatientID());
            Console.writeLine("ID del nutricionista: " + dietPlan.getDietitianId());
            Console.writeLine("Calorias: " + dietPlan.getDailyCalories());
            Console.writeLine("Distrubucion de macronutrientes: " + dietPlan.getMacronutrientDistribution());
            Console.writeLine("Recomendaciones especificas: " + dietPlan.getSpecificRecommendations());
            Console.writeLine("------------------------------------------");
        }
    }

    private void removePatient() {
        Console.writeLine("Ingrese el ID del paciente a eliminar: ");
        int patientId = Integer.parseInt(Console.readLine());
        patientAssistant.removePatient(patientId);
    }

    private void addDietitian() {
        Console.writeLine("Ingrese el id del nutricionista: ");
        int dietitianId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el nombre del nutricionista: ");
        String name = Console.readLine();
        Console.writeLine("Ingrese la especialidad del nutricionista: ");
        String specialty = Console.readLine();

        Dietitian dietitian = new Dietitian(dietitianId, name, specialty);
        dietitianAssistant.addDietitian(dietitian);
    }

    private void addmeal() {
        Console.writeLine("Ingrese el id de la comida: ");
        int mealId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el nombre de la comida: ");
        String name = Console.readLine();
        Console.writeLine("Ingrese el id del paciente: ");
        int patientId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese los macronutrientes: ");
        String macronutrients = Console.readLine();
        Console.writeLine("Ingrese las calorias: ");
        double calories = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese el tiempo de la comida: ");
        String timeOfDay = Console.readLine();

        Meal meal = new Meal(mealId, name, patientId, macronutrients, calories, timeOfDay);
        mealAssistant.addMeal(meal);
    }

    private void addDiet() {
        Console.writeLine("Ingrese el id de la dieta: ");
        int planId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el id del paciente: ");
        int patientID = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el id del nutricionista: ");
        int dietitianID = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese las calorias: ");
        double dailyCalories = Double.parseDouble(Console.readLine());
        Console.writeLine("Ingrese la distribucion macronutrientes: ");
        String macronutrientDistribution = Console.readLine();
        Console.writeLine("Ingrese las recomendaciones especificas: ");
        String specificRecommendation = Console.readLine();

        DietPlan dietplan = new DietPlan(planId, patientID, dietitianID, dailyCalories, macronutrientDistribution,
                specificRecommendation);
        dietplanAssistant.addDiet(dietplan);
    }

    public static void main(String[] args) {
        new Main().showMenu();
    }
}
