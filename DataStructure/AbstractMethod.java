package DataStructure;

import OOP.Expense;

public abstract class AbstractMethod {
    // Abstract methods for data structure operations
    public abstract void addExpense(int positionChoice);
    public abstract void updateExpense(int expenseId, String newDescription, double newAmount);
    public abstract void viewExpenses();
    public abstract void sortExpenses(String criteria);
    public abstract void searchExpenses(String query);
    public abstract void generateValues(int numValues);

    // Common utility methods can be added here
    public void printMemoryUsage(String structureName, long memoryBefore, long memoryAfter, long timeTaken) {
        long totalMemory = memoryAfter - memoryBefore;
        System.out.println(structureName + " Memory Usage: " + totalMemory + " bytes, Time Taken: " + timeTaken + " ns");
    }

    public void printRuntime(String structureName, long startTime, long endTime) {
        long totalTime = endTime - startTime;
        System.out.println(structureName + " Time Taken: " + totalTime + " ns");
    }

    public void initialiseExpense(){
        Expense initialExpense = new Expense(
        50.0 + (Math.random() * 200),  // random amount between 50 and 250
        2024,                         
        (int)(Math.random() * 12) + 1, // random month 1-12
        (int)(Math.random() * 28) + 1, // random day 1-28
        "Initial Expense",                     
        "Sample expense " ,     
        "Daily"                      
        );
    }

    public void initialiseAddedExpense(){
        Expense addedExpense = new Expense(
        50.0 + (Math.random() * 200),  // random amount between 50 and 250
        2024,                         
        (int)(Math.random() * 12) + 1, // random month 1-12
        (int)(Math.random() * 28) + 1, // random day 1-28
        "Added Expense",                     
        "Sample expense " ,     
        "Daily"                      
        );
    }

    public void initialiseUpdatedExpense(){
        Expense initialExpense = new Expense(
        50.0 + (Math.random() * 200),  // random amount between 50 and 250
        2024,                         
        (int)(Math.random() * 12) + 1, // random month 1-12
        (int)(Math.random() * 28) + 1, // random day 1-28
        "Initial Expense",                     
        "Updated expense " ,     
        "Daily"                      
        );
    }
    
}