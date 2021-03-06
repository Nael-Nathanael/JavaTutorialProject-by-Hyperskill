package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int coffee = 120;
    private static int cup = 9;
    private static int money = 550;
    private static boolean running = true;

    public static void main(String[] args) {
        runCommands();
    }
    
    private static void runCommands() {
        while (running) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scanner.nextLine();
            switch (command) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printStatus();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
    }
    
    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cup += scanner.nextInt();
        System.out.println();
    }
    
    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String fokus = scanner.nextLine();
        if (fokus.equalsIgnoreCase("back")) {
            return;
        }
        int type = Integer.parseInt(fokus);
        int waterC, milkC, coffeeC, cupC, moneyC;
        waterC = milkC = coffeeC = cupC = moneyC = 0;
        switch (type) {
            case 1:
                waterC = 250;
                coffeeC = 16;
                cupC = 1;
                moneyC = 4;
                break;
            case 2:
                waterC = 350;
                milkC = 75;
                coffeeC = 20;
                cupC = 1;
                moneyC = 7;
                break;
            case 3:
                waterC = 200;
                milkC = 100;
                coffeeC = 12;
                cupC = 1;
                moneyC = 6;
                break;
            default:
                return;
        }
        if (water >= waterC && milk >= milkC && coffee >= coffeeC && cup >= cupC && money >= moneyC ) {
            water -= waterC;
            milk -= milkC;
            coffee -= coffeeC;
            cup -= cupC;
            money += moneyC;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            if (water < waterC) {                
                System.out.println("Sorry, not enough water!");
            } else if (milk < milkC) {
                System.out.println("Sorry, not enough milk!");
            } else if (coffee < coffeeC) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (cup < cupC) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }
    
    private static void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cup + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }
}