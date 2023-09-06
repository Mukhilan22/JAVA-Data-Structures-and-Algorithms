public class Sort {

    //-----------SELECTION SORT-----------//
    public static void SelectionSort(int arr[]) {
        for(int i=0;i<arr.length-1;i++){ //if no of elements is 10; loop run 9 times as in 9th loop,ele 10>9.
            int min=arr[i];    //initialise arr[i] as min and store minindex for swaping
            int minindex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];   //min changes until end of loop so we can find the least number of arr
                    minindex=j;
                }
            }
            int temp=arr[i];  //After min s fund, it is swapped with arr[i]
            arr[i]=min;
            arr[minindex]=temp;
        }
    }
    //-------------BUBBLE SORT---------------//
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped=false;   //for better time complexity and best case
            for (int j = 0; j < arr.length - 1 - i; j++) {  //loop length of j decreases in each i loop
                if (arr[j] > arr[j + 1]) { //comparing nearby elements
                    swapped=true;
                    int temp = arr[j];  //swapping
                    arr[j] = arr[j + 1];
                    arr[j + 1] = arr[j];
                }
            }
            if(swapped==false){    //FOR BETTER TIME COMPLEXITY AND BEST CASE
                break;
            }
        }
    }
    //------------INSERTION SORT---------------
    public static void InsertionSort(int arr[]){

        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--) {    //keep j as i, and compare j and j-1 in j loop.
                if(arr[j]<arr[j-1]){  //compare ja and compare element left it
                int temp=arr[j]; //swap
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                }
                else{
                    break; //if left number is lesser than right,the all of the left nos are less
                }
                }
            }

    }
    public static void main(String[] args) {
        int arr[]={1,3,6,2,8,9,4};
        Sort.InsertionSort(arr);
        for(int x:arr){
            System.out.println(x);
        }
    }
}
