import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node top = null;

    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    public int pop() {
        if (top != null) {
            Node temp = top;
            int poppedData = temp.data;
            top = top.next;
            temp = null; 
            return poppedData; 
        }
        System.out.println("Stack is empty. Cannot pop.");
        return -1;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void count() {
        int c = 0;
        Node current = top;
        while (current != null) {
            c++;
            current = current.next;
        }
        System.out.println(c);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int a;
        do {
            System.out.println("Choice 1 : Push\nChoice 2 : Pop\nChoice 3 : Display\nChoice 4 : Count\nChoice 5 : Exit\nEnter your choice");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter the element to be pushed:");
                    int b = sc.nextInt();
                    s.push(b);
                    break;
                case 2:
                    int poppedElement = s.pop();
                    if (poppedElement != -1) {
                        System.out.println("The popped element is: " + poppedElement);
                    }
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    s.count();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (a != 5);
        sc.close();
    }
}

