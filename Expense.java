public class Expense {
    private double expense;
    private double month;
    private double year;

    public Expense(int year, int month) {
        this.expense = 0;
        this.year = year;
        this.month = month;
    }

    public Expense(double expense, int year, int month) {
        this.expense = expense;
        this.year = year;
        this.month = month;
    }

    // Getters
    public double getExpense() {
        return expense;
    }

    // Setters
    public void setExpense(double expense, int month, int year) {
        this.expense = expense;
    }

    public void addExpense(double additional) {
        this.expense += additional;
    }

    public String getYearMonth() {
        return this.year + " " + this.month;
    }
}