import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Methods {

    static Integer currentId = 1; // initial ID for new entries
    static Scanner scanner = new Scanner(System.in);

    // This method is used to add dummy data for testing purposes
    // It generates random values for the specified type (Expense or Budget)
    public static void addDummyData(String type, int count, Map<Integer, Value> map) {
    Random random = new Random(); // Random object for generating random values
    for (int i = 0; i < count; i++) {
        double amount = 1 + (10000 - 1) * random.nextDouble(); // Amount between 1 and 10000
        String description = "Dummy " + type + " " + currentId;
        String date = String.format("%02d/%02d/%04d", 
                          random.nextInt(28) + 1, // Day
                          random.nextInt(12) + 1, // Month
                          2025);                  // Year
        Value v = new Value(amount, description, date);
        map.put(currentId++, v);
    }
    System.out.println(count + " dummy " + type.toLowerCase() + " entries added successfully.");
    }

    // This method is used for both adding expenses and budgets, based on the type parameter
    public static void handleAddValue(String type, Map<Integer, Value> map, Scanner scanner) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        System.out.println("Enter description of the " + type + ":");
        String description = scanner.nextLine().trim();

        double amount = 0.0; // Initialize amount to 0.0
        while (amount <= 0) { // Loop until a valid amount is entered
            System.out.println("Enter amount of the " + type + ":");
            String amountStr = scanner.nextLine().trim();
            try {
                // Parse the amount and check if it's valid
                amount = Double.parseDouble(amountStr);
                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0.");
                }
              // if not valid, catch the exception, and prompt the user again  
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }

        // Prompt for date input
        String date = ""; // Initialize date to an empty string
        System.out.println("Enter date (DD/MM/YYYY):");
        date = scanner.nextLine().trim();

        //if the date is not valid, set it to blank and inform the user
        if (!isValidDate(date)) {
            date = " ";
            System.out.println("Date would be left as blank. You may update the date later.");
        }

        // Create a new Value object and add it to the map
        Value values = new Value(amount, description, date);
        map.put(currentId++, values);
        System.out.println(type + " added successfully (ID: " + (currentId - 1) + ")");

        long endTime = System.nanoTime(); // End time for performance measurement
        double duration = (endTime - startTime) / 1000000.0; // Convert to milliseconds
        System.out.printf("Time taken to add %s: %.3f milliseconds\n", type, duration); // Display duration
    }

    // This  helper method checks if the date is in the correct format (DD/MM/YYYY)
    public static boolean isValidDate(String date) {
        String regex = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches(); // Check if the date matches the regex pattern
    }

    // This method is used for both updating expenses and budgets, based on the type parameter
    public static void handleUpdateValue(String type, Map<Integer, Value> map, Scanner scanner) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        System.out.print("Enter ID of " + type + " to update: "); // Prompt for ID input
        int id = Integer.parseInt(scanner.nextLine().trim());


        Value values = map.get(id);        
        // Check if the ID exists in the map
        if (values == null) {
            System.out.println(type + " ID not found.");
            return;
        }

        // Prompt for new description
        System.out.print("Enter new description: ");
        values.setDescription(scanner.nextLine().trim());

        System.out.print("Enter new amount: ");
        values.setAmount(Double.parseDouble(scanner.nextLine().trim()));

        // prompt and validate the date input
        String newDate = "";
        System.out.print("Enter new date (DD/MM/YYYY): ");
        newDate = scanner.nextLine().trim();
        if (!isValidDate(newDate)) {
            newDate = " ";
            System.out.println("Date would be left as blank. You may update the date later, using the same method.");
            } // Check if the date is valid
        
        values.setDate(newDate);// Set the new date

        System.out.println(type + " updated successfully."); // Inform the user that the update was successful
        long endTime = System.nanoTime(); // End time for performance measurement
        double duration = (endTime - startTime) / 1000000.0; // Convert to milliseconds
        System.out.printf("Time taken to update %s: %.3f milliseconds\n", type, duration); // Display duration
    }

    // This method is used for both deleting expenses and budgets, based on the type parameter
    public static void handleDeleteValue(String type, Map<Integer, Value> map, Scanner scanner) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        // Prompt for ID input
        System.out.print("Enter ID of " + type + " to delete: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        // if found, remove the entry from the map, if not, inform the user
        if (map.remove(id) != null) {
            System.out.println(type + " deleted successfully.");
        } else {
            System.out.println(type + " ID not found.");
        }

        long endTime = System.nanoTime(); // End time for performance measurement
        double duration = (endTime - startTime) / 1000000.0; // Convert to milliseconds
        System.out.printf("Time taken to delete %s: %.3f milliseconds\n", type, duration); // Display duration
    }

    // This method lists all entries in the map, formatted for display
    public static void listValues(String type, Map<Integer, Value> targetMap) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        System.out.println("# ID  Date        Description        Amount");
        for (Map.Entry<Integer, Value> entry : targetMap.entrySet()) {
            int id = entry.getKey();
            Value e = entry.getValue();
            // Format the output for each entry
            System.out.printf("# %-3d %-11s %-18s $%.2f\n", id, e.getDate(), e.getDescription(), e.getAmount());
   
        } 

        long endTime = System.nanoTime(); // End time for performance measurement
        double duration = (endTime - startTime) / 1000000.0; // Convert to milliseconds
        System.out.printf("Time taken to list %s: %.3f milliseconds\n", type, duration); // Display duration
    }

    // This method shows the total summary of all entries in the map
    public static void showTotalSummary(String type, Map<Integer, Value> targetMap) {
        double total = 0;
        for (Value e : targetMap.values()) {
            total += e.getAmount(); // Sum the amounts of all entries
        }
        System.out.printf("Total %s: $%.2f\n", type.toLowerCase(), total); // Display the total
    }

    // This method shows the monthly summary of entries in the map, filtered by month
    public static void showMonthlySummary(String type, Map<Integer, Value> targetMap) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        // Prompt for month input
        System.out.print("Enter month number (1-12): ");
        int month = Integer.parseInt(scanner.nextLine().trim());

        double total = 0; // Initialize total to 0
        for (Value e : targetMap.values()) {
            String[] parts = e.getDate().split("/"); // Split the date into parts, based on "/"
            int expenseMonth = Integer.parseInt(parts[1]); // Get the month from the date
            if (expenseMonth == month) { // Check if the month matches
                total += e.getAmount(); // Add the amount to the total
            }
        }

        System.out.printf("Total %s for month %d: $%.2f\n", type.toLowerCase(), month, total);
        long endTime = System.nanoTime(); // End time for performance measurement
        double duration = (endTime - startTime) / 1000000.0; // Convert to milliseconds
        System.out.printf("Time taken to show monthly summary of %s: %.3f milliseconds\n", type, duration); // Display duration
    }
        // Sort the map by amount in descending order
    public static void sortByDescendingOrder(String type, Map<Integer, Value> targetMap) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        List<Value> sortedValues = new ArrayList<>(targetMap.values()); // initialize a list with the values from the map
        //sort the list in descending order based on the amount, using a lambda expression
        Collections.sort(sortedValues, (a, b) -> Double.compare(b.getAmount(), a.getAmount())); 

        // Print the sorted values
        System.out.println("# Sorted by Amount (Largest to Smallest)");
        System.out.println("# Date        Description        Amount");
        for (Value v : sortedValues) {
            System.out.printf("# %-11s %-18s $%.2f\n", v.getDate(), v.getDescription(), v.getAmount());
        }

        long endTime = System.nanoTime(); // End time for performance measurement
        double duration = (endTime - startTime) / 1000000.0; // Convert to milliseconds
        System.out.printf("Time taken to sort %s: %.3f milliseconds\n", type, duration); // Display duration
    }
}
