package DS.ArrayList;

import DS.MethodInterface;
import DS.UtilityMethod;
import OOP.Expense;
import java.util.*;


public class ArrayListMethod implements MethodInterface {
    UtilityMethod utility = new UtilityMethod();
    public List<Expense> expeseArrayList = new ArrayList<>();
    long sumMemory = 0;
    long sumTime = 0;

    @Override
    /*
     * Method to generate random expenses and add them to the ArrayList.
     * It initializes the expenses using the utility method and measures the time and memory usage.
     * @param numValues, The number of random expenses to generate and add to the ArrayList.
     */
    public void generateExpense(int numValues, boolean printMetric) {
        // Start timing and memory usage for ArrayList

        expeseArrayList.clear();
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();

        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();
        
        for (int i = 0; i < numValues; i++) {
            expeseArrayList.add(utility.initialiseExpense()); //generate random expenses in ArrayList
        }

        //end timing and memory usage for ArrayList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if(printMetric==true){
            utility.printMemoryAndTime("Arraylisy: ", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }

    }

    @Override
    /*
     * Method to add an expense at a specific index in the ArrayList.
     * It checks for valid index and initializes a new expense using the utility method.
     * Measures the time and memory usage for the operation.
     * @param index, The index at which the new expense should be added.
     */
    public void addExpense(int indexToAdd, boolean printMetric) {
        // Start timing and memory usage for ArrayList

        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToAdd < 0 || indexToAdd > expeseArrayList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense newExpense = utility.initialiseExpense();
        expeseArrayList.add(indexToAdd, newExpense);


        //end timing and memory usage for ArrayList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric){
        utility.printMemoryAndTime("Arraylist", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to remove an expense at a specific index from the ArrayList.
     * It checks for valid index and removes the expense, printing the removed expense.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be removed.
     */

    public void removeExpense(int indexToRemove, boolean printMetric) {
        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToRemove < 0 || indexToRemove >= expeseArrayList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
       else{expeseArrayList.remove(indexToRemove);}


        //end timing and memory usage for ArrayList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric){
        utility.printMemoryAndTime("Arraylist", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to update an expense at a specific index in the ArrayList.
     * It checks for valid index
     * it then replaces the expense at that index with a new one initialized by the utility method.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be updated.
     */
    public void updateExpense(int indexToUpdate, boolean printMetric) {
        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToUpdate < 0 || indexToUpdate >= expeseArrayList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense updatedExpense = utility.initialiseExpense();
        expeseArrayList.set(indexToUpdate, updatedExpense);

        //end timing and memory usage for ArrayList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric){
        utility.printMemoryAndTime("Arraylist", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to search for an expense at a specific index in the ArrayList.
     * It checks for valid index and retrieves the expense at that index, printing it.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be searched.
     */
    public void searchExpense(int indexToSearch, boolean printMetric) {
        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToSearch < 0 || indexToSearch >= expeseArrayList.size()) {
            System.out.println("Invalid index. im the problem Please enter a valid index.");
            return;
        }
        else{expeseArrayList.get(indexToSearch);}


        //end timing and memory usage for ArrayList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric){
        utility.printMemoryAndTime("Arraylist", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to view all expenses in the ArrayList.
     * It checks if the ArrayList is empty and prints all expenses if not.
     * Measures the time and memory usage for the operation.
     * @param None
     */
    public void viewExpenses(boolean printMetric) {
        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();
        Expense exp;

        if (expeseArrayList.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }
        System.out.println("Expenses in ArrayList:");
        int limit = Math.min(50, expeseArrayList.size());
        for (int i = 0; i<limit; i++) {
            exp = expeseArrayList.get(i);
            System.out.println("Index " + i + ": Amount: " + exp.getAmount() + 
                            ", Year: " + exp.getYear() +
                            ", Month: " + exp.getMonth() +
                            ", Day: " + exp.getDate() +
                            ", Description: " + exp.getDescription() +
                            ", Frequency: " + exp.getFrequency());
        }

        //end timing and memory usage for ArrayList
        System.out.println(" ");
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric){
        utility.printMemoryAndTime("Arraylist", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to sort the expenses in the ArrayList by amount.
     * It checks if the ArrayList is empty
     * it then sorts the expense from least to greatest amount using Timsort.
     * Measures the time and memory usage for the operation.
     * @param None
     */
    public void sortExpenses(boolean printMetric) {
        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (expeseArrayList.isEmpty()) {
            System.out.println("No expenses to sort.");
        }

        Collections.sort(expeseArrayList, Comparator.comparing(Expense::getAmount));

        //end timing and memory usage for ArrayList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric){
        utility.printMemoryAndTime("Arraylist", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    public void clear(){
        expeseArrayList.clear();
        System.out.println("All arraylist content has been deleted");
    }

}