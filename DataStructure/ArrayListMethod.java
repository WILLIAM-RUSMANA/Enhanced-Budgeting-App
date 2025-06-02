package DataStructure;

import java.util.*;
import OOP.Expense;

public class ArrayListMethod {
    public List<Expense> expenseArrayList = new ArrayList<>();


    public void addExpenseAL(int numValues) {
        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeAL = Runtime.getRuntime();
        long memoryBeforeAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
        long startTimeAL = System.nanoTime();

        for (int i = 0; i < numValues; i++) {expenseArrayList.add(i, expense);} //generate random expenses in ArrayList

        //end timing and memory usage for ArrayList
        long endTimeAL = System.nanoTime();
        long memoryAfterAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
        long totalMemoryAL = memoryAfterAL - memoryBeforeAL;
        long totalTimeAL = endTimeAL - startTimeAL;

        System.out.println("ArrayList Memory Usage: " + totalMemoryAL + " bytes, Time Taken: " + totalTimeAL + " ns");
    
    }
}