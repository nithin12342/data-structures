import java.util.Scanner;

class Node {
    String name;
    int memory;
    Node next;

    Node(String name, int memory) {
        this.name = name;
        this.memory = memory;
        this.next = null;
    }
}

class List {
    Node head, tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void append(String name, int memory) {
        Node newNode = new Node(name, memory);
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
            System.out.println("Software list is empty");
            return;
        }
        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ") " + temp.name + " " + temp.memory);
            temp = temp.next;
            index++;
        }
    }

    public Node findMin() {
        if (head == null) {
            return null;
        }
        Node minNode = head;
        Node current = head.next;
        while (current != null) {
            if (current.memory < minNode.memory) {
                minNode = current;
            }
            current = current.next;
        }
        return minNode;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List softwareList = new List();
        int choice;

        do {
            System.out.println("1.Insert new software");
            System.out.println("2.Display all the softwares");
            System.out.println("3.Get the minimum memory software");
            System.out.println("4.Exit");
            System.out.print("Enter your choice\n");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the software name");
                    String name = sc.nextLine();
                    System.out.println("Enter the memory used");
                    int memory = sc.nextInt();
                    softwareList.append(name, memory);
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("Software list:");
                    softwareList.display();
                    break;
                case 3:
                    Node minNode = softwareList.findMin();
                    if (minNode != null) {
                        System.out.println("Minimum memory Software is:");
                        System.out.println(minNode.name + " " + minNode.memory);
                    } else {
                        System.out.println("Software list is empty");
                    }
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

