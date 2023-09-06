public class CircularLinkedList<T>{
    Node last;          //Last Node is stored instead of head

    class Node{
        T data;
        Node next;
        Node(T val){      //Node Constructor
            data = val;
            next = null;
        }
    }
    CircularLinkedList(){   //last constructor
        last = null;
    }

    public void insertAtBeginning(T val){     //---------------INSERT AT BEGINNING------------------
        Node newNode = new Node(val);
        if(last==null) {
            newNode.next = newNode;      //New node points to itself if its the only node in circular linked list
            last = newNode;
        }
        else {
            newNode.next = last.next;    //New Node point to first node
            last.next = newNode;         //New Node inserted between last and first
        }

    }

    public void insertAtEnd(T val){       //------------------INSERT AT END-----------------------
        Node newNode = new Node(val);
        if(last==null) {
            newNode.next = newNode;
            last = newNode;
        }
        else {
            newNode.next = last.next;
            last.next = newNode;
            last=newNode;            //LAST SHIFTS
        }

    }

    public void display() {          //------------------------DISPLAY----------------------
        if(last==null)
            return;
        Node temp = last.next;     //temp pointer created with first ode
        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while(temp!=last.next);   //terminate loop when temp = last.next


    }

    public T deleteAtBeginning() {           //------------------DELETE AT BEGINNING-------------
        if(last==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        T temp = last.next.data;     //get data of node to be deleted to return
        if(last.next==last)        //has oly one node
            last = null;
        else
            last.next = last.next.next;  //node deleted

        return temp;   //return deleted data

    }

    public void deleteAtEnd() {             //--------------DELETE AT END----------------
        if(last==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        if(last.next==last)
            last = null;
        else {
            Node temp = last.next;
            while(temp.next!=last) {  //Stop at node before last
                temp = temp.next;
            }
            temp.next = last.next; //last node deleted
            last = temp;
        }

    }

}