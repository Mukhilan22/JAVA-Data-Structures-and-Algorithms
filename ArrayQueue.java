public class ArrayQueue<T> {             //QUEUE USING ARRAY
    int MAX_SIZE=20;                 //IT HAS AN ARRAY, FRONT AND REAR
    T arr[] = (T[])new Object[MAX_SIZE];

    int front,rear;

    ArrayQueue(){
        front=-1;
        rear=-1;
    }

    public void Enqueue(T val){              //------------ENQUEUE---------------
        if(rear == MAX_SIZE -1)
            throw new IndexOutOfBoundsException("Queue is Full");
        if(front==-1){          //when no element there both front and rear are that element
            arr[++front]=val;
            rear++;
            }
        else {                  //when element is added, that element is rear
            arr[++rear] = val;
        }
    }

    public T Dequeue(){                   //----------------DEQUEUE----------------
        if(front==-1){
            throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
        }
        T a=arr[front];        //Store first value to return
        front++;               //front posn shifts front , so initial front will not be referred to
        return arr[front];
    }

    public void display(){             //-----------------DISPLAY----------------
        for(int k=front;k<=rear;k++){
            System.out.print(arr[k]+ " ");
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> a=new ArrayQueue<Integer>();
        a.Enqueue(1);
        a.Enqueue(8);
        a.Enqueue(7);
        a.Enqueue(5);
        a.Enqueue(3);
        a.Dequeue();
        a.display();

    }
}