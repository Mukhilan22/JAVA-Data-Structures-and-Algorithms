
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {    //Class for Linked List has head, and Class for Node
    Node head;

    class Node{                   //A NODE HAS DATA AND NEXT(ADDRESS OF NEXT NDE)
        T data;
        Node next;
        Node(T val){             // CONSTRUCTOR FOR A NEW NODE, takes in value from user
            data = val;
            next = null;
        }
    }

    LinkedList(){                //LINKED LIST CONSTRUCTOR FOR HEAD
        head = null;             //HEAD IS NULL INITIALLY
    }

    public void insertAtBeginning(T val){        //----------INSERT AT BEGINNING------------
        Node newNode = new Node(val);            //Node created with val as data and next as null
        //when list empty
        if(head==null)                           //If linked list is empty,newnode = head
            head = newNode;
        else { //list is not empty
            newNode.next = head;                 //Here Head gets moved to right as next node of newnode is head now
            head = newNode;                      //Now as newnode is the first node, it is the head of linked list
        }

    }

    public void display() {                     //---------------DISPLAY------------------
        Node temp = head; //start from head     //Temporary node is created which is equal to Head
        while(temp != null) {                   //null implies end of list
            System.out.print( temp.data );
            temp = temp.next;                    //Temp jumps to next element with the address sgtored in temp
        }

    }

    public void insertAtPos(int pos,T val) {    //-----------------INSERT AT POSN---------------
        if(pos==0)
        {
            insertAtBeginning(val);             //insertAtBeginning called if posn is zero
            return;
        }

        Node newNode = new Node(val);          //New Node with value is created
        Node temp = head;
        for(int i=1;i<pos;i++) {               //Jump till the node which is before the posn to be inserted
            temp = temp.next;
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid Pos " + pos);  //If posn is out of bound
        }

        //reassign pointers
        newNode.next = temp.next;             //Node is inserted
        temp.next = newNode;

    }

    public void deleteAtPos(int pos) {        //-----------------------DELETE AT POSN----------------

        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

        if(pos==0) {
            head = head.next;
            return;
        }

        Node temp = head;                     //Two temporary node is created as we need to jump till node to be deleted and we need that and prev node
        Node prev = null;

        //jump till node to be deleted
        for(int i=1;i<=pos;i++) {
            prev = temp;                     //Keep track of previous node, after 1 epoch, prev=head, temp=node after head
            temp = temp.next;
        }

        prev.next = temp.next;                //Reassign pointers to delete
    }

    public void deleteAtBeginning() {       //--------------DELETE AT BEGINNING------------------------

        if(head==null)
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

        head = head.next;
    }

    public void reverse() {                //------------------REVERSE----------------------------
        Node prev = null;                  //3 Node pointers created
        Node current = head;
        Node after = head.next;

        while(current!=null) {            //When current = null, full list is traversed
            after=current.next;           //The next node after current is saved using current.next
            current.next = prev;          //Reverse Link(always in current node)
            prev = current;               //Current node becomes prev and after node becomes current node
            current = after;
        }

        head = prev;                      //It ends when current is null and prev is last node, pev is given as head
    }

    public T getPos(int posn){           //----------------GET VAL at POSN--------------------
        Node temp=head;
        for(int i=1;i<posn;i++){
            temp=temp.next;
            }
           return temp.data;
        }

    public void update(int pos,T val){    //------------------UPDATE VAL-----------------------------
        Node temp=head;

        if(pos==0){
            temp.data=val;
        }
        for(int i=1;i<=pos;i++){
            if(temp==null){
                throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
            }
            temp=temp.next;
        }
        temp.data=val;
    }

    public void deleteAtEnd() {                 //-----------------DELETE AT END--------------------
        if(head.next==null){
            deleteAtBeginning();
        }

        Node temp = head;
        Node prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next=null;
    }

    public void InsertatEnd(T val){              //---------------------INSERT AT END---------------------
        if (head == null) {
            insertAtBeginning(val);
        }
        Node newNode = new Node(val);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public int Search(T val){           //----------------GET POSN OF VAL--------------------
        Node temp=head;
        int pos=0;
        while(temp!=null){
            if (temp.data==val){
                break;
            }
            temp=temp.next;
            pos++;
        }
        return pos;
    }

    public boolean contains(T val){     //----------------CHECK WHETHER A LINKED LIST HAS THE DESIRED VAL----------
        Node temp=head;
        while(temp!=null){
            if(temp.data==val){
                break;
            }
            temp=temp.next;
        }
        return(temp==null);
    }

    public int length(){              //-----------------------RETURN LENGTH OF LINKED LIST----------------
        Node temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        return length;
    }





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

/*try the following methods
 *
 * get(pos) - get(2)
 * update(pos,val)
 * deleteAtEnd
 * insertAtEnd(val)
 * search(val) - return index, -1
 * contains(val) - return true or false
 * length
 */

