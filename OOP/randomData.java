package OOP;
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
    LocalDate startDate = LocalDate.of(2015, 1, 1); // Start date for generating random data

    // TODO Implement these two in the random generated thing
    String type = "recurring";

    public List<Expense> generateRandomData(Integer numDays){

        RandomDataCategories data = new RandomDataCategories(); // Create an instance of RandomDataCategories to access its methods
        data.initializeData(); // Initialize the data categories with predefined values
        dataList =  data.list; // Get the list of categories from the RandomDataCategories instance
        
        // make a new list to store the generated random expenses
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
                double finalAmount = 0;
                if(random.nextDouble() < probability){

                    // Get the base amount, monthly trend, and standard deviation for the category
                    double baseAmount = category.getBaseAmount();
                    double monthlyTrend = category.getMonthlyTrend();
                    double standardDeviation = category.getStandardDeviation();
                    double frequency = category.getFrequencyPerWeek(); // Get the frequency of the category
                    
                    // Generate a random amount based on the base amount, monthly trend, and standard deviation
                    double monthPassed = i/30;
                    double Inflation = baseAmount * Math.pow((1 + monthlyTrend), monthPassed);// Calculate the inflation-adjusted base amount
                    double noise = random.nextGaussian() * standardDeviation; // Generate noise using a Gaussian distribution
                    double amount = Inflation + noise; // Calculate the final amount by adding noise to the base amount
                    finalAmount = Math.max(0, amount); // Ensure non-negative amount
                }

                String description = ""; // Initialize description as an empty string
                Expense expense = new Expense(finalAmount, year, month, day, categoryName, description);
                // Create a new Expense object with the generated amount and date
                randomExpenses.add(expense);
            }
        }

        // Analyze the frequency pattern for each category and set it in the corresponding expenses
        for (RandomDataCategories cat : dataList) {
            String categoryName = cat.getName(); 
            String pattern = cat.analyzeFrequencyPattern(randomExpenses, categoryName);

            // Set the frequency pattern for each expense in the category
             for (Expense exp : randomExpenses) {
                if (exp.getCategory().equals(categoryName)) {exp.setFrequency(pattern);}
            }
        }

        // Return the list of generated random expenses
        return randomExpenses;
    }
}

    
