public class FinancialItem {
    private double amount;
    private int month;  // 1-12
    private int year;
    private String category;

    public FinancialItem(int year, int month) {
        this.amount = 0;
        this.month = month;
        this.year = year;
        this.category = "";
    }

    public FinancialItem(double amount, int year, int month) {
        this.amount = amount;
        this.month = month;
        this.year = year;
        this.category = "";
    }

    public FinancialItem(double amount, int year, int month, String category) {
        this.amount = amount;
        this.month = month;
        this.year = year;
        this.category = "";
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

    public String getCategory() {
        return category;
    }

    // Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
