import java.util.Vector;

public class Customer {
    private String name;
    private int accountNum;
    private double balance;
    private Vector<Transaction> userTransactions;

    public Customer(String name, int accountNum) {
        Vector<Transaction> emptyVector = new Vector<>();

        this.name = name;
        this.accountNum = accountNum;
        this.userTransactions = emptyVector;
        this.balance = 0.0;
    }

    public String getName() {
        return this.name;
    }
    
    public void addTransaction(Transaction userAdd) {
        userTransactions.add(userAdd);
        this.balance += userAdd.getAmnt();
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public double getBalance() {
        return this.balance;
    }

    public Vector<Transaction> getTransactions() {
        return this.userTransactions;
    }
}
