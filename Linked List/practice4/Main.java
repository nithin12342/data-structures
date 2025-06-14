import java.util.Scanner;

class Node {
    int id;
    Node next;

    Node(int id) {
        this.id = id;
        this.next = null;
    }
}

class List {
    Node head, tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void append(int id) {
        Node newNode = new Node(id);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Employees ID list is empty");
            return;
        }
        Node temp = head;
        System.out.print("Employees ID list:");
        while (temp != null) {
            System.out.println(temp.id);
            temp = temp.next;
        }
    }

    public void deleteAnyElement(int id) {
        if (head == null) {
            System.out.println("Employee ID " + id + " is not found");
            return;
        }
        if (head.id == id) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Employee ID are removed from the Company.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Employee ID " + id + " is not found");
        } else {
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
            System.out.println("Employee ID are removed from the Company.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List employeeList = new List();
        int choice;

        do {
            System.out.println("1.Insert a new Employee");
            System.out.println("2.Display the Employees");
            System.out.println("3.Remove an Employee ID");
            System.out.println("4.Exit");
            System.out.print("Enter your choice\n");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter an Employee id");
                    int id = sc.nextInt();
                    employeeList.append(id);
                    break;
                case 2:
                    employeeList.display();
                    break;
                case 3:
                    System.out.println("Enter an Employee id to be removed");
                    int removeId = sc.nextInt();
                    employeeList.deleteAnyElement(removeId);
                    employeeList.display();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
