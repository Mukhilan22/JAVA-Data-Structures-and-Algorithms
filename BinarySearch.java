public class BinarySearch {       //SEARCH OR ELEMENT IN SORTED ARRAY

    public static int BinarySearch(int arr[],int target) {
        int front = 0;
        int end = arr.length - 1;

        while (front < end) {    //if Element is not present, at one point, end will go behind front.
            int mid = (front + end) / 2;
            if (arr[front] < arr[end]) {   //-------------ASCENDING CHECK---------------
                if (arr[mid] > target) {    //FOCUS on LEFT
                    end = mid - 1;
                }
                if (arr[mid] < target) {    //FOCUS ON RIGHT
                    front = mid + 1;
                } else
                    return mid;
            }
            else{                                 //----------------DESCENDING ORDER-----------------
                if (arr[mid] < target) {    //FOCUS on LEFT
                    end = mid - 1;
                }
                if (arr[mid] > target) {    //FOCUS ON RIGHT
                    front = mid + 1;
                } else
                    return mid;
            }
        }
        return -1;
    }
}
//OPPOSITE SYMBOLS FOR DESCENDING ORDER

