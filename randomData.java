import java.util.*;
import java.time.*;
import java.util.List;
import java.util.Locale.Category;

public class randomData {
public Map<String, radomDataCategories> dataMap = new HashMap<>();
Random random = new Random();
LocalDate startDate = LocalDate.of(2025, 1, 1);

    public List<Expense> generateRandomData(Integer numDays){ 

    dataMap.put("Groceries", new radomDataCategories("Groceries", 200.0, 0.05, 20.0, 3.0));
    dataMap.put("Utilities", new radomDataCategories("Utilities", 150.0, 0.02, 10.0, 1.0));
    dataMap.put("Transportation", new radomDataCategories("Transportation", 100.0, 0.03, 15.0, 2.0));
    dataMap.put("Entertainment", new radomDataCategories("Entertainment", 80.0, 0.04, 5.0, 1.0));
    dataMap.put("Rent", new radomDataCategories("Rent", 1200.0, 0.01, 50.0, 1.0));
    dataMap.put("Dining Out", new radomDataCategories("Dining Out", 150.0, 0.03, 10.0, 2.0));

    List<Expense> randomExpenses = new ArrayList<>(generateRandomData(numDays));

    for(int i = 0; i<numDays; i++){
        LocalDate date = startDate.plusDays(i);
        int dayOfWeek = date.getDayOfWeek().getValue();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        for (String categoryName : dataMap.keySet()){
            radomDataCategories category = dataMap.get(categoryName);
            double probability = category.getFrequencyperWeek() / 7.0;

            if((categoryName.equals("Entertainment") || categoryName.equals("Dining Out")) && dayOfWeek > 5){
                probability = 0.0;
            }

            if(random.nextDouble() < probability){  
                double baseAmount = category.getBaseAmount();
                double monthlyTrend = category.getMonthlyTrend();
                double standardDeviation = category.getStandardDeviation();

                // Generate a random amount based on the base amount, monthly trend, and standard deviation
                double amount = baseAmount + (monthlyTrend * month) + (random.nextGaussian() * standardDeviation);
                amount = Math.max(0, amount); // Ensure non-negative amount

                Expense expense = new Expense(amount, year, month, day, categoryName);
                randomExpenses.add(expense);
            }
        }
    }

    return randomExpenses;
    }
}

    
