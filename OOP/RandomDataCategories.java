package OOP;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RandomDataCategories {
    // Class to represent random data categories for expenses
    // Each category has a name, base amount, monthly trend, standard deviation, and frequency per week
    private String name;
    private Double baseAmount;
    private Double monthlyTrend;
    private Double standardDeviation;
    private Double frequencyPerWeek;

    public List<RandomDataCategories> list = new ArrayList<>();

    
    public RandomDataCategories() {
        this.name = "";
        this.baseAmount = 0.0;
        this.monthlyTrend = 0.0;
        this.standardDeviation = 0.0;
        this.frequencyPerWeek = 0.0;
    }

    // Constructor to initialize the category with its properties
    public RandomDataCategories(String name, Double baseAmount, Double monthlyTrend, Double standardDeviation, Double frequencyPerWeek) {
        this.name = name;
        this.baseAmount = baseAmount;
        this.monthlyTrend = monthlyTrend;
        this.standardDeviation = standardDeviation;
        this.frequencyPerWeek = frequencyPerWeek;
    }

    // Getters for the properties of the category
    public String getName() {
        return name;
    }

    public Double getBaseAmount() {
        return baseAmount;
    }

    public Double getMonthlyTrend() {
        return monthlyTrend;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public Double getFrequencyPerWeek() {
        return frequencyPerWeek;
    }
            
    // Method to initialize the list with predefined categories and their properties
    public void initializeData(){
    list.add(new RandomDataCategories("Taxes", 25_000_000.0, 0.05, 20.0, 3.0));
    list.add(new RandomDataCategories("Utilities", 12_500_000.0, 0.02, 10.0, 1.0));
    list.add(new RandomDataCategories("Transportation", 1_000_000.0, 0.03, 15.0, 2.0));
    list.add(new RandomDataCategories("Events", 800_000.0, 0.04, 5.0, 1.0));
    list.add(new RandomDataCategories("Rent", 21_000_0000.0, 0.01, 50.0, 1.0));
    list.add(new RandomDataCategories("Materials", 15_000_000.0, 0.03, 10.0, 2.0));
    }

    public String analyzeFrequencyPattern(List<Expense> expenses, String categoryName) {
        long tootalInterval = 0;
        int count = 0;
        LocalDate previousDate = null;

        for (Expense expense : expenses) {
            if (expense.getCategory().equals(categoryName)) {
                LocalDate currentDate = LocalDate.of(expense.getYear(), expense.getMonth(), expense.getDate());
                if (previousDate != null) {
                     long interval = ChronoUnit.DAYS.between(previousDate, currentDate);
                    tootalInterval += interval;
                    count++;
                }
                previousDate = currentDate;
            }
        }

        double averageDays =  (double) tootalInterval / count;

        if (averageDays < 2){return "daily";}
        else if (averageDays >= 2 && averageDays < 7) {return "weekly";} 
        else if (averageDays >= 7 && averageDays < 30) {return "monthly";} 
        else if (averageDays >= 180 && averageDays < 365) {return "yearly";}
        else return "irregular";
    }
}
