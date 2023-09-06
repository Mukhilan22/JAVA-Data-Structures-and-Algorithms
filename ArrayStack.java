public class ArrayStack <T>{             //ARRAY STACK IMPLEMENTATION
    static final int MAX_SIZE = 30;     //Given Seperately so we can check index out of bound
    T arr[] = (T[])new Object[MAX_SIZE];   //Array
    int top;                               //Top to store pos of last element

    ArrayStack() {           //Constructor fot top
        top = -1;
    }

    void push(T val){         //------------PUSH-----------
        if(top==MAX_SIZE-1)
            throw new IndexOutOfBoundsException("Stack overflow");
        arr[++top] = val;   //top(posn) increases with every push and stores val
    }

    T pop(){                 //-----------POP-----------
        if(top==-1) {
            throw new IndexOutOfBoundsException("Stack underflow");
        }
        return arr[top--];   //val in top returned and then top is decresed by 1
    }

    T peek() {              //-----------PEEK-----------
        return arr[top];    //Return value of top alone without deleting it
    }

    boolean isEmpty(){
        return top==-1;
    }
}