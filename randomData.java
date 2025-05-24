import java.util.*;
import java.time.*;

public class randomData {
    // This class generates random data for expenses
    // It uses a map to store different categories of expenses
    // Each category has a base amount, monthly trend, standard deviation, and frequency per week
    // The generateRandomData method generates random expenses based on the specified number of days
    // The generated expenses are stored in a list and returned

    public List<RandomDataCategories> dataList = new ArrayList();
    Random random = new Random(); // Random number generator
    // TODO start 10 years back
    LocalDate startDate = LocalDate.of(2015, 1, 1); // Start date for generating random data
    // TODO Implement these two in the random generated thing
    String description = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    String type = "recurring";

    public List<Expense> generateRandomData(Integer numDays){
        // Initialize the map with different categories of expenses
        // TODO FIX THE categories part and I think you can think of a better way since, you typed down every category "Groceries" twice
        dataList.add(new RandomDataCategories("Groceries", 200.0, 0.05, 20.0, 3.0));
        dataList.add(new RandomDataCategories("Utilities", 150.0, 0.02, 10.0, 1.0));
        dataList.add(new RandomDataCategories("Transportation", 100.0, 0.03, 15.0, 2.0));
        dataList.add(new RandomDataCategories("Entertainment", 80.0, 0.04, 5.0, 1.0));
        dataList.add(new RandomDataCategories("Rent", 1200.0, 0.01, 50.0, 1.0));
        dataList.add(new RandomDataCategories("Dining Out", 150.0, 0.03, 10.0, 2.0));

        // copy the map to a list
        List<Expense> randomExpenses = new ArrayList<>();

        // Generate random expenses for the specified number of days
        for(int i = 0; i< numDays; i++){
            LocalDate date = startDate.plusDays(i); // Calculate the date for each day
            int dayOfWeek = date.getDayOfWeek().getValue();// Get the day of the week (1 = Monday, 7 = Sunday)
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();

            // Iterate through each category in the dataMap
            for (RandomDataCategories category : dataList){
                String categoryName = category.getName(); // Get the category name
                double probability = category.getFrequencyPerWeek() / 7.0; // Calculate the probability of generating an expense for this category

                // increase the probability of entertainment and dining out for weekends
                if((categoryName.equals("Entertainment") || categoryName.equals("Dining Out")) && (dayOfWeek > 5)){
                    probability = 0.9;  // TODO: idk looks sus to me is this right? probability 0? comment on why it's 0 if it is
                }

                // Generate a random number and compare it with the probability
                if(random.nextDouble() < probability){

                    // Get the base amount, monthly trend, and standard deviation for the category
                    double baseAmount = category.getBaseAmount();
                    double monthlyTrend = category.getMonthlyTrend();
                    double standardDeviation = category.getStandardDeviation();

                    // Generate a random amount based on the base amount, monthly trend, and standard deviation
                    double amount = baseAmount + (monthlyTrend * month) + (random.nextGaussian() * standardDeviation);
                    amount = Math.max(0, amount); // Ensure non-negative amount

                    // Create a new Expense object with the generated amount and date
                    Expense expense = new Expense(amount, year, month, day, categoryName, description, frequency);
                    randomExpenses.add(expense);
                }
            }
        }
        // Return the list of generated random expenses
        return randomExpenses;
    }
}

    
