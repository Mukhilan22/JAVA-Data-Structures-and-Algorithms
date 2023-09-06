
public class ArrayLL <T>{
      Node head;

    class Node{
        T data;
        Node next;
        Node(T val){
            data = val;
            next = null;
        }
    }
    ArrayLL(){
        head=null;
    }

    public void Enqueue(T val){
        Node newNode=new Node(val);
        if(head==null){
            newNode=head;
        }
        else{
            Node temp=head;
            while(temp.next!=null){     //So that value is added at last
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

    public T Dequeue(){
        if(head==null){
            throw new IndexOutOfBoundsException("QUEUE EMPTY");
        }
        T value=head.data;
        head.next=head;
        return value;
    }

    public void Display(){
        if(head==null){
            System.out.println("Empty");
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                System.out.println(temp.data + " ");
                temp=temp.next;
            }
        }
    }

}


