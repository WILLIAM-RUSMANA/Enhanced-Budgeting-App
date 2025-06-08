package DataStructure.LinkedList;

import OOP.Expense;
import java.util.*;

import DataStructure.MethodInterface;
import DataStructure.UtilityMethod;

public class LinkedListMethod implements MethodInterface {  

    UtilityMethod utility = new UtilityMethod();
    LinkedList<Expense> expenseLinkedList = new LinkedList<>();

    @Override
    /*
     * Method to generate random expenses and add them to the LinkedList.
     * It initializes the expenses using the utility method and measures the time and memory usage.
     * @param numValues, The number of random expenses to generate and add to the LinkedList.
     */
    public void generateExpense(int numValues) {
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

        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }

    @Override
    /*
     * Method to add an expense at a specific index in the LinkedList.
     * It checks for valid index and initializes a new expense using the utility method.
     * Measures the time and memory usage for the operation.
     * @param index, The index at which the new expense should be added.
     */
    public void addExpense(int index){
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (index < 0 || index > expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense newExpense = utility.initialiseExpense();
        expenseLinkedList.add(index, newExpense);
        System.out.println("Expense added at index " + index + ": " + newExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }

    @Override
    /*
     * Method to remove an expense at a specific index from the LinkedList.
     * It checks for valid index and removes the expense, printing the removed expense.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be removed.
     */

    public void removeExpense(int index) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (index < 0 || index >= expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense removedExpense = expenseLinkedList.remove(index);
        System.out.println("Expense removed at index " + index + ": " + removedExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }

    @Override
    /*
     * Method to update an expense at a specific index in the LinkedList.
     * It checks for valid index 
     * it then replaces the expense at that index with a new one initialized by the utility method.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be updated.
     */
    public void updateExpense(int index) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (index < 0 || index >= expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense updatedExpense = utility.initialiseExpense();
        expenseLinkedList.set(index, updatedExpense);
        System.out.println("Expense updated at index " + index + ": " + updatedExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }

    @Override
    /*
     * Method to search for an expense at a specific index in the LinkedList.
     * It checks for valid index and retrieves the expense at that index, printing it.
     * Measures the time and memory usage for the operation.
     * @param index, The index of the expense to be searched.
     */
    public void searchExpense(int index) {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (index < 0 || index >= expenseLinkedList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }
        Expense foundExpense = expenseLinkedList.get(index);
        System.out.println("Expense found at index " + index + ": " + foundExpense);

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }

    @Override
    /*
     * Method to view all expenses in the LinkedList.
     * It checks if the LinkedList is empty and prints all expenses if not.
     * Measures the time and memory usage for the operation.
     * @param None
     */
    public void viewExpenses() {
        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        if (expenseLinkedList.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }
        System.out.println("Expenses in LinkedList:");
        for (Expense expense : expenseLinkedList) {
            System.out.println(expense);
        }

        //end timing and memory usage for LinkedList
        System.out.println(" ");
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }

    @Override
    /*
     * Method to sort the expenses in the LinkedList by amount.
     * It checks if the LinkedList is empty  
     * it then sorts tthe expense from least to greatest amount using Timsort.
     * Measures the time and memory usage for the operation.
     * @param None
     */
    public void sortExpenses() {
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
        utility.printMemoryAndTime("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL, startTimeLL);
    }


    
}
