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
     * @param node The root node of the AVL tree or subtree.
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

    /*
     * A method to insert a new expense into the AVL tree.
     * It recursively finds the correct position for the new node and balances the tree.
     * @param node The current node in the AVL tree.
     * @param expense The Expense object to be inserted.
     * @return The root of the balanced AVL tree after insertion.
     */
     private Nodes insert(Nodes node, Expense expense) {
        if (node == null) {
            return new Nodes(expense);
        }

        if(expense.getAmount() < node.getExpense().getAmount()) {
            node.setLeft(insert(node.getLeft(), expense));
        } else if (expense.getAmount() > node.getExpense().getAmount()) {
            node.setRight(insert(node.getRight(), expense));
        } else {
            // If the amount is equal, we can choose to ignore or handle duplicates
            node.setCount(node.getCount() + 1); // Increment count if duplicate
            return node;
        }

        updateHeight(node);
        return balances(node);
    }

    @Override
    public void generateExpense(int numValues) {
        UtilityMethod utility = new UtilityMethod();

        for (int i = 0; i < numValues; i++) {
            root = insert(root, utility.initialiseExpense());
        }
    }



    
}
