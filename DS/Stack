package DS.Stack;

import OOP.Expense;
import java.util.*;
import DS.MethodInterface;
import DS.UtilityMethod;

public class StackMethod implements MethodInterface {
    UtilityMethod utility = new UtilityMethod();
    public Stack<Expense> expenseStack = new Stack<>();

    @Override
    public void generateExpense(int numValues) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < numValues; i++) {
            expenseStack.push(utility.initialiseExpense());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    public void addExpense(int indexToAdd) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        if (indexToAdd < 0 || indexToAdd > expenseStack.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }

        Stack<Expense> tempStack = new Stack<>();
        while (expenseStack.size() > indexToAdd) {
            tempStack.push(expenseStack.pop());
        }

        Expense newExpense = utility.initialiseExpense();
        expenseStack.push(newExpense);
        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        System.out.println("Expense added at index " + indexToAdd + ": " + newExpense);

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    public void removeExpense(int indexToRemove) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        if (indexToRemove < 0 || indexToRemove >= expenseStack.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }

        Stack<Expense> tempStack = new Stack<>();
        while (expenseStack.size() > indexToRemove + 1) {
            tempStack.push(expenseStack.pop());
        }

        Expense removedExpense = expenseStack.pop();
        System.out.println("Expense removed at index " + indexToRemove + ": " + removedExpense);

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    public void updateExpense(int indexToUpdate) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        if (indexToUpdate < 0 || indexToUpdate >= expenseStack.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }

        Stack<Expense> tempStack = new Stack<>();
        while (expenseStack.size() > indexToUpdate + 1) {
            tempStack.push(expenseStack.pop());
        }

        Expense updatedExpense = utility.initialiseExpense();
        expenseStack.pop(); // remove the old one
        expenseStack.push(updatedExpense);

        System.out.println("Expense updated at index " + indexToUpdate + ": " + updatedExpense);

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    public void searchExpense(int indexToSearch) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        if (indexToSearch < 0 || indexToSearch >= expenseStack.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }

        Stack<Expense> tempStack = new Stack<>();
        Expense foundExpense = null;

        while (expenseStack.size() > indexToSearch) {
            tempStack.push(expenseStack.pop());
        }

        foundExpense = expenseStack.peek();
        System.out.println("Expense found at index " + indexToSearch + ": " + foundExpense);

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    public void viewExpenses() {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        if (expenseStack.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }

        System.out.println("Expenses in Stack:");
        Stack<Expense> tempStack = new Stack<>();
        int index = 0;

        while (!expenseStack.isEmpty()) {
            Expense exp = expenseStack.pop();
            System.out.println("Index " + index + ": Amount: " + exp.getAmount() +
                               ", Year: " + exp.getYear() +
                               ", Month: " + exp.getMonth() +
                               ", Day: " + exp.getDate() +
                               ", Description: " + exp.getDescription() +
                               ", Frequency: " + exp.getFrequency());
            tempStack.push(exp);
            index++;
        }

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    public void sortExpenses() {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        if (expenseStack.isEmpty()) {
            System.out.println("No expenses to sort.");
            return;
        }

        List<Expense> tempList = new ArrayList<>(expenseStack);
        Collections.sort(tempList, Comparator.comparing(Expense::getAmount));
        expenseStack.clear();
        for (Expense exp : tempList) {
            expenseStack.push(exp);
        }

        System.out.println("Expenses sorted by amount.");

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
    }
}
