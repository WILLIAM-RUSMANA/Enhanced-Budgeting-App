package DS;

import DS.AVLTree.AVLTree;
import DS.ArrayList.ArrayListMethod;
import DS.HashMap.HashMapMethod;
import DS.LinkedList.LinkedListMethod;
import DS.Stack.StackMethod;

public class WarmUpJVM {

    public ArrayListMethod methodsAL1 = new ArrayListMethod();
    public LinkedListMethod methodsLL1 = new LinkedListMethod();
    public HashMapMethod methodsHM1 = new HashMapMethod();
    public AVLTree avlTree1 = new AVLTree();
    public StackMethod methodStack1 = new StackMethod();
    
    public void warmUpGeneration(int numExpenses){
        methodsAL1.generateExpense(numExpenses, false);
        methodsLL1.generateExpense(numExpenses, false);
        methodsHM1.generateExpense(numExpenses, false);
        avlTree1.generateExpense(numExpenses, false);
        methodStack1.generateExpense(numExpenses, false);
  
    }

    public void warmUpAddition(int indexToAdd){
        methodsAL1.addExpense(indexToAdd, false);
        methodsLL1.addExpense(indexToAdd, false);
        methodsHM1.addExpense(indexToAdd, false);
        methodStack1.addExpense(indexToAdd, false);

    }

    public void warmUpRemoval(int indexToAdd){
        methodsAL1.removeExpense(indexToAdd, false);
        methodsLL1.removeExpense(indexToAdd, false);
        methodsHM1.removeExpense(indexToAdd, false);
        methodStack1.removeExpense(indexToAdd, false);
    }

    public void warmUpSorting(){
        methodsAL1.sortExpenses(false);
        methodsLL1.sortExpenses(false);
        methodsHM1.sortExpenses(false);
        methodStack1.sortExpenses(false);
    }

    public void warmUpSearching(int indexToAdd){
       // methodsAL1.searchExpense(indexToAdd, false);
        methodsLL1.searchExpense(indexToAdd, false);
        methodsHM1.searchExpense(indexToAdd, false);
        methodStack1.searchExpense(indexToAdd, false);
    }

    public void clearWarmUp(){
        methodsAL1.clear();
        methodsHM1.clear();
        methodStack1.clear();
        methodsLL1.clear();
        avlTree1.clear();
    }
}

