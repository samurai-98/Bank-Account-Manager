import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("1: Add a new customer");
        System.out.println("2: Remove a customer");
        System.out.println("3: See customer balance");
        System.out.println("4: Make a deposit");
        System.out.println("5: Make a withdrawal");
        System.out.println("6: See customer information");
        System.out.println("7: Display options menu");
        System.out.println("8: Exit");
    }

    public static void main(String[] args) {
        Management console = new Management();
        boolean cont = true;
        int decision;

        displayMenu();

        Scanner sc = new Scanner(System.in);

        while(cont) {
            
            System.out.println("What would you like to do? (Enter '7' to see the options menu): ");

            try {
                decision = sc.nextInt();
                sc.nextLine();

                if (decision < 1 || decision > 8) {
                    System.out.println("Invalid input. Please enter an integer between 1 and 8");
                    continue;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer between 1 and 8");
                sc.nextLine();
                continue;
            }

            if(decision == 1) {
                
                System.out.println("[ADD] Customer name: ");
                String newName = sc.nextLine();
                console.addCustomer(newName);
                
            } else if (decision == 2) {

                System.out.println("[REMOVE] Account number: ");
                int userId = sc.nextInt();
                if (!console.binarySearch(userId)) {
                    System.out.println("Account number not found");
                } else {
                    console.removeCustomer(userId);
                }

            } else if (decision == 3) {
                System.out.println("[BALANCE] Account number: ");
                int userId = sc.nextInt();
                if (!console.binarySearch(userId)) {
                    System.out.println("Account number not found");
                } else {
                    for (int i = 0; i < console.getVecSize(); i++) {
                        Customer current = console.getCustomerVec().get(i);
                        if(current.getAccountNum() == userId) {
                            System.out.println("Name: " + current.getName() + "\n" + "Account number: " + current.getAccountNum() + "\n" + "Balance: $" + current.getBalance());
                            break;
                        }
                    }
                }
            } else if (decision == 4) {
                
                System.out.println("[DEPOSIT] Account number: ");
                int userId = sc.nextInt();
                if (!console.binarySearch(userId)) {
                    System.out.println("Account number not found");
                } else {
                    System.out.println("Transaction amount: ");
                    double amount = sc.nextDouble();
                    console.deposit(userId, amount);
                }
                
                
            } else if (decision == 5) {
                
                System.out.println("[WITHDRAW] Account number: ");
                int userId = sc.nextInt();
                if (!console.binarySearch(userId)) {
                    System.out.println("Account number not found");
                } else {
                    System.out.println("Withdrawal amount: ");
                    double amount = sc.nextDouble();
                    console.withdraw(userId, amount);
                }
                
                
            } else if (decision == 6) {
                
                System.out.println("[DISP INFO] Account number: ");
                int userId = sc.nextInt();
                if (!console.binarySearch(userId)) {
                    System.out.println("Account number not found");
                } else {
                    for (int i = 0; i < console.getVecSize(); i++) {
                        Customer current = console.getCustomerVec().get(i);
                        if(current.getAccountNum() == userId) {
                            console.seeCustomerActions(current);
                            break;
                        }
                    }
                }
                
            } else if (decision == 7) {

                displayMenu();

            } else if (decision == 8) {

                System.out.println("Goodbye");
                cont = false;

            } else {

                System.out.println("Invalid input. Please enter an integer between 1 and 8");
                displayMenu();

            }

        }
        sc.close();
    }
}
