import java.util.Arrays;
public class MergeSorting {    //----------------MERGE SORT--------------
    public static int[] MergeSort(int arr[]){      //------SPLITTING n MERGING-----
        if (arr.length==0){    //recursion stops and we return it to left/right
            return arr;
        }

        int mid=arr.length/2;  //mid to split

        //SPLIT USING RECURSION
        int[] left=MergeSort(Arrays.copyOfRange(arr,0,mid));  //left split
        //goes to right only after left recursion is over
        int[] right=MergeSort(Arrays.copyOfRange(arr,mid,arr.length));  //right split

        return Merge(left,right);  //merge sort is called when we have left and right arr
    }


    //----------SORTING AND MERGING 2 SORTED ARRAYS-------------
    public static int[] Merge(int[] left,int[] right){
        //gets returned to left if above it call was left else right
        int i=0;
        int j=0;
        int k=0;

        int[] mArr=new int[left.length+right.length];  //Merged Array
        while(i<left.length && j<right.length){   //to see if there are elements in both arrays
            if(left[i]>right[j]){
                mArr[k++]=right[j++];
            }
            if(left[i]<right[j]){
                mArr[k++]=left[i++];
            }
        }
        //when there are elements left in 1 array alone
        while(i<left.length){
            mArr[k++]=left[i++];
        }
        while(j<right.length){
            mArr[k++]=right[j++];
        }
        return mArr;
    }
}
