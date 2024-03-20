// Name: Nicholas Alvarez
// Class: CS 145
// File: treeNode.java
// Class representing a node in a binary tree
package binarytrees;
public class TreeNode {
    // Constructor to initialize node with contact information
    public TreeNode(String firstName, String lastName, String email, String phoneNumber, String address) {
        // Initialize node attributes with provided values
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Attributes to store contact information
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String address;

    // References to left and right child nodes
    public TreeNode leftTreeNode = null;
    public TreeNode rightTreeNode = null;
}
