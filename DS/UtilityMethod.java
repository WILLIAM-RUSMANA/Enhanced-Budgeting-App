package DS;

import java.util.concurrent.ThreadLocalRandom;

import OOP.Expense;

public class UtilityMethod {    // Common utility methods can be added here
    public void printMemoryAndTime(String structureName, long memoryBefore, long memoryAfter, long endTime, long startTime) {
        long totalMemory = memoryAfter - memoryBefore;
        double totalTimeMs = (endTime - startTime); // Convert ns to ms
        double memoryValue = totalMemory; // convert bytes to kilobytes
        
        System.out.println(structureName + " Performance Metrics:");
        System.out.printf("|-- Memory Usage: %,.2f bytes%n", memoryValue);
        System.out.printf("|-- Time Taken: %,.2f Nanoseconds%n", totalTimeMs);
        System.out.println(" ");
    }

    public Expense initialiseExpense(){
        Expense initialExpense = new Expense(
        (double)ThreadLocalRandom.current().nextInt(1, 400),  // random amount between 1 and 400
        2024,
        ThreadLocalRandom.current().nextInt(1, 13), // random month 1-12
        ThreadLocalRandom.current().nextInt(1, 29), // random day 1-28
        "Initial Expense",                     
        "Sample expense " ,     
        "Daily"                      
        );
        return initialExpense;
    }

    public Expense initialiseAddedExpense(){
        Expense addedExpense = new Expense(
        (double)ThreadLocalRandom.current().nextInt(1, 400),  // random amount between 1 and 400
        2024,
        ThreadLocalRandom.current().nextInt(1, 13), // random month 1-12
        ThreadLocalRandom.current().nextInt(1, 29), // random day 1-28
        "Added Expense",                     
        "random expense " ,     
        "Daily"                      
        );
        return addedExpense;
    }

    public Expense initialiseUpdatedExpense(){
        Expense initialExpense = new Expense(
        (double)ThreadLocalRandom.current().nextInt(1, 400),  // random amount between 1 and 400
        2024,
        ThreadLocalRandom.current().nextInt(1, 13), // random month 1-12
        ThreadLocalRandom.current().nextInt(1, 29), // random day 1-28
        "Updated Expense",
        "random expense " ,
        "Daily"
        );
        return initialExpense;
    }


    public Expense getUpdatedExpense() {
        return initialiseUpdatedExpense();
    }

}