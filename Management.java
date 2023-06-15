import java.util.Vector;

public class Management {
    private Vector<Customer> customerVec;
    private int nextAccountNum;
    private int vecSize;

    public Management() {
        this.customerVec = new Vector<>();
        this.nextAccountNum = 0;
        this.vecSize = 0;
    }

    public boolean binarySearch(int accountNum) {
        int low = 0;
        int high = customerVec.size() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (accountNum == customerVec.get(mid).getAccountNum()) {
                return true;
            } else if (accountNum < customerVec.get(mid).getAccountNum()) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public void addCustomer(String name) {
        int newAccountNum = nextAccountNum;
        Customer newUser = new Customer(name, newAccountNum);
        customerVec.add(newUser);
        nextAccountNum++;
        vecSize++;
    }

    public void removeCustomer(int accountNum) {
        Vector<Customer> tmpVec = new Vector<>();

        for(int i = 0; i < customerVec.size(); i++) {
            Customer current = customerVec.get(i);
            if (current.getAccountNum() != accountNum) {
                tmpVec.add(current);
            }
        }
        this.customerVec.clear();
        this.customerVec = tmpVec;
        vecSize--;
    }

    public void deposit(int accountNum, double amount) {
        Transaction newAction = new Transaction(amount, "Deposit");

        for(int i = 0; i < customerVec.size(); i++) {
            Customer current = customerVec.get(i);
            if (accountNum == current.getAccountNum()) {
                current.addTransaction(newAction);
                break;
            }
        }
    }

    public void withdraw(int accountNum, double amount) {
        Transaction newAction = new Transaction(amount*(-1), "Withdrawal");

        for(int i = 0; i < customerVec.size(); i++) {
            Customer current = customerVec.get(i);
            if (accountNum == current.getAccountNum()) {
                if ((current.getBalance() - amount) < 0) {
                    System.out.println("Insufficient funds");
                    break;
                }
                current.addTransaction(newAction);
                break;
            }
        }
    }

    public void seeCustomerActions(Customer user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Account Number: " + user.getAccountNum());
        System.out.println("Balance: $" + user.getBalance());
        System.out.println("Transactions: ");

        for(int i = 0; i < user.getTransactions().size(); i++) {
            Transaction current = user.getTransactions().get(i);
            System.out.println("[" + current.getType() + ", " + current.getAmnt() + " - " + current.transactionTime() + "] ");
        }
    }

    public int getVecSize() {
        return this.vecSize;
    }

    public Vector<Customer> getCustomerVec() {
        return this.customerVec;
    }
}
