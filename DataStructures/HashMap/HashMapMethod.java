package DataStructures.HashMap;

import OOP.Expense;
import java.util.*;

import DataStructures.MethodInterface;
import DataStructures.UtilityMethod;

public class HashMapMethod implements MethodInterface {

    public Map<Integer, Expense> expenseHashMap = new HashMap<>();

    @Override
    // this methods generate a specified number of expense object inside of the hashmap
    public void generateExpense(int numValues) {
        UtilityMethod utility = new UtilityMethod();

        // Start timing and memory usage for HashMap
        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();

        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        for (int i = 0; i < numValues; i++) {
            expenseHashMap.put(i, utility.initialiseExpense()); //generate random expenses in HashMap
        }

        //end timing and memory usage for HashMap
        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();

    utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

    @Override
    /* this method will add an expense object at a given index insise of the hashmap
     * if a collision happen it would shift all the keys after the given index by 1
     * if a collision did not occur it would put the expense object at the given index
     */

    public void addExpense(int index) {
        UtilityMethod utility = new UtilityMethod();
        Expense addedExpense = utility.initialiseAddedExpense();

        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        if (!expenseHashMap.containsKey(index)) {
            expenseHashMap.put(index, addedExpense); // add the expense at the specified index
            System.out.println("Added Expense at index " + index + ": " + addedExpense);
            return;
            } 

        else{
            for (int i = expenseHashMap.size()-1; i >= index; i--) {
            expenseHashMap.put(i + 1, expenseHashMap.get(i)); // shift existing expenses to the right
            }
            expenseHashMap.put(index, addedExpense); // add the new expense at the specified index
        }

        //end timing and memory usage for HashMap
        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        utility.printMemoryAndTime("HashMap (With incrementation)", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }


    /* this method would add an expense object at a given index into the hashmap
     * it initialises a new hashmap with different value type
     * it then a populate the new hashmap with all of the data in the old hashmap
     * if a collision did occur in the new hashmap it would resolve it by chaining
     */

    public void addExpenseChaining(int index){
        Map <Integer, List<Expense>> newMap = new HashMap<>();

        UtilityMethod utility = new UtilityMethod();
        Expense addedExpense = utility.initialiseAddedExpense();

        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        // Iterate through the existing HashMap and copy entries to the new map
        for (Map.Entry<Integer, Expense> entry : expenseHashMap.entrySet()) {
            int key = entry.getKey();
            Expense value = entry.getValue();

            List<Expense> expenseList = new ArrayList<>();
            expenseList.add(value);
            newMap.put(key, expenseList);
        }

        // If no entry yet at this key, create a new list
        if (!newMap.containsKey(index)) {
            List<Expense> list = new ArrayList<>();
            list.add(addedExpense);
            newMap.put(index, list);
        } else {
            // If entry exists, append to the list (chaining)
            newMap.get(index).add(addedExpense);
        }

        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();

        utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

    @Override
    /* this method removes an Expense object from the hashmap at a given index
     * it first checks if the index exists in the HashMap.
     * If it does, it removes the expense at that index.
     * If it does not, it prints a message indicating that no expense was found at that index.
     */

    public void removeExpense(int index) {
        UtilityMethod utility = new UtilityMethod();

        // Start timing and memory usage for HashMap
        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        // Check if the index exists in the HashMap
        if (expenseHashMap.containsKey(index)) {
            expenseHashMap.remove(index);
            System.out.println("Removed expense at index " + index);
        } else {
            System.out.println("No expense found at index " + index);
        }

        //end timing and memory usage for HashMap
        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

    @Override
    /*This method is used to update an expense object inside of the hashmap at a specific index..
     * It checks if the index exists in the HashMap.
     * If it does, it updates the expense at that index with the new expense object.
     * If it does not, it prints a message indicating that no expense was found at that index.
     */

    public void updateExpense(int index) {
        UtilityMethod utility = new UtilityMethod();
        Expense updatedExpense = utility.initialiseUpdatedExpense();

        // Start timing and memory usage for HashMap
        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        if (expenseHashMap.containsKey(index)) {
            expenseHashMap.put(index, updatedExpense);
            System.out.println("Updated expense at index " + index + ": " + updatedExpense);
        } else {
            System.out.println("No expense found at index " + index);
        }

        //end timing and memory usage for HashMap
        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

    @Override
    /* this method is used to search for an expense object inside of the hashmap at a specific index.
     * It checks if the index exists in the HashMap.
     * If it does, it retrieves and prints the expense at that index.
     * If it does not, it prints a message indicating that no expense was found at that index.
     */
    public void searchExpense(int index) {
        UtilityMethod utility = new UtilityMethod();

        // Start timing and memory usage for HashMap
        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        if (expenseHashMap.containsKey(index)) {
            Expense expense = expenseHashMap.get(index);
            System.out.println("Expense found at index " + index + ": " + expense);
        } else {
            System.out.println("No expense found at index " + index);
        }

        //end timing and memory usage for HashMap
        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

    @Override
    /*this method is used to view all expenses stored in the HashMap.
    * It first checks if the HashMap is empty.
    * If it is empty, it prints a message indicating that there are no expenses to display.
    * If it is not empty, it iterates through the entries in the HashMap and prints each expense.
    */

    public void viewExpenses() {
        UtilityMethod utility = new UtilityMethod();

        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        if (expenseHashMap.isEmpty()) {
            System.out.println("No expenses to display");
        } else {
            System.out.println("\nExpense List:");
            for (Map.Entry<Integer, Expense> entry : expenseHashMap.entrySet()) {
                System.out.println("Index " + entry.getKey() + ": " + entry.getValue());
            }
        }

        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

    @Override
    /* this method sorts the expenses in the HashMap based on the expense amount.
     * It converts the HashMap entries to a List 
     * sorts the list using timsort based on the expense amount,
     * and then prints the sorted expenses.
     */
    public void sortExpenses() {
        UtilityMethod utility = new UtilityMethod();

        System.gc();
        Runtime runtimeHM = Runtime.getRuntime();
        long memoryBeforeHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        long startTimeHM = System.nanoTime();

        // Convert the HashMap to a List of Map.Entry for sorting
        List<Map.Entry<Integer, Expense>> entryList = new ArrayList<>(expenseHashMap.entrySet());

        // Sort the list based on the expense amount
        entryList.sort(Comparator.comparingDouble(entry -> entry.getValue().getAmount()));

        // Print the sorted expenses
        System.out.println("\nSorted Expenses:");
        for (Map.Entry<Integer, Expense> entry : entryList) {
            System.out.println("Index " + entry.getKey() + ": " + entry.getValue());
        }

        long endTimeHM = System.nanoTime();
        long memoryAfterHM = runtimeHM.totalMemory() - runtimeHM.freeMemory();
        utility.printMemoryAndTime("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM, startTimeHM);
    }

}


