package machine;

import java.util.Scanner;

public class CoffeeMachine {
    // Prepare messages
    protected static String msgStart = "Starting to make a coffee\n";
    protected static String msgGrind = "Grinding coffee beans\n";
    protected static String msgBoil = "Boiling water\n";
    protected static String msgMix = "Mixing boiled water with crushed coffee beans\n";
    protected static String msgPourCoffee = "Pouring coffee into the cup\n";
    protected static String msgPourMilk = "Pouring some milk into the cup\n";
    protected static String msgReady = "Coffee is ready!\n";

    public static Scanner scanner = new Scanner(System.in);

    protected static int waterPerCupInmL = 200;
    protected static int milkPerCupInmL = 50;
    protected static int coffeeBeansPerCupInGrams = 15;

    protected static int waterCapacityOfCoffeeMachine;
    protected static int milkCapacityOfCoffeeMachine;
    protected static int coffeeBeansCapacityOfCoffeeMachine;
    protected static int cupsOfCoffeeNeeded;

    protected static int waterNeededInmL;
    protected static int milkNeededInmL;
    protected static int coffeeBeansNeededInGrams;

    protected static boolean enoughWaterInMachine;
    protected static boolean enoughMilkInMachine;
    protected static boolean enoughCoffeeBeansInMachine;

    protected static int cupsPossibleGivenWater;
    protected static int cupsPossibleGivenMilk;
    protected static int cupsPossibleGivenCoffeeBeans;
    protected static int mostCupsGivenIngredients;


    public static void main(String[] args) {

/*
                System.out.print(
                "\n" +
                msgStart +
                msgGrind +
                msgBoil +
                msgMix +
                msgPourCoffee +
                msgPourMilk +
                msgReady
        );

*/

/*

        System.out.println("For " + cupsOfCoffeeNeeded + " cups of coffee you will need:");
        System.out.println(cupsOfCoffeeNeeded * waterPerCupInmL + " mL of water");
        System.out.println(cupsOfCoffeeNeeded * milkPerCupInmL + " mL of milk");
        System.out.println(cupsOfCoffeeNeeded * coffeeBeansInGrams + " g of coffee beans");

*/

        System.out.println("Write how many ml of water the coffee machine has:");
        waterCapacityOfCoffeeMachine = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkCapacityOfCoffeeMachine = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansCapacityOfCoffeeMachine = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        cupsOfCoffeeNeeded = scanner.nextInt();

        // Check if enough ingredients are available, based on cups of coffee needed
        waterNeededInmL = cupsOfCoffeeNeeded * waterPerCupInmL;
        milkNeededInmL = cupsOfCoffeeNeeded * milkPerCupInmL;
        coffeeBeansNeededInGrams = cupsOfCoffeeNeeded * coffeeBeansPerCupInGrams;

        enoughWaterInMachine = waterCapacityOfCoffeeMachine - waterNeededInmL > 0;
        enoughMilkInMachine = milkCapacityOfCoffeeMachine - milkNeededInmL > 0;
        enoughCoffeeBeansInMachine = coffeeBeansCapacityOfCoffeeMachine - coffeeBeansNeededInGrams > 0;

        // Check how many cups of coffee can be made with current Coffee Machine capacity
        cupsPossibleGivenWater = waterCapacityOfCoffeeMachine / waterPerCupInmL;
        cupsPossibleGivenMilk = milkCapacityOfCoffeeMachine / milkPerCupInmL;
        cupsPossibleGivenCoffeeBeans = coffeeBeansCapacityOfCoffeeMachine / coffeeBeansPerCupInGrams;

        mostCupsGivenIngredients = Math.min(cupsPossibleGivenWater,
                Math.min(cupsPossibleGivenMilk, cupsPossibleGivenCoffeeBeans));

        if (mostCupsGivenIngredients > cupsOfCoffeeNeeded) {
            System.out.print("Yes, I can make that amount of coffee (and even ");
            System.out.println(mostCupsGivenIngredients - cupsOfCoffeeNeeded + " more than that)");
        } else if (mostCupsGivenIngredients == cupsOfCoffeeNeeded) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can only make " + mostCupsGivenIngredients + " cup(s) of coffee");
        }
    }
}
