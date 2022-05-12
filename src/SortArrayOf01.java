import java.util.Arrays;

public class SortArrayOf01 {
    /**
     * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
     * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
     * */
    public static void main(String[] args) {
        int[] input = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int n= input.length;
        int indexPosition=0;
        for(int i=0;i<n;i++){
            if(input[i]==0){
                input[indexPosition]=0;
                indexPosition++;
            }
        }

        //{0,0,0,0,0,iii 0,1,1,1,0}
        for(int k= indexPosition;k<n;k++){
            input[k]=1;
        }

        Arrays.stream(input).forEach(i -> System.out.println(i));
    }
}
