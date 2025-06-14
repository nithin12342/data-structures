class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
    }
}
class stack
{
    Node top = null;
    public void push(int data)
    {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
    public void pop()
    {
        if (top != null) {
            Node temp = top;
            top = top.next;
            temp = null;
        }
    }
    public void peek()
    {
        if (top != null)
            System.out.println(top.data);
    }
    public void display()
    {
        Node current = top;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void total()
    {
        int sum = 0;
        Node current = top;
        while (current != null)
        {
            sum += current.data;
            current = current.next;
        }
        System.out.println(sum);
    }
}


public class Main
{
    public static void main(String[] args)
    {
        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.pop();
        s.display();
        s.peek();
        s.total();
    }
}

