import java.util.Scanner;

public class Main{
    private int[] arr;
    private int top1, top2;
    private int size;

    public Main(int n) {
        size = n;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int item) {
        if (top1 + 1 == top2) {
            System.out.println("Stack1 is full");
            return;
        }
        arr[++top1] = item;
    }

    public void push2(int item) {
        if (top2 - 1 == top1) {
            System.out.println("Stack2 is full");
            return;
        }
        arr[--top2] = item;
    }

    public int pop1() {
        if (top1 == -1) {
            System.out.println("Stack1 is empty");
            return -1000;
        }
        return arr[top1--];
    }

    public int pop2() {
        if (top2 == size) {
            System.out.println("Stack2 is empty");
            return -1000;
        }
        return arr[top2++];
    }

    public void display1() {
        if (top1 == -1) {
            System.out.println("The contents of the stack1 are {}");
            return;
        }
        System.out.print("The contents of the stack1 are ");
        for (int i = 0; i <= top1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void display2() {
        if (top2 == size) {
            System.out.println("The contents of the stack2 are {}");
            return;
        }
        System.out.print("The contents of the stack2 are ");
        for (int i = top2; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("Choice 1 : Push1");
        System.out.println("Choice 2 : Push2");
        System.out.println("Choice 3 : Pop1");
        System.out.println("Choice 4 : Pop2");
        System.out.println("Choice 5 : Display1");
        System.out.println("Choice 6 : Display2");
        System.out.println("Any other choice : Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the maximum size of the stack");
        int size = scanner.nextInt();
        Main stacks = new Main(size);

        while (true) {
            printMenu();
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter the element to be pushed in stack1");
                int element = scanner.nextInt();
                stacks.push1(element);
            } else if (choice == 2) {
                System.out.println("Enter the element to be pushed in stack2");
                int element = scanner.nextInt();
                stacks.push2(element);
            } else if (choice == 3) {
                int popped = stacks.pop1();
                if (popped != -1000) {
                    System.out.println("The popped element from stack1 is " + popped);
                }
            } else if (choice == 4) {
                int popped = stacks.pop2();
                if (popped != -1000) {
                    System.out.println("The popped element from stack2 is " + popped);
                }
            } else if (choice == 5) {
                stacks.display1();
            } else if (choice == 6) {
                stacks.display2();
            } else {
                break;
            }
        }
        scanner.close();
    }
}
