public class Budget {
    private double budget;
    private int month;  // 1-12
    private int year;

    public Budget(int month, int year) {
        this.budget = 0;
        this.month = month;
    }

    public Budget(double budget, int month, int year) {
        this.budget = budget;
        this.month = month;
        this.year = year;
    }


    // Getters
    public double getBudget() {
        return budget;
    }
}
