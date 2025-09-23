public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,3,6};
        for (int element : arr) {
            System.out.println(element);
        }
        System.out.println("*****************");
        bubbleSort(arr);
        for (int element : arr) {
            System.out.println(element);
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i =n-1; i>=0; i--) {
            boolean noSwap = true;
            for (int j = 0; j<=i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    noSwap = false;
                }
            }
            if (noSwap) {break;}
        }
    }
}
