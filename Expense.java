public class Expense {
    private double amount;
    private double month;
    private double year;
    private double date;
    private String description;

    public Expense(int year, int month) {
        this.amount = 0;
        this.year = year;
        this.month = month;
        this.date = 0;
        this.description = "";
    }

    public Expense(double amount, int year, int month) {
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.date = 0;
        this.description = "";
    }

    public Expense(double amount, int year, int month, int date, String description) {
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.date = date;
        this.description = description;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public double getMonth() {
        return month;
    }

    public double getYear() {
        return year;
    }

    public double getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setExpense(double expense, int month, int year) {
        this.amount = expense;
    }

    public void addExpense(double additional) {
        this.amount += additional;
    }

    public String getYearMonth() {
        return this.year + " " + this.month;
    }
}