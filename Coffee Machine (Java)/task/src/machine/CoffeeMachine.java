package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        CoffeeMachine tryThis = new CoffeeMachine();
    }

    int cashBalance;
    int machineWaterInmL;
    int machineMilkInmL;
    int machineCoffeeBeansInGrams;
    int machineDisposableCups;

    Scanner scanner = new Scanner(System.in);

    String userAction;
    String buying;

    public int getCashBalance() {
        return cashBalance;
    }

    public int getMachineWaterInmL() {
        return machineWaterInmL;
    }

    public int getMachineMilkInmL() {
        return machineMilkInmL;
    }

    public int getMachineCoffeeBeansInGrams() {
        return machineCoffeeBeansInGrams;
    }

    public int getMachineDisposableCups() {
        return machineDisposableCups;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void setMachineWaterInmL(int machineWaterInmL) {
        this.machineWaterInmL = machineWaterInmL;
    }

    public void setMachineMilkInmL(int machineMilkInmL) {
        this.machineMilkInmL = machineMilkInmL;
    }

    public void setMachineCoffeeBeansInGrams(int machineCoffeeBeansInGrams) {
        this.machineCoffeeBeansInGrams = machineCoffeeBeansInGrams;
    }

    public void setMachineDisposableCups(int machineDisposableCups) {
        this.machineDisposableCups = machineDisposableCups;
    }
    public void buyFromMachine(String buying) {
        switch (buying) {
            case "1" -> { // espresso
                if (!canMakeEspresso()) {
                    outOfSomething("1");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    setMachineWaterInmL(getMachineWaterInmL() - 250);
                    setMachineCoffeeBeansInGrams(getMachineCoffeeBeansInGrams() - 16);
                    setMachineDisposableCups(getMachineDisposableCups() - 1);
                    setCashBalance(getCashBalance() + 4);
                }
            }
            case "2" -> { // latte
                if (!canMakeLatte()) {
                    outOfSomething("2");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    setMachineWaterInmL(getMachineWaterInmL() - 350);
                    setMachineMilkInmL(getMachineMilkInmL() - 75);
                    setMachineCoffeeBeansInGrams(getMachineCoffeeBeansInGrams() - 20);
                    setMachineDisposableCups(getMachineDisposableCups() - 1);
                    setCashBalance(getCashBalance() + 7);
                }
            }
            case "3" -> { // cappuccino
                if(!canMakeCappuccino()) {
                    outOfSomething("3");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    setMachineWaterInmL(getMachineWaterInmL() - 200);
                    setMachineMilkInmL(getMachineMilkInmL() - 100);
                    setMachineCoffeeBeansInGrams(getMachineCoffeeBeansInGrams() - 12);
                    setMachineDisposableCups(getMachineDisposableCups() - 1);
                    setCashBalance(getCashBalance() + 6);
                }
            }
            case "back" -> { // no action taken here
            }
        }
    }


    public boolean canMakeEspresso() {
        return getMachineWaterInmL() >= 250 &&
                getMachineCoffeeBeansInGrams() >= 16 &&
                getMachineDisposableCups() >= 1;
    }

    public boolean canMakeLatte() {
        return getMachineWaterInmL() >= 350 &&
                getMachineMilkInmL() >= 75 &&
                getMachineCoffeeBeansInGrams() >= 20 &&
                getMachineDisposableCups() >= 1;
    }

    public boolean canMakeCappuccino() {
        return  getMachineWaterInmL() >= 200 &&
                getMachineMilkInmL() >= 100 &&
                getMachineCoffeeBeansInGrams() >= 12 &&
                getMachineDisposableCups() >= 1;
    }

    public void outOfSomething(String drinkType) {
        String whatIsMissing = "";
        switch (drinkType) {
            case "1" -> { // espresso
                if (getMachineWaterInmL() < 250) {
                    whatIsMissing = "water!";
                } else if (getMachineCoffeeBeansInGrams() < 16) {
                    whatIsMissing = "coffee beans!";
                } else whatIsMissing = "cups!";
            }
            case "2" -> { // latte
                if (getMachineWaterInmL() < 350) {
                    whatIsMissing = "water!";
                } else if (getMachineMilkInmL() < 75) {
                    whatIsMissing = "milk!";
                } else if (getMachineCoffeeBeansInGrams() < 16) {
                    whatIsMissing = "coffee beans!";
                } else whatIsMissing = "cups!";
            }
            case "3" -> { // cappuccino
                if (getMachineWaterInmL() < 200) {
                    whatIsMissing = "water!";
                } else if (getMachineMilkInmL() < 100) {
                    whatIsMissing = "milk!";
                } else if (getMachineCoffeeBeansInGrams() < 12) {
                    whatIsMissing = "coffee beans!";
                } else whatIsMissing = "cups!";
            }
        }
        System.out.print("Sorry, not enough ");
        System.out.println(whatIsMissing);
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        setMachineWaterInmL(getMachineWaterInmL()
                + scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        setMachineMilkInmL(getMachineMilkInmL()
                + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        setMachineCoffeeBeansInGrams(getMachineCoffeeBeansInGrams() +
                scanner.nextInt());
        System.out.println("Write how many disposable cups you want to add:");
        setMachineDisposableCups(getMachineDisposableCups() +
                scanner.nextInt());
    }

    public void takeFromMachine() {
                System.out.println("I gave you $" + getCashBalance());
                setCashBalance(0);
    }

    public void printMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(getMachineWaterInmL() + " ml of water");
        System.out.println(getMachineMilkInmL() + " ml of milk");
        System.out.println(getMachineCoffeeBeansInGrams() + " g of coffee beans");
        System.out.println(getMachineDisposableCups() + " disposable cups");
        System.out.println("$" + getCashBalance() + " of money");
    }

    public void userInterface() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String userAction = scanner.next();
            switch (userAction) {
                case "buy" -> {
                    System.out.print("What do you want to buy? ");
                    System.out.print("1 - espresso, 2 - latte, ");
                    System.out.println("3 - cappuccino, back - to main menu:");
                    buyFromMachine(scanner.next());
                }
                case "fill" -> {
                    fillMachine();
                }
                case "take" -> {
                    takeFromMachine();
                }
                case "exit" -> {
                    System.exit(0);
                }
                case "remaining" -> {
                    printMachineState();
                }
            }
        }
    }

    private void initCoffeeMachine() {
        machineWaterInmL = 400;
        machineMilkInmL = 540;
        machineCoffeeBeansInGrams = 120;
        machineDisposableCups = 9;
        cashBalance = 550;
    }

    public CoffeeMachine() {
        initCoffeeMachine();
        userInterface();
    }
}

