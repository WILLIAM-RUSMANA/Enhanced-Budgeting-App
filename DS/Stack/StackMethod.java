package DS.Stack;

import OOP.Expense;

import java.util.*;

import DS.MethodInterface;
import DS.UtilityMethod;

public class StackMethod implements MethodInterface {
    UtilityMethod utility = new UtilityMethod();
    public Stack<Expense> expenseStack = new Stack<>();

    @Override
    /*
     * this method is used to generate expense object
     * the number of expense object generated is dependent on numValues
     * once generated, the expense object would be pusde into a stack
     * @param numValues, the number of expense object to be printed
     * @param printMetric, decides whether to print performance metric
     */
    public void generateExpense(int numValues, boolean printMetric) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < numValues; i++) {
            expenseStack.push(utility.initialiseExpense());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    @Override
    /*
     * the method is used to add an expense object to a specific index in the stack
     * a new stack is initialised 
     * all content, from the old stack, up to the indexToAdd is pushed into it
     * new expense object is then inserted into the old stack
     * all content from the newly created stack would be pushed into the ols stack
     * 
     * @param indexToAdd, the index at which the new expense object is inserted
     * @printMetric, wheter or not to print performance metric
     */
    public void addExpense(int indexToAdd, boolean printMetric) {
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



        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    @Override
    /*
     * the method is used to remove an expense object at a specific index in the stack
     * a new stack is initialised 
     * all content, from the old stack, up to the indexToAdd is pushed into it
     * new expense object is then inserted into the old stack
     * all content from the newly created stack would be pushed into the ols stack
     * 
     * @param indexToRemove, the index at which the new expense object is inserted
     * @printMetric, wheter or not to print performance metric
     */
    public void removeExpense(int indexToRemove, boolean printMetric) {
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

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    @Override
    /*
     * the method is used to update an expense object at a specific index in the stack
     * a new stack is initialised 
     * all content, from the old stack, up to the indexToAdd is pushed into it
     * new expense object is then inserted into the old stack
     * all content from the newly created stack would be pushed into the ols stack
     * 
     * @param indexToUpdate, the index at which the new expense object is inserted
     * @printMetric, wheter or not to print performance metric
     */
    public void updateExpense(int indexToUpdate, boolean printMetric) {
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

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    @Override
    public void searchExpense(int indexToSearch, boolean printMetric) {
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

        while (!tempStack.isEmpty()) {
            expenseStack.push(tempStack.pop());
        }

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    @Override
    public void viewExpenses(boolean printMetric) {
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
        
        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    @Override
    public void sortExpenses(boolean printMetric) {
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
        
        if(printMetric==true){
        utility.printMemoryAndTime("Stack", memoryBefore, memoryAfter, endTime, startTime);
        }
    }

    public void clear(){
        expenseStack.clear();
        System.out.println("All content of Stack has been deeletd");
    }
}
