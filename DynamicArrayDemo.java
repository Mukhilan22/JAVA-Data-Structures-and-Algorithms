import java.util.*;
class DynamicArray{ //variables - methods
    private static final int initialCapacity = 16;      //Give initial capacity which is length of the array
    private int arr[];                                  //Array is created
    private int size;                                   //Size is the no of elements in array
    private int capacity;                               //temp for initial capacity

    DynamicArray(){                        //CONSTRUCTOR      AN array with zero elements,16 as length is created
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }

    public void add(int val) {       //----------------------------INSERT ELEMENT AT END-----------------------------
        if(size==capacity)
            expandArray();           //Initial Capacity*2 as full length of array is occupied
        arr[size++] = val;           //value is inserted in last and size is increased by 1

    }

    private void expandArray() {  //--------------------TO increase capacity of array by 2--------------------
        capacity *= 2;
        arr = java.util.Arrays.copyOf(arr,capacity);
    }

    public void display() {
        System.out.println("Elements in the list: ");    //--------------DISPLAY ALL ELEMENTS IN ARRAY---------------------
        for(int i=0;i<size;i++)
            System.out.print(arr[i] + " ");
    }

    public void insertAtPos(int pos,int val) {     //-----------INSERT ELEMENT AT A POSITION-----------------
        if(size==capacity)
            expandArray();
        for(int i=size-1;i>=pos;i--)
            arr[i+1] = arr[i];                    //as we shift to right Shift from last, if u shift from first, there is overriding of elements
        arr[pos] = val;
        size++;
    }

    public void deleteAtPos(int pos) {            //-----------------DELETE AT A POSN---------------------

        for(int i=pos+1;i<size;i++)
            arr[i-1] = arr[i];                    //As shifted to left, shift from start instead of last to avoid overriding

        size--;

        if(capacity > initialCapacity && capacity > 3*size)
            shrinkArray();
    }

    private void shrinkArray() {                 //----------------SHRINK ARRAY when unneded capacity is there----------------------
        capacity /= 2;
        arr =java.util.Arrays.copyOf(arr, capacity);  //Creates copy of array and stores in that
    }

    public int length() {
        return size;
    }

    public void delstart(){                     //------------DELETE first element--------------------
        for(int i=0;i<size;i++){
            arr[i]=arr[i+1];
        }
        size--;
    }

    public void InsertBeg(int val){              //-------------INSERT AT START------------------------
        if(size==capacity)
            expandArray();

        for(int i=size-1;i>=0;i++){
            arr[i]=arr[i-1];
        }
        arr[0]= val;
        size++;
    }
    public void Get(int pos){                       //-----------------GET ELEMENT FROM A POSN------------

        System.out.println(arr[pos]);
    }
    public void Update(int val,int pos){            //-----------UPDATE ELEMENT AT A POSN-------------

        arr[pos]= val;
    }
    public void search(int val){                   //--------------SEARCH FOR VAL AND RETURN INDEX--------------
        for(int i=0;i<size;i++){
            if (arr[i]==val){
                System.out.println(i);
            }
            else {
                System.out.println("Value not found");
            }
        }
    }




}



public class DynamicArrayDemo 	{

    public static void main(String[] args) {
        int val,pos;
        DynamicArray list = new DynamicArray();                   //new list is created from DynamicArray class
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n -------- List Menu -----------\n");
            System.out.println("1.Insert at End\n");
            System.out.println("2.Display the list\n");
            System.out.println("3.Insert at specified position \n");
            System.out.println("4.Delete from specified position\n");
            System.out.println("5.Exit\n");
            System.out.println("\n--------------------------------------\n");
            System.out.println("Enter your choice:\t");
            int choice = scanner.nextInt();
            switch(choice) {                                             //Switch case is initialised
                case 1: System.out.print("Enter the data: ");           //------INSERT IN END-------
                    val = scanner.nextInt();
                    list.add(val);                                     //add method is called to insert an element in the end
                    break;
                case 2: list.display();

                    break;
                case 3: System.out.println("Enter the pos(starts at 0): ");    //------INSERT AT POSN-------
                    pos = scanner.nextInt();
                    if(pos<0){                                       // Cant enter when position is below zero
                        System.out.println("Invalid position");
                        break;
                    }
                    System.out.print("Enter the data: ");            //if position is above zero get data to be kept in that position
                    val = scanner.nextInt();
                    list.insertAtPos(pos,val);                        //insert val at position using the insertAtPos method we created
                    break;
                case 4: System.out.println("Enter the pos(starts at 0): ");  //-----TO DELETE ------
                    pos = scanner.nextInt();
                    if(pos<0){                                    //Cant delete when posn is under 0
                        System.out.println("Invalid position");
                        break;
                    }
                    list.deleteAtPos(pos);                     //Dete at posn using deleteAtPos method
                    break;
                case 5: System.exit(0);

                default: System.out.println("Invalid Choice ");


            }

        }


    }

}

/* Exercise
 *
 * delete at end
 * delete from beginning
 * insert at beginning
 * get(index)  get(2)
 * update(index,val)  update(3,5)  arr[index] = val;
 * search(val) -> return index
 * clear
 * contains(val)
 */