package DS;

import OOP.Expense;

public class UtilityMethod {

    // Common utility methods can be added here
    public void printMemoryAndTime(String structureName, long memoryBefore, long memoryAfter, long endTime, long startTime) {
        long totalMemory = memoryAfter - memoryBefore;
        long totalTime = endTime - startTime;
        System.out.println(structureName + " Memory Usage: " + totalMemory + " bytes, Time Taken: " + totalTime + " ns");
    }

    public Expense initialiseExpense(){
        Expense initialExpense = new Expense(
        50.0 + (Math.random() * 200),  // random amount between 50 and 250
        2024,                         
        (int)(Math.random() * 12) + 1, // random month 1-12
        (int)(Math.random() * 28) + 1, // random day 1-28
        "Initial Expense",                     
        "Sample expense " ,     
        "Daily"                      
        );
        return initialExpense;
    }

    public Expense initialiseAddedExpense(){
        Expense addedExpense = new Expense(
        50.0 + (Math.random() * 200),  // random amount between 50 and 250
        2024,                         
        (int)(Math.random() * 12) + 1, // random month 1-12
        (int)(Math.random() * 28) + 1, // random day 1-28
        "Added Expense",                     
        "random expense " ,     
        "Daily"                      
        );
        return addedExpense;
    }

    public Expense initialiseUpdatedExpense(){
        Expense initialExpense = new Expense(
        50.0 + (Math.random() * 200),  // random amount between 50 and 250
        2024,                         
        (int)(Math.random() * 12) + 1, // random month 1-12
        (int)(Math.random() * 28) + 1, // random day 1-28
        "Updated Expense",                     
        "random expense " ,     
        "Daily"                      
        );
        return initialExpense;
    }
    
}