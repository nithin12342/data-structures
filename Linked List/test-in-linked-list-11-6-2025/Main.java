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

    public void showBillAndAdd(int t) {
        Node n = new Node(t);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void display() {
        System.out.println("Card transactions:");
        Node temp = head;
        if (head == null) {
            System.out.println("No transactions found.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int sum() {
        Node temp = head;
        int total = 0;
        while (temp != null) {
            total += temp.data;
            temp = temp.next;
        }
        return total;
    }
}

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        List l = new List();
        int n;
        do {
            System.out.println("1.Visit the food court");
            System.out.println("2.View my transactions");
            System.out.println("3.Show my points");
            System.out.println("Enter your choice:");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Pay bill amount:");
                    int t = sc.nextInt();
                    l.showBillAndAdd(t);
                    break;
                case 2:
                    l.display();
                    break;
                case 3:
                    int totalPoints = l.sum();
                    if (totalPoints == 0) {
                        System.out.println("Your score is NIL");
                    } else {
                        System.out.println("Gained points: " + totalPoints);
                    }
                    break;
                case 4:
                    System.out.println("Please visit again");
                    break;
                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        } while (n != 4);
        sc.close();
    }
}