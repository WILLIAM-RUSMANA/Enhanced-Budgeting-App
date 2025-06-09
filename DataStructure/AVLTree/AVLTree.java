package DataStructure.AVLTree;

import OOP.Expense;
import java.util.*;


import DataStructure.MethodInterface;
import DataStructure.UtilityMethod;     

public class AVLTree implements MethodInterface {
    private Nodes root;

    public AVLTree() {
        this.root = null;
    }

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
    public void generateExpense(int numValues) {
        System

        UtilityMethod utility = new UtilityMethod();
        AVLTree tree = new AVLTree();
        for (int i = 0; i < numValues; i++) {
            tree.insert(utility.initialiseAddedExpense());
        }
    }

    /*
     * Helper method of generateExpense
     * when the avl tree is empty, the method would initiate a new node
     * when it is not, the method would search for an apropriate place to put the node in
     * once found, the method would plce the node in that position, and balances the tree
     * @param expense, is the expense to be inserted
     */
    private void insert(Expense expense) {
        Nodes newNode = new Nodes(expense);
        if (root == null) {
            root = newNode;
            return;
        }

        Nodes current = root;
        Nodes parent = null;
        Stack<Nodes> nodeStack = new Stack<>();

        while(current != null){
            parent = current;
            nodeStack.push(current);

            if(expense.getAmount()>current.getExpense().getAmount()){
                current = current.getRight();
            } else if(expense.getAmount()<current.getExpense().getAmount()){
                current = current.getLeft();
            } else {
                // If the expense already exists, increment the count
                current.setCount(current.getCount() + 1);
                return;
            }
        }

        if (expense.getAmount() > parent.getExpense().getAmount()) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }        
        while (!nodeStack.isEmpty()) {           
            Nodes node = nodeStack.pop();
            updateHeight(node);
            node = balances(node);
            if (node == root) {
                root = node;
            } else if (node.getExpense().getAmount() > parent.getExpense().getAmount()) {
                parent.setRight(node);
            } else {
                parent.setLeft(node);
            }
            parent = node;
        }
    }


    public void addExpense(int index) {
        System.out.println("AVL trees does not have indexes like arrays or lists. objects are through the generateExpense method.");
        UtilityMethod utility = new UtilityMethod();
        
        
    }





    
}
