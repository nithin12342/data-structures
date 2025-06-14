import java.io.*;
import java.util.Scanner;

class Stack {
    int top = -1;
    int[] arr = new int[5];

    public void push(int data) {
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1; 
        } else {
            int temp = arr[top];
            top--;
            return temp;
        }
    }
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " "); 
            }
            System.out.println(); 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int a; 
        do {
            System.out.println("Choice 1 : Push\nChoice 2 : Pop\nChoice 3 : Display\nAny other choice : Exit\nEnter your choice");
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
                default:
                    System.out.println("Exiting...");
                    break; 
            }
        } while (a >= 1 && a <= 3); 
        sc.close(); 
    }
}
