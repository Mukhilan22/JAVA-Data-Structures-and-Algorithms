public class LinearSearch {
    /* returns the index of target
     *  returns -1 if not found
     */
    public static int find(int[] arr,int target) {    //----------------INT SEARCH RETURN INDEX--------------
        for(int i=0;i<arr.length;i++)                 //STATIC METHOD AS OBJECT IS NOT CREATED
            if(arr[i]==target)
                return i;

        return -1;

    }

    /* returns true if target is found
     *  returns false if not found
     */
    public static boolean contains(int[] arr,int target) { //------------CONTAINS------------
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return true;

        return false;

    }
    /* Search for a char in a string
     * returns the index of target
     *  returns -1 if not found
     */

    public static int find(String str,char target) {   //-------------CHARECTER SEARCH-----------
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==target)         //get charecter at index i
                return i;
        return -1;
    }
    /* returns true if target is found
     *  returns false if not found
     */

    public static boolean contains(String str,char target) {   //-----------CHARACTER CONTAINS------------
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==target)
                return true;
        return false;
    }
    /* Search 2d array
     * returns the index of target in an int array [row,col]
     *  returns [-1,-1] if not found
     */

    public static int[] find(int[][] arr, int target) {       //-------------2d ARR SEARCH--------------
        for(int row=0;row<arr.length;row++) {
            for(int col=0;col<arr[row].length;col++) {
                if(arr[row][col]==target)
                    return new int[] {row,col};

            }
        }

        return new int[] {-1,-1};
    }

    public static int Max(int arr[]){     //-----------FIND MAX------------
        int val;
        for(int i=1;i<arr.length;i++){
            val=arr[0];
            if(arr[0]<arr[i]){           //arr[0]>arr[i] for Min
                arr[0]=arr[i];
                arr[i]=val;
            }
        }
        return arr[0];
    }

    public static int Count(String str,char target){  //------COUNT OF ALPHABET IN STRNG------
        int count=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==target){
                count++;
            }
        }
        return count;
    }

    public static int Four(int arr[]){     //-------------FIND 4 DIGIT NOS IN ARRAY-----------
        int count=0;
        int quotient;
        for(int i=0;i<arr.length;i++){
            quotient=arr[i]/1000;
            if(quotient>=1 && quotient<=9) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        System.out.println(LinearSearch.Max(arr));
    }
}


/*
 * Assignment
 *
 * Find max element
 * Find Min element
 * Count a character in a string  -  count(str,'r')
 * Count the 4 digit elements in an array   - {123,7845,124,78452,1429}
 *
 *
 */