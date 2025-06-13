package DS;

public interface MethodInterface {
    void generateExpense(int numValues, boolean printMetric);
    void addExpense(int indexToAdd, boolean printMetric);
    void removeExpense(int indexToRemove, boolean printMetric);
    void updateExpense(int indexToUpdate, boolean printMetric);
    void searchExpense(int indexToSearch, boolean printMetric);
    void viewExpenses(boolean printMetric);
    void sortExpenses(boolean printMetric);
    
} 
