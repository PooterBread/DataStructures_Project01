/**
 * Data Structures - Project 1
 * Name: Peter Siba
 * Due Date : 09/30/2025
 * Professor Meghana
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IDedLinkedList<Product> list = new IDedLinkedList<>();

        int choice;
        do { //shows list of choices for user
            System.out.println("\nOperations on List");
            System.out.println("1. Make Empty");
            System.out.println("2. Find ID");
            System.out.println("3. Insert At Front");
            System.out.println("4. Delete From Front");
            System.out.println("5. Delete ID");
            System.out.println("6. Print All Records");
            System.out.println("7. Done");
            System.out.print("Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) { //performs the chosen operation
                case 1:
                    list.makeEmpty();
                    System.out.println("List emptied.");
                    break;
                case 2:
                    System.out.print("ID No: ");
                    int findID = sc.nextInt();
                    Product found = list.findID(findID);
                    if (found != null) {
                        found.printID();
                    } else {
                        System.out.println("ID not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Supplier Name: ");
                    String supplier = sc.nextLine();

                    Product newProduct = new Product(id, name, supplier);
                    if (list.insertAtFront(newProduct)) {
                        System.out.println("Product Added");
                    } else {
                        System.out.println("Duplicate ID. Not added.");
                    }
                    break;
                case 4:
                    Product deletedFront = list.deleteFromFront();
                    if (deletedFront != null) {
                        deletedFront.printID();
                        System.out.println("First item deleted");
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteID = sc.nextInt();
                    Product deleted = list.delete(deleteID);
                    if (deleted != null) {
                        deleted.printID();
                        System.out.println("Item deleted.");
                    } else {
                        System.out.println("ID not found.");
                    }
                    break;
                case 6:
                    list.printAllRecords();
                    break;
                case 7:
                    System.out.println("Done.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
