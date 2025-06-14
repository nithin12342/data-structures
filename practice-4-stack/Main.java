import java.io.*;
import java.util.Scanner;

class Node {
    Character data;
    Node next;

    Node(Character data) {
        this.data = data;
    }
}

class Stack {
    Node top = null;

    public void push(Character data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    public Character pop() {
        if (top != null) {
            Node temp = top;
            Character poppedData = temp.data;
            top = top.next;
            return poppedData; 
        }
        return null; 
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void balancedornot(Stack s, String par) {
        for (char c : par.toCharArray()) {
            if (c == '(' || c == '[') {
                s.push(c);
            } else if (c == ')' || c == ']') {
                if (s.isEmpty()) {
                    System.out.println("No");
                    return;
                }
                Character top = s.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println(s.isEmpty() ? "Yes" : "No");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String par = sc.nextLine();
            Stack s = new Stack();
            balancedornot(s, par);
        }
        sc.close();
    }
}