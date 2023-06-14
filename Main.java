import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("1: Add a new customer");
        System.out.println("2: Remove a customer");
        System.out.println("3: Make a deposit");
        System.out.println("4: Make a withdrawal");
        System.out.println("5: See customer information");
        System.out.println("6: Display options menu");
        System.out.println("7: Exit");
    }

    public static void main(String[] args) {
        Management console = new Management();
        boolean cont = true;
        int decision;

        displayMenu();

        Scanner sc = new Scanner(System.in);

        while(cont == true) {
            
            System.out.println("What would you like to do? (Enter '6' to see the options menu): ");

            decision = sc.nextInt();
            sc.nextLine();

            if(decision == 1) {
                
                System.out.println("[ADD] Customer name: ");
                String newName = sc.nextLine();
                console.addCustomer(newName);
                
            } else if (decision == 2) {

                System.out.println("[REMOVE] Account number: ");
                int userId = sc.nextInt();
                console.removeCustomer(userId);

            } else if (decision == 3) {
                
                System.out.println("[DEPOSIT] Account number: ");
                int userId = sc.nextInt();
                System.out.println("Transaction amount: ");
                double amount = sc.nextDouble();
                console.deposit(userId, amount);
                
            } else if (decision == 4) {
                
                System.out.println("[WITHDRAW] Account number: ");
                int userId = sc.nextInt();
                System.out.println("Withdrawal amount: ");
                double amount = sc.nextDouble();
                console.withdraw(userId, amount);
                
            } else if (decision == 5) {
                
                System.out.println("[DISP INFO] Account number: ");
                int userId = sc.nextInt();
                for (int i = 0; i < console.getVecSize(); i++) {
                    Customer current = console.getCustomerVec().get(i);
                    if(current.getAccountNum() == userId) {
                        console.seeCustomerActions(current);
                        break;
                    }
                }

            } else if (decision == 6) {

                displayMenu();

            } else if (decision == 7) {

                System.out.println("Goodbye");
                cont = false;

            } else {

                System.out.println("Invalid input");
                displayMenu();

            }

        }
        sc.close();
    }
}
