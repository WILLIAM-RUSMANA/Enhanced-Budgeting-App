import java.util.*;

public class Budget {
    private double amount;
    private int month;  // 1-12
    private int year;
    private HashMap<String, Double> categoryAllocation = new HashMap<>();

    public Budget(int year, int month) {
        this.amount = 0;
        this.month = month;
        this.year = year;
    }

    public Budget(double amount, int year, int month) {
        this.amount = amount;
        this.month = month;
        this.year = year;
    }

    public void allocate() {
        if (true) {}
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getYearMonth() {
        return this.year + " " + this.month;
    }

    // Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
