class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class List {
    Node head, tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void insertlast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public void insertfirst(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
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
        Node temp = head;
        Node n = new Node(data);
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        n.next = temp.next;
        n.prev = temp;
        if (temp.next != null) {
            temp.next.prev = n;
        }
        temp.next = n;
        if (n.next == null) {
            tail = n;
        }
    }

    public void deletefirst() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
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
        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp == tail) {
                tail = temp.prev;
            }
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    public void deletelast() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void revers() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public void search(int value) {
        int c = 1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value found at position " + c + ". The value is: " + temp.data);
                return;
            }
            temp = temp.next;
            c++;
        }
        System.out.println("Value not found in the list.");
    }

    public int findMax() {
        if (head == null) {
            throw new RuntimeException("Cannot find max in an empty list");
        }
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max; 
    }

    public void sort() {
        if (head == null) return;
        boolean swap = true;
        Node current;
        while (swap) {
            swap = false;
            current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swap = true;
                }
                current = current.next;
            }
        }
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
