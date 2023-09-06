public class LLstack<T> {     //----STACK USING LL----
    Node top;
    class Node {
        T data;
        Node next;

        Node(T val) {
            data = val;
            next = null;
        }
    }
    LLstack(){
        top=null;
    }
    public void push(T val) {         //---------PUSH---------
        Node newNode = new Node(val);
        if(top==null){
            newNode=top;
        }
        else{
            newNode.next = top;     //in LL head.next=newNode, in Stack newNode.next = head
            top = newNode;
        }
    }

    public void display(){             //------------DISPLAY-----------
        if (top!=null){
            Node temp=top;
            while(temp.next!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }

    public T pop(){                //------------POP----------
        if(top==null){
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        }
        Node temp=top;
        T value = top.data;
        top.next=top;
        return value;
    }

    public void peek() {           //----------PEEK-----------
        if (top == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        }
        Node temp=top;
        System.out.println(temp.data);
    }

    public boolean isempty(){     //-----------IS EMPTY---------
        return top==null;
        }

}


