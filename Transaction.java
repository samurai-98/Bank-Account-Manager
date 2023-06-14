import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amnt;
    private String dateTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaction(double amount, String type) {
        LocalDateTime currentTime = LocalDateTime.now();

        this.type = type;
        this.amnt = amount;
        this.dateTime = currentTime.format(formatter);
    }

    public double getAmnt() {
        return this.amnt;
    }

    public String transactionTime() {
        return this.dateTime;
    }

    public String getType() {
        return this.type;
    }
}
