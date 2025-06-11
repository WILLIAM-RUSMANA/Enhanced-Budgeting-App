package DataStructures.ArrayList;

import java.util.*;

import DataStructures.UtilityMethod;
import OOP.Expense;

public class ArrayListMethod {
    public List<Expense> expenseArrayList = new ArrayList<>();


    public void generateExpense(int numValues) {
        UtilityMethod utility = new UtilityMethod();

        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeAL = Runtime.getRuntime();

        long memoryBeforeAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
        long startTimeAL = System.nanoTime();

        for (int i = 0; i < numValues; i++) {
            expenseArrayList.add(i, utility.initialiseExpense()); //generate random expenses in ArrayList
        } 

        //end timing and memory usage for ArrayList
        long endTimeAL = System.nanoTime();
        long memoryAfterAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();

        utility.printMemoryUsage("ArrayList", memoryBeforeAL, memoryAfterAL, endTimeAL - startTimeAL);
        utility.printRuntime("ArrayList", startTimeAL, endTimeAL);
    }
}