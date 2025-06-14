import java.util.Scanner;

class Node {
    int key;
    Node next;

    Node(int key) {
        this.key = key;
        this.next = null;
    }
}

class List {
    Node head;

    public List() {
        this.head = null;
    }

    public void insert(int key) {
        if (key < 0 || key > 9) {
            System.out.println("Enter a valid key number (0-9)");
            return;
        }
        Node newNode = new Node(key);
        if (head == null || head.key > key) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Keyboard has no disassembled key");
            return;
        }
        Node temp = head;
        System.out.print("Keyboard: ");
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List keyboardList = new List();
        int choice;

        do {
            System.out.println("1.Enter a disassembled key");
            System.out.println("2.View keyboard");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key number: ");
                    int key = sc.nextInt();
                    while (key < 0 || key > 9) {
                        System.out.print("Enter the key number: ");
                        key = sc.nextInt();
                    }
                    keyboardList.insert(key);
                    break;
                case 2:
                    keyboardList.display();
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}
