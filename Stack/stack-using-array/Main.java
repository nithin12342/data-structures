class stack{
    int top=-1;
    int [] arr = new int[3];
    public void push(int data)
    {
        if(top==arr.length-1)
        {
        resize();
    }
        top++;
        arr[top]=data;
    }
    public void pop()
    {
        if(top==-1)
        {
            System.out.println("stack is empty.");
        }
        else{
            int temp = arr[top];
            top--;
            temp=0;
            
        }
    }
    public void peek()
    {
        if(top==-1)
        {
            System.out.println("stack is empty.");
        }
        else{
            System.out.println("the peek is : "+arr[top]);
        }
    }
    public void resize()
    {
        int [] temp = new int[arr.length*2];
        for(int i=0;i<arr.length;i++)
        {
            temp[i]=arr[i];
        }
        arr=temp;
        System.out.println("array is re sized.");
    }
    
    public void display()
    {
        if(top==-1)
        {
            System.out.println("stack is empty.");
        }
        else{
            for(int i=0;i<=top;i++)
            {
                System.out.println(arr[i]+" ");
            }
        }
    }
    public void total()
    {
        int to=0;
        for(int i=0;i<=top;i++)
        {
            to+=arr[i];
        }
        System.out.println(to);
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