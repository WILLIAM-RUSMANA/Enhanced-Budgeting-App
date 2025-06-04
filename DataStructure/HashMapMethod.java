package DataStructure;

import OOP.Expense;
import java.util.*;

public class HashMapMethod implements MethodInterface {

    public Map<Integer, Expense> expenseHashMap = new HashMap<>();

    @Override
    // method to generate random expenses and store them in a HashMap
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

        utility.printMemoryUsage("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM - startTimeHM);
        utility.printRuntime("HashMap", startTimeHM, endTimeHM);
    }

    @Override
    // method to add an expense to the map at a specific index
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
        utility.printMemoryUsage("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM - startTimeHM);
        utility.printRuntime("HashMap", startTimeHM, endTimeHM);
    }

    public void addedExpenseChaining(int index){
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
        utility.printMemoryUsage("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM - startTimeHM);
        utility.printRuntime("HashMap", startTimeHM, endTimeHM);
    }

    public void addExpenseChaining(int index, Expense addedExpense) {
        UtilityMethod utility = new UtilityMethod();

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
        utility.printMemoryUsage("HashMap", memoryBeforeHM, memoryAfterHM, endTimeHM - startTimeHM);
        utility.printRuntime("HashMap", startTimeHM, endTimeHM);
    }

    public void addExpenseChaining(int index){
        Map <Integer, List<Expense>> newMap = new HashMap<>();

        UtilityMethod utility = new UtilityMethod();
        Expense addedExpense = utility.initialiseAddedExpense();

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

    }

}


