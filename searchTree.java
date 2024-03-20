// Name: Nicholas Alvarez
// Class: CS 145
// File: searchTree.java
// This program implements a dictionary using a binary search tree (BST) in Java. 
// The dictionary allows users to perform various operations such as adding, searching, 
// and deleting entries. Each entry in the dictionary represents a person's information, including first name,
// last name, and additional details like street address, city, state, zip code, email, and phone number.
// Users can add new entries, search for existing entries by last name, delete entries, and 
// display all entries in the dictionary in an in-order traversal.
package binarytrees;
import java.util.Scanner;

package binarytrees;
import java.util.Scanner;
// Main class for managing the dictionary
public class searchTree {
    public static void main(String[] args) {
        // Create a new instance of Dictionary to store records
        Dictionary records = new Dictionary();
        boolean running = true;

        // Display welcome message
        System.out.println("Welcome to Employee Records");

        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        while (running) {
            // Display menu options
            System.out.println("\nEMPLOYEE RECORDS MENU:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Modify Contact");
            System.out.println("4. Print Contacts (Pre-order)");
            System.out.println("5. Print Contacts (Post-order)");
            System.out.println("6. Print Contacts (In-order)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Switch statement to handle user's choice
            switch (choice) {
                case 1:
                    // Add a new contact
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    // Call addContact method to insert new contact into the dictionary
                    records.addContact(firstName, lastName, address, city, phoneNumber);
                    break;
                case 2:
                    // Delete a contact
                    System.out.print("Enter first name of contact to delete: ");
                    String delFirstName = scanner.nextLine();
                    System.out.print("Enter last name of contact to delete: ");
                    String delLastName = scanner.nextLine();
                    // Call deleteContact method to remove the specified contact from the dictionary
                    records.deleteContact(delFirstName);
                    break;
                case 3:
                    // Modify a contact's information
                    System.out.print("Enter first name of contact to modify: ");
                    String modFirstName = scanner.nextLine();
                    System.out.print("Enter last name of contact to modify: ");
                    String modLastName = scanner.nextLine();
                    System.out.print("Enter new first name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Enter new last name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new city: ");
                    String newCity = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    // Call modifyContact method to update the specified contact's information
                    records.modifyContact(modFirstName, newFirstName, newLastName, newAddress, newPhoneNumber, newEmail);
                    break;
                case 4:
                    // Print the phonebook entries in pre-order traversal
                    records.printPreOrder();
                    break;
                case 5:
                    // Print the phonebook entries in post-order traversal
                    records.printPostOrder();
                    break;
                case 6:
                    // Print the phonebook entries in in-order traversal
                    records.printInOrder();
                    break;
                case 7:
                    // Exit the program
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        // Display exit message and close the scanner
        System.out.println("Exiting...");
        scanner.close();
    }
}
