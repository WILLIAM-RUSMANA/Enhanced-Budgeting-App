public class Expense extends FinancialItem {
    private int date;
    private String description;
    private String type;

    public Expense(int year, int month) {
        super(year, month);
        this.date = 0;
        this.description = "";
        this.type = "";
    }

    public Expense(double amount, int year, int month) {
        super(amount, year, month);
        this.date = 0;
        this.description = "";
        this.type = "";
    }

    public Expense(double amount, int year, int month, int date, String category, String description, String type) {
        super(amount, year, month, category);
        this.date = date;
        this.description = description;
        this.type = type;
    }

    // Getters
    public int getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setExpense(double expenseAmount) {
        this.setAmount(expenseAmount);
    }

    public void setDate(int date) {
        this.date = date;
    }
}
