// Name: Nicholas Alvarez
// Class: CS 145
// File: Dictionary.java
 // This class represents a dictionary implemented using a binary search tree (BST).
 //It allows users to add, delete, modify, and search for contacts in the dictionary,
 //as well as print all contacts in pre-order, post-order, or in-order traversal.
 
package binarytrees;
import java.util.NoSuchElementException;
public class Dictionary {
    public TreeNode root = null;

    // Method to add a new contact to the dictionary
    public void addContact(String firstName, String lastName, String email, String phoneNumber, String address) {
        // Call private helper method to recursively add contact
        root = addContact(root, firstName, lastName, email, phoneNumber, address);
    }

    // Private helper method for adding contact recursively
    private TreeNode addContact(TreeNode root, String firstName, String lastName, String email, String phoneNumber, String address) {
        // If the current node is null, create a new TreeNode with provided data
        if (root == null) {
            return new TreeNode(firstName, lastName, email, phoneNumber, address);
        }

        // Compare first names to determine insertion point in BST
        int comparison = firstName.compareTo(root.firstName);
        if (comparison < 0) {
            root.leftTreeNode = addContact(root.leftTreeNode, firstName, lastName, email, phoneNumber, address);
        } else if (comparison > 0) {
            root.rightTreeNode = addContact(root.rightTreeNode, firstName, lastName, email, phoneNumber, address);
        } // else a duplicate, do nothing

        return root;
    }

    // Method to delete a contact from the dictionary
    public void deleteContact(String firstName) {
        // Call private helper method to recursively delete contact
        root = deleteContact(root, firstName);
    }

    // Private helper method for deleting contact recursively
    private TreeNode deleteContact(TreeNode root, String firstName) {
        // Base case: if tree is empty or node not found, return null
        if (root == null) {
            return null;
        }

        // Compare first names to find node to delete
        int comparison = firstName.compareTo(root.firstName);
        if (comparison < 0) {
            root.leftTreeNode = deleteContact(root.leftTreeNode, firstName);
        } else if (comparison > 0) {
            root.rightTreeNode = deleteContact(root.rightTreeNode, firstName);
        } else {  // root.firstName.equals(firstName); remove this node
            // Case 1: no right child, replace with left child
            if (root.rightTreeNode == null) {
                return root.leftTreeNode;
            }
            // Case 2: no left child, replace with right child
            else if (root.leftTreeNode == null) {
                return root.rightTreeNode;
            }
            // Case 3: node to delete has both left and right children
            else {
                // Find minimum value in right subtree
                root.firstName = getMin(root.rightTreeNode);
                // Delete the minimum node from the right subtree
                root.rightTreeNode = deleteContact(root.rightTreeNode, root.firstName);
            }
        }
        return root;
    }

    // Method to get the minimum value (first name) from the dictionary
    public String getMin() {
        // If the tree is empty, throw NoSuchElementException
        if (root == null) {
            throw new NoSuchElementException();
        }
        // Call private helper method to get minimum value recursively
        return getMin(root);
    }

    // Private helper method to get minimum value recursively
    private String getMin(TreeNode root) {
        // Traverse left subtree until reaching leftmost leaf node
        if (root.leftTreeNode == null) {
            return root.firstName;
        } else {
            return getMin(root.leftTreeNode);
        }
    }

    // Method to modify contact information
    public void modifyContact(String modFirstName, String firstName, String lastName, String email, String phoneNumber, String address) {
        // Call private helper method to modify contact recursively
        modifyContact(root, modFirstName, firstName, lastName, email, phoneNumber, address);
    }

    // Private helper method for modifying contact recursively
    private void modifyContact(TreeNode node, String modFirstName, String firstName, String lastName, String email, String phoneNumber, String address) {
        // Base case: if node is null, do nothing
        if (node == null) {
            return;
        }

        // If current node matches the first name to modify, update its attributes
        if (node.firstName.equals(modFirstName)) {
            node.firstName = firstName;
            node.lastName = lastName;
            node.phoneNumber = phoneNumber;
            node.email = email;
            node.address = address;
        } else {
            // Recursively search left and right subtrees
            modifyContact(node.leftTreeNode, modFirstName, firstName, lastName, email, phoneNumber, address);
            modifyContact(node.rightTreeNode, modFirstName, firstName, lastName, email, phoneNumber, address);
        }
    }

    // Method to print dictionary entries in pre-order traversal
    public void printPreOrder() {
        // Call private helper method to print in pre-order
        printPreOrder(root);
    }

    // Private helper method for pre-order traversal
    private void printPreOrder(TreeNode node) {
        if (node != null) {
            // Visit current node and print its attributes
            System.out.println(node.firstName);
            System.out.println(node.lastName);
            System.out.println(node.email);
            System.out.println(node.phoneNumber);
            System.out.println(node.address + "\n");

            // Recursively visit left and right subtrees
            printPreOrder(node.leftTreeNode);
            printPreOrder(node.rightTreeNode);
        }
    }

    // Method to print dictionary entries in post-order traversal
    public void printPostOrder() {
        // Call private helper method to print in post-order
        printPostOrder(root);
    }

    // Private helper method for post-order traversal
    private void printPostOrder(TreeNode node) {
        if (node != null) {
            // Recursively visit left and right subtrees
            printPostOrder(node.leftTreeNode);
            printPostOrder(node.rightTreeNode);

            // Visit current node and print its attributes
            System.out.println(node.firstName);
            System.out.println(node.lastName);
            System.out.println(node.email);
            System.out.println(node.phoneNumber);
            System.out.println(node.address + "\n");
        }
    }

    // Method to print dictionary entries in in-order traversal
    public void printInOrder() {
        // Call private helper method to print in in-order
        printInOrder(root);
    }

    // Private helper method for in-order traversal
    private void printInOrder(TreeNode node) {
        if (node != null) {
            // Recursively visit left subtree
            printInOrder(node.leftTreeNode);
            // Visit current node and print its attributes
            System.out.println(node.firstName);
            System.out.println(node.lastName);
            System.out.println(node.email);
            System.out.println(node.phoneNumber);
            System.out.println(node.address + "\n");
            // Recursively visit right subtree
            printInOrder(node.rightTreeNode);
        }
    }
}
