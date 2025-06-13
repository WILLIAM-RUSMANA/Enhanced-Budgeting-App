package DS.LinkedList;

import OOP.Expense;
import java.util.*;

import DS.MethodInterface;
import DS.UtilityMethod;

public class LinkedListMethod implements MethodInterface {  

    UtilityMethod utility = new UtilityMethod();
    public List<Expense> expenseLinkedList = new LinkedList<>();

    @Override
    /*
     * Method to generate random expenses and add them to the LinkedList.
     * It initializes the expenses using the utility method and measures the time and memory usage.
     * @param numValues, The number of random expenses to generate and add to the LinkedList.
     */
    public void generateExpense(int numValues,boolean printMetric) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();

        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        for (int i = 0; i < numValues; i++) {
            expenseLinkedList.add(utility.initialiseExpense()); //generate random expenses in LinkedList
        }

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to add an expense at a specific index in the LinkedList.
     * It checks for valid index and initializes a new expense using the utility method.
     * Measures the time and memory usage for the operation.
     * @param index, The index at which the new expense should be added.
     */
    public void addExpense(int indexToAdd,boolean printMetric){
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToAdd < 0 || indexToAdd > expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense newExpense = utility.initialiseExpense();
        expenseLinkedList.add(indexToAdd, newExpense);
        System.out.println("Expense added at index " + indexToAdd + ": " + newExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to remove an expense at a specific index from the LinkedList.
     * It checks for valid index and removes the expense, printing the removed expense.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be removed.
     */

    public void removeExpense(int indexToRemove,boolean printMetric) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToRemove < 0 || indexToRemove >= expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense removedExpense = expenseLinkedList.remove(indexToRemove);
        System.out.println("Expense removed at index " + indexToRemove + ": " + removedExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to update an expense at a specific index in the LinkedList.
     * It checks for valid index 
     * it then replaces the expense at that index with a new one initialized by the utility method.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be updated.
     */
    public void updateExpense(int indexToUpdate,boolean printMetric) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToUpdate < 0 || indexToUpdate >= expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense updatedExpense = utility.initialiseExpense();
        expenseLinkedList.set(indexToUpdate, updatedExpense);
        System.out.println("Expense updated at index " + indexToUpdate + ": " + updatedExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to search for an expense at a specific index in the LinkedList.
     * It checks for valid index and retrieves the expense at that index, printing it.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be searched.
     */
    public void searchExpense(int indexToSearch,boolean printMetric) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (indexToSearch < 0 || indexToSearch >= expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense foundExpense = expenseLinkedList.get(indexToSearch);
        System.out.println("Expense found at index " + indexToSearch + ": " + foundExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to view all expenses in the LinkedList.
     * It checks if the LinkedList is empty and prints all expenses if not.
     * Measures the time and memory usage for the operation.
     * @param None
     */
    public void viewExpenses(boolean printMetric) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (expenseLinkedList.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }
        int count = 0;
        System.out.println("Expenses in LinkedList:");
        for (Expense expense : expenseLinkedList) {
            System.out.println(expense);
            if(count == 50){
                return;
            }
        }

        //end timing and memory usage for LinkedList
        System.out.println(" ");
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }

    @Override
    /*
     * Method to sort the expenses in the LinkedList by amount.
     * It checks if the LinkedList is empty  
     * it then sorts tthe expense from least to greatest amount using Timsort.
     * Measures the time and memory usage for the operation.
     * @param None
     */
    public void sortExpenses(boolean printMetric) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (expenseLinkedList.isEmpty()) {
            System.out.println("No expenses to sort.");
            return;
        }
        Collections.sort(expenseLinkedList, Comparator.comparing(Expense::getAmount));
        System.out.println("Expenses sorted by amount.");

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        if (printMetric==true){
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
        }
    }


    
}
