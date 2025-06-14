import java.util.Scanner;

class Node {
    int good_number;
    Node next;

    Node(int good_number) {
        this.good_number = good_number;
        this.next = null;
    }
}

class List {
    Node head;
    Node tail;

    void append(int good_number) {
        Node newNode = new Node(good_number);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("Stock list is empty");
            return;
        }
        Node current = head;
        System.out.print("Stock list: ");
        while (current != null) {
            System.out.print(current.good_number + " ");
            current = current.next;
        }
        System.out.println();
    }

    void deleteAtBeginning() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List stockList = new List();
        int choice;

        do {
            System.out.println("1.Add goods to be delivered");
            System.out.println("2.List the goods");
            System.out.println("3.Delivered a good");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the stock id: ");
                    int stockId = scanner.nextInt();
                    stockList.append(stockId);
                    break;
                case 2:
                    stockList.display();
                    break;
                case 3:
                    if (stockList.head != null) {
                        stockList.deleteAtBeginning();
                        System.out.println("Successfully delivered");
                    } else {
                        System.out.println("Stock list is empty");
                    }
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
        scanner.close();
    }
}
