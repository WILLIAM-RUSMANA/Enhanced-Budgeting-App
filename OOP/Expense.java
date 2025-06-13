package OOP;
public class Expense extends FinancialItem {
    private int date;
    private String description;
    private String frequency;

    // Constructors
    public Expense(int year, int month) {
        super(year, month);
        this.date = 0;
        this.description = "";
        this.frequency = "";
    }

    public Expense(double amount, int year, int month) {
        super(amount, year, month);
        this.date = 0;
        this.description = "";
        this.frequency = "";
    }

    public Expense(double amount, int year, int month, int date, String category, String description) {
        super(amount, year, month, category);
        this.date = date;
        this.description = description;
        this.frequency = "";
    }

    public Expense(double amount, int year, int month, int date, String category, String description, String frequency) {
        super(amount, year, month, category);
        this.date = date;
        this.description = description;
        this.frequency = frequency;
    }

    // Getters
    public int getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public String getFrequency() {
        return frequency;
    }

    // Setters
    public void setExpense(double expenseAmount) {
        this.setAmount(expenseAmount);
    }
    public void setDate(int date) {
        this.date = date;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + getAmount() +
                ", year=" + getYear() +
                ", month=" + getMonth() +
                ", date=" + date +
                ", category='" + getCategory() + '\'' +
                ", description='" + description + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
