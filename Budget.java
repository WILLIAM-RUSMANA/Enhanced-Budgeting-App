public class Budget {
    private double budget;
    private int month;  // 1-12
    private int year;

    public Budget(int year, int month) {
        this.budget = 0;
        this.month = month;
        this.year = year;
    }

    public Budget(double budget, int year, int month) {
        this.budget = budget;
        this.month = month;
        this.year = year;
    }


    // Getters
    public double getBudget() {
        return budget;
    }

    public String getYearMonth() {
        return this.month + " " + this.year;
    }
}
