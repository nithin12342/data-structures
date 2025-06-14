class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    Node head;

    public List() {
        this.head = null;
    }

    public void insertlast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            n.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != head);
    }

    public void insertfirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            n.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            n.next = head;
            head = n;
            temp.next = head;
        }
    }

    public void insertposition(int pos, int data) {
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            insertfirst(data);
            return;
        }
        Node n = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
    }

    public void deletefirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
    }

    public void deleteposition(int pos) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            deletefirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp.next == head) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        if (temp.next != head) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    public void deletelast() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public void revers() {
        if (head == null) return;
        Node prev = null;
        Node current = head;
        Node next;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);
        head.next = prev;
        head = prev;
    }

    public void search(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        int c = 1;
        do {
            if (temp.data == value) {
                System.out.println("Value found at position " + c + ". The value is: " + temp.data);
                return;
            }
            temp = temp.next;
            c++;
        } while (temp != head);
        System.out.println("Value not found in the list.");
    }

    public int findMax() {
        if (head == null) {
            throw new RuntimeException("Cannot find max in an empty list");
        }
        int max = head.data;
        Node current = head.next;
        do {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        } while (current != head);
        return max; 
    }

    public void sort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            do {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            } while (current.next != head);
        } while (swapped);
    }
}

public class Main {
    public static void main(String[] args) {
        List l = new List();
       System.out.println("Insert at last");
        l.insertlast(10);
        l.insertlast(20);
        l.insertlast(30);
        l.insertlast(40);
        l.display();
        System.out.println("Insert at first");
        l.insertfirst(0);
        l.display();
        System.out.println("Insert at specific position");
        l.insertposition(2, 50);
        l.display();
        System.out.println("Delete at first");
        l.deletefirst();
        l.display();
        System.out.println("Delete at specific position");
        l.deleteposition(2);
        l.display();
        System.out.println("Delete at last");
        l.deletelast();
        l.display();
        System.out.println("reverse of list");
        l.revers();
        l.display();
        l.search(30);
        System.out.println("The max element: " + l.findMax());
        System.out.println("after sort");
        l.sort();
        l.display();
    }
}
