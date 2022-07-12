public class FindFirst {

    /** find the position of first 1 in sorted array of 0 and 1
     ex - 0 0 0 0 1 1
     answer - 5
     */

    public static void main(String[] args) {
        int[] array = {0,0,0,1};
        System.out.println(findFirst(array, 0, array.length, -1));
    }
    public static int findFirst(int[] array, int startIndex, int endIndex, int position){
        int mid = (startIndex+endIndex)/2;
        if(startIndex == mid ||  endIndex == mid) {
            if(array[mid]==1) return mid+1;
            else return  position+1;
        }
        if(array[mid]==1){
            position = mid;
            return findFirst(array, startIndex,mid, position);

        }else{
            return findFirst(array, mid, endIndex, position);
        }
    }
}
