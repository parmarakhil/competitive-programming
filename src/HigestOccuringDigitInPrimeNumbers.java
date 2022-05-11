import java.util.ArrayList;
import java.util.List;

public class HigestOccuringDigitInPrimeNumbers {
    public int maxDigit(int L, int R)
    {
        List<Integer> list=new ArrayList<>();
        int arr[]=new int[10];
        for(int i=L;i<=R;i++){
            if(i==1) continue;
            if(primeNumber(i)) list.add(i);
        }
        if(list.size()==0) return -1;
        if(L<=1) list.add(1);

        for(int i:list){
            int p=i;
            while(p>0){
                arr[p % 10]++;
                p /= 10;
            }
        }
        int max = arr[0], ans = 0;


        for (int j = 1; j < 10; j++) {
            if (max <= arr[j]) {
                max = arr[j];
                ans = j;
            }
        }

        return (max != 0) ? ans : -1;
    }

    public boolean primeNumber(int n){
        int count=0;

        for(int i=1;i<=n;i++){
            if(n%i==0) count++;
        }
        if(count==2) return true;
        return false;

    }

    public void count(Character ch,int[] num){
        int digit=Character.getNumericValue(ch);
        num[digit]=num[digit]+1;
    }
}
