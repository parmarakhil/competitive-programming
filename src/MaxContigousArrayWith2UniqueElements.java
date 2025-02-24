public class MaxContigousArrayWith2UniqueElements {

    public static void main(String[] args) {
        System.out.println(maxContigousArrayWith2UniqueElements(new int[]{1,2,3,4,5,6,7,7}));
    }
    public static int maxContigousArrayWith2UniqueElements(int[] arr) {
        if (arr == null || arr.length<1) return 0;
        int firstNumber = arr[0], secondNumber = arr[0];
        int startIndex = 0, sameElementLength = 1, maxLength = 0;
        for (int i=1; i<arr.length;i++) {
            if (arr[i]!=arr[i-1]) {
               if (firstNumber == secondNumber) {
                   secondNumber = arr[i];
               } else {
                   if (firstNumber!=arr[i] && secondNumber!=arr[i]) {
                       maxLength = Math.max(maxLength, i-startIndex);
                       startIndex = i-sameElementLength;
                       firstNumber=arr[i-1];
                       secondNumber=arr[i];
                   }
               }
               sameElementLength =1;
            } else {
                sameElementLength++;
            }
        }
        return firstNumber==secondNumber ? maxLength : Math.max(maxLength, arr.length-startIndex);
    }
}
