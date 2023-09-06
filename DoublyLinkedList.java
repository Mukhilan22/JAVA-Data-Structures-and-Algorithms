import java.util.Iterator;
public class DoublyLinkedList<T> implements Iterable<T> {
    Node head;          //DOUBLY LINKED LIST HAS BOTH HEAD AND TAIL AS EACH NODE STORES ADS OR NEXT&PREV NODE
    Node tail;

    class Node{         //DLL HAS DATA, ADS OF NEXT,PREV NODE
        T data;
        Node prev;
        Node next;

        Node(T val){   //CONSTRUCTOR FOR NODE
            data = val;
            next = null;
            prev = null;
        }
    }

    DoublyLinkedList(){  //CONSTRUCTOR OF DLL
        head = null;
        tail = null;
    }

    public void insertAtBeginning(T val){      //-----------------INSERT AT BEGINNING------------------
        Node newNode = new Node(val);

        if(head==null) {                //when list empty
            tail = newNode;
        }
        else {                         //list is not empty
            newNode.next = head;
            head.prev = newNode;       //update prev of head also long newNode.next=head
        }
        head = newNode;                //Make new node as the new head

    }

    public void display() {                 //-----------------DISPLAY FROM FRONT------------------------
        if(head==null)
            System.out.println("List is empty");
        Node temp = head;                  //start from HEAD
        while(temp != null) {             //null implies end of list
            System.out.print(temp.data + " ");
            temp = temp.next;             //jump
        }

    }

    public void displayRev() {             //--------------------DISPLAY FROM BACK----------------------------
        if(head==null)
            System.out.println("List is empty");
        Node temp = tail;                   //start from TAIL
        while(temp != null) {               //null implies end of list
            System.out.print(temp.data + " ");
            temp = temp.prev;                 //jump
        }

    }

    public void insertAtPos(int pos,T val) {    //----------------------INSERT @ POSN-----------------------
        if(pos==0)
        {
            insertAtBeginning(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for(int i=1;i<pos;i++) {                //jump
            temp = temp.next;
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid Pos " + pos);
        }

        //REASSIGN POINTERS @temp alone
        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp==tail)  //REassign TAIL
            tail=newNode;
        else
            temp.next.prev = newNode;  //Reassign prev pointer of next node
        temp.next = newNode;           //Reassign next inter of prev node temp

    }

    public void deleteAtPos(int pos) {       //-----------------------------DELETE AT POSN---------------------------

        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

        if(pos==0) {
            head = head.next;    //Head deleted
            if(head==null)       //If oly one node existed
                tail=null;
            else
                head.prev = null; //Head is deleted
            return;
        }

        Node temp = head;           //Two temp pointers created to delete at a posn
        Node prev = null;

        //jump till NODE TO BE DELETED (we will have temp = node to be deleted)
        for(int i=1;i<=pos;i++) {
            prev = temp;             //keep track of prev node
            temp = temp.next;        //jump to next node
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid position ");

        }

        prev.next = temp.next; //reassign pointers
        if(temp.next==null)    //if nod eto be deleted is last node
            tail = prev;
        else
            temp.next.prev = prev;   //prev of node next to node to be deleted reassigned
    }

    public void deleteAtBeginning() {      //------------------DELETE AT BEGINNING---------------------

        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

        head = head.next;
        if(head==null)
            tail=null;
        else
            head.prev = null;

    }

    public void InsertatEnd(T val){          //-------------------------INSERT @ END-------------------------
        if(head==null){
            insertAtBeginning(val);
        }
        Node newNode = new Node(val);
        Node temp=tail;

        tail.next=newNode;
        newNode.prev=tail;
        newNode=tail;
    }

    public void DeleteAtEnd(){                 //---------------------------DEL @ END-------------------------------------
        if(head.next==null){
            deleteAtBeginning();
        }
        Node temp=tail;                // can directly delete dail
        tail=temp.prev;
        temp.prev.next=null;
    }

    //SEARCH,CONTAINS,LENGTH SAME AS LINKED LIST


    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node temp = head;

            public boolean hasNext() {
                return temp!=null;
            }

            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;

            }
        };
    }


}

/*
 * loop - o(n)
 * no loop - o(1)
 * insertAtEnd
deleteAtEnd
deleteAtBeginning
search
contains
length
 *
 */

