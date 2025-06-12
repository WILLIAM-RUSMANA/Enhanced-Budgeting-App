package DS.AVLTree;

import OOP.Expense;
import java.util.*;


import DS.MethodInterface;
import DS.UtilityMethod;     

public class AVLTree implements MethodInterface {
    public Nodes root;

    //get height of each node
    private int height(Nodes node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    //Update the height of the node
    private int updateHeight(Nodes node) {
        if (node == null) {
            return 0;
        }
        int leftNode =height(node.getLeft());
        int rightNode = height(node.getRight());
        node.setHeight(Math.max(leftNode, rightNode) + 1);
        return node.getHeight();
    }

    //calculate the balance factor of each node
    private int getBalance(Nodes node) {
        if (node == null) {
            return 0;
        }
        int leftNode = height(node.getLeft());
        int rightNode = height(node.getRight());
        return (leftNode - rightNode);
    }


    /*
     * A method that performs right rotation on a given node.
     * This is used to balance the AVL tree when a left-heavy imbalance occurs.
     * @param y The node to be rotated.
     * @return The new root of the subtree after the right rotation.
     *    y                      x
         / \                    / \
        x   T3  (Right Rotate) T1  y
       / \                        / \
      T1  T2                     T2  T3
     */
    private Nodes rightRotate(Nodes y) {
        Nodes x = y.getLeft();
        Nodes T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    /*
     * A method that performs a left rotation on a given node.
     * This is used to balance the AVL tree when a right-heavy imbalance occurs.
     * @param x The node to be rotated.
     * @return The new root of the subtree after the left rotation.
     *    x                      y
         / \                    / \
        T1  y  (Left Rotate)   x   T3
           / \                / \
          T2  T3            T1  T2
     */
    private Nodes leftRotate(Nodes x) {
        Nodes y = x.getRight();
        Nodes T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    /*
     * A method that calculates the balance of the AVL tree.
     * It checks the balance factor of each node and performs rotations accordingly
     * @param node, The root node of the AVL tree or subtree.
     * @return The balanced node after performing necessary rotations.
     */
    private Nodes balances(Nodes node) {
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.getLeft()) >= 0) {
            return rightRotate(node);
        }

        if (balance < -1&& getBalance(node.getRight()) <= 0) {
            return leftRotate(node);
        }

        if (balance > 1 && getBalance(node.getLeft()) < 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.getRight()) > 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    @Override
    /*
     * Method to generate a specified number of expenses in the AVL Tree.
     * It initializes the AVL Tree and inserts expenses using a utility method.
     * Measures the time and memory usage for the operation.
     * @param numValues, The number of expenses to be generated.
     */
    public void generateExpense(int numValues) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        Long startTime = System.nanoTime();

        System.out.println("Generating " + numValues + " expenses in AVL Tree.");
        UtilityMethod utility = new UtilityMethod();
        for (int i = 0; i < numValues; i++) {
            root = insertRec(root, utility.initialiseAddedExpense());
        }

        Long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("AVL Tree", memoryBefore, memoryAfter, endTime, startTime);
    }

    /*
     * Helper method of generateExpense
     * when the avl tree is empty, the method would initiate a new node
     * when it is not, the method would search for an apropriate place to put the node in
     * once found, the method would plce the node in that position, and balances the tree
     * @param expense, is the expense to be inserted
     * @param node, is the current node in the AVL Tree
     */
    private Nodes insertRec(Nodes node, Expense expense) {
        if (node == null) {
            return new Nodes(expense);
        }

        if (expense.getAmount() < node.getExpense().getAmount()) {
            node.setLeft(insertRec(node.getLeft(), expense));
        } else if (expense.getAmount() > node.getExpense().getAmount()) {
            node.setRight(insertRec(node.getRight(), expense));
        } else {
            // If the expense already exists, increment the count
            node.setCount(node.getCount() + 1);
            return node;
        }

        updateHeight(node);
        return balances(node);
    }

    @Override
    /*
     * Method to add an expense at a specific index in the AVL Tree.
     * It does not use indexes like arrays or lists, but rather generates a new expense
     * and inserts it into the AVL Tree.
     * Measures the time and memory usage for the operation.
     * @param amountToAdd, The amount of the expense to be added.
     */
    public void addExpense(int amountToAdd) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        Long startTime = System.nanoTime();

        System.out.println("AVL trees does not have indexes like arrays or lists. objects are through the generateExpense method.");
        UtilityMethod utility = new UtilityMethod();
        Expense expense = utility.initialiseAddedExpense();
        expense.setAmount(amountToAdd); // Set the amount to the specified value
        root = insertRec(root, expense);

        Long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("AVL Tree", memoryBefore, memoryAfter, endTime, startTime);
    }

    @Override
    /*
     * method to view expenses in the AVL Tree.
     * It performs an in-order traversal of the tree to display all expenses.
     * Measures the time and memory usage for the operation.
    */
    public void viewExpenses() {
        System.out.println("Viewing expenses in AVL Tree:");
        inOrderTraversal(root);
    }

    /*
     * A method that performs an in-order traversal of the AVL Tree.
     * It recursively visits the left subtree, processes the current node,
     * and then visits the right subtree.
     * This method prints the details of each expense in the tree.
     * @param node, The current node in the AVL Tree.
     */
    private void inOrderTraversal(Nodes node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            for (int i = 0; i < node.getCount(); i++) {
                System.out.println("Amount: " + node.getExpense().getAmount() + 
                ", Year: " + node.getExpense().getYear()+
                ", Month: " + node.getExpense().getMonth() +
                ", Day: " + node.getExpense().getDate() +
                ", Description: " + node.getExpense().getDescription()+
                ", frequency: " + node.getExpense().getFrequency()
                );
            }
            inOrderTraversal(node.getRight());
        }
    }

    @Override
    public void sortExpenses() {
        System.out.println("Any expense objects added to the AVL Tree are automatically sorted based on their amount, from least to most.");
    }

    @Override
    /*
     * Method to search for an expense by its amount in the AVL Tree.
     * It traverses the tree to find the node with the specified amount.
     * If found, it prints the details of the expense.
     * Measures the time and memory usage for the operation.
     * @param amount, The amount of the expense to be searched.
     */
    public void searchExpense(int amount) {
        UtilityMethod utility = new UtilityMethod();
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        Long startTime = System.nanoTime();


        System.out.println("Searching for expense with amount: " + amount);
        Nodes result = searchRec(root, amount);
        if (result != null) {
            System.out.println("Expense found: " + result.getExpense().getAmount() + 
            ", Year: " + result.getExpense().getYear()+
            ", Month: " + result.getExpense().getMonth() +
            ", Day: " + result.getExpense().getDate() +
            ", Description: " + result.getExpense().getDescription()+
            ", frequency: " + result.getExpense().getFrequency()
            );
        } else {
            System.out.println("No expense found with amount: " + amount);
        }

        Long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("AVL Tree", memoryBefore, memoryAfter, endTime, startTime);
    }

    /*
     * A recursive method to search for an expense by its amount in the AVL Tree.
     * it usese in-order traversal to find the node with the specified amount.
     * If found, it returns the node; otherwise, it returns null.
     * @param node, The current node in the AVL Tree.
     * @param amount, The amount of the expense to be searched.
     * @return The node containing the expense with the specified amount, or null if not found.
     */
    private Nodes searchRec(Nodes node, int amount) {
        if (node.getExpense().getAmount() == amount) {
            return node;
        } else if (amount < node.getExpense().getAmount()) {
            return searchRec(node.getLeft(), amount);
        } else if( amount > node.getExpense().getAmount()) {
            return searchRec(node.getRight(), amount);
        }
        return null; 
    }

    
    @Override
    /*
     * this method removes an expense from the AVL Tree based on its amount.
     * It searches for the node with the specified amount,
     * and removes it while maintaining the AVL Tree properties.
     */
    public void removeExpense(int amountToRemove){
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        Long startTime = System.nanoTime();
        System.out.println("Removing expense with amount: " + amountToRemove);

        root = deleteRecursive(root, amountToRemove);

        Long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        UtilityMethod utility = new UtilityMethod();
        utility.printMemoryAndTime("AVL Tree", memoryBefore, memoryAfter, endTime, startTime);
        System.out.println("Expense with amount " + amountToRemove + " removed successfully.");
    }

    /*
     * this method deletes an expense from the AVL Tree based on its amount.
     * It recursively searches for the node with the specified amount,
     * and removes it while maintaining the AVL Tree properties.
     * @param node, The current node in the AVL Tree.
     * @param amountToRemeve, The amount of the expense to be removed.
     * @return The updated node after deletion, or null if the expense was not found.
     */
    private Nodes deleteRecursive(Nodes node, double amountToRemove) {
        if (node == null) {
            return node; // Expense not found
        }

        if (amountToRemove < node.getExpense().getAmount()) {
            node.setLeft(deleteRecursive(node.getLeft(), amountToRemove));
        } else if (amountToRemove > node.getExpense().getAmount()) {
            node.setRight(deleteRecursive(node.getRight(), amountToRemove));
        } else {
            // Node with matching expense amount is found
            if (node.getCount() > 1) {
                node.setCount(node.getCount() - 1);
                return node; 
            } else {

                // Node with only one child or no child
                if (node.getLeft() == null || node.getRight() == null) {
                    Nodes temp;
                    if(node.getLeft() != null){
                        temp = node.getLeft();
                    } else{
                        temp = node.getRight();
                    }

                    if (temp == null) {
                        // No child case
                        node = null; 
                    } else {
                        // One child case, replace node with its child
                        node = temp;
                    }
                } else {
                    // Node with two children: Get the smallest node in the right subtree
                    Nodes temp = findMin(node.getRight());

                    // Copy the in-order successor's expense and count to this node
                    node.setExpense(temp.getExpense());
                    node.setCount(temp.getCount());

                    // Delete the in-order successor from its original position in the right subtree.
                    // We must ensure the actual successor node is deleted, not just its count decremented.
                    temp.setCount(1); 
                    node.setRight(deleteRecursive(node.getRight(), temp.getExpense().getAmount()));
                }
            }
        }
        if (node == null) {
            return node;
        }
        updateHeight(node);
        return balances(node);
    }

    /*
     * helper method for deleteRecursive
     * finds the minimum value in any sub-tree
     * @ param node, is the starting point/root of the search
     * @ return the smallest node in that sub-tree
    */
    private Nodes findMin(Nodes node) {
        Nodes current = node;
        // Loop down to find the leftmost leaf
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    @Override
    /*
     * Method to update an expense in the AVL Tree.
     * It searches for the expense by its amount and updates its details.
     * Measures the time and memory usage for the operation.
     * @param amountToUpdate, The amount of the expense to be updated.
     */
    public void updateExpense(int amountToUpdate) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        Long startTime = System.nanoTime();

        System.out.println("AVL Tree does not use indexes like arrays or lists." +
        " any value passed in this method will be ignored, and only the amount variable in the updated expense will be considered.");

        UtilityMethod utility = new UtilityMethod();
        root = UpdateExpenseRec(root, amountToUpdate);

        Long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        utility.printMemoryAndTime("AVL Tree", memoryBefore, memoryAfter, endTime, startTime);
    }

    /*
     * A recursive method to update an expense in the AVL Tree.
     * It searches for the node with the specified expense amount and updates its details.
     * If the node is found, it updates the expense details and resets the count to 1.
     * @param node, The current node in the AVL Tree.
     * @param updatedExpense, The new expense amount to be updated.
     * @return The updated node after the update operation.
     */
    private Nodes UpdateExpenseRec(Nodes node, int updatedExpense) {
        UtilityMethod utility = new UtilityMethod();
        utility.initialiseUpdatedExpense();
        if (node == null) {
            return null; // Expense not found
        }

        if (updatedExpense < node.getExpense().getAmount()) {
            node.setLeft(UpdateExpenseRec(node.getLeft(), updatedExpense));
        } else if (updatedExpense > node.getExpense().getAmount()) {
            node.setRight(UpdateExpenseRec(node.getRight(), updatedExpense));
        } else {
            // Node with matching expense amount is found
        node.getExpense().setAmount(utility.getUpdatedExpense().getAmount());
        node.getExpense().setYear(utility.getUpdatedExpense().getYear());
        node.getExpense().setMonth(utility.getUpdatedExpense().getMonth());
        node.getExpense().setDate(utility.getUpdatedExpense().getDate());
        node.getExpense().setDescription(utility.getUpdatedExpense().getDescription());
        node.getExpense().setFrequency(utility.getUpdatedExpense().getFrequency());
        node.setCount(1); // Reset count to 1 after update
        }

        updateHeight(node);
        return balances(node);
    }

    
}
