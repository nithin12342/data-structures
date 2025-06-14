import java.io.*;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    Node head, tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        if (data < 1 || data > 100) {
            System.out.println("Oops!!! not in the range.");
            return;
        }
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Desktop is Empty");
            return;
        }
        System.out.print("Files are: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void ascending() {
        if (head == null) return;
        Node current = head, index = null;
        int temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List fileList = new List();
        int choice;

        do {
            System.out.println("1.Enter a new file \n2.View desktop\n3.Arrange in order\n4.Exit\nEnter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the file");
                    int file = sc.nextInt();
                    fileList.append(file);
                    break;
                case 2:
                    fileList.display();
                    break;
                case 3:
                    fileList.ascending();
                    fileList.display();
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
