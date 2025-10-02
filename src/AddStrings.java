import java.util.Arrays;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1,234,680" , "7,089"));
        System.out.println(nthFibonacci2(Integer.parseInt(addStrings("1,234,680" , "7,089"))));
    }
    public static String addStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int temp = 0;
        int i = s1.length()-1,  j=s2.length()-1;
        while (i>=0 || j>=0 || carry==1) {
            if (i>=0 && Character.isDigit(s1.charAt(i))) {
                temp+=s1.charAt(i)-'0';
            }
            if (j>=0 && Character.isDigit(s2.charAt(j))) {
                temp += s2.charAt(j)-'0';
            }
            i--;
            j--;
            int value = (temp+carry)%10;
            if (temp+carry>0) {
                sb.append(value);
            }
            carry = (temp+carry)/10;
            temp =0;
        }
        return sb.reverse().toString();
    }

    public static long nthFibonacci(int n) {
        long[] arr = new long[n+1];
        Arrays.fill(arr, -1);
        return util(n, arr);
    }

    private static long util(int n, long[] arr) {
        if (n<=1) {
            return n;
        }
        if (arr[n]!=-1) {
            return arr[n];
        }
        arr[n] = util(n-1, arr)+ util(n-2, arr);
        return arr[n];
    }

    public static long nthFibonacci1(int n) {
        if (n<=1) return n;
        int[] dp = new int[n+1];
        //base case
        dp[0]=0;
        dp[1]=1;
        for (int i=2; i<=n; ++i) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static long nthFibonacci2(int n) {
        if (n<=1) return n;
        //base case
        int prev1=0;
        int prev2=1;
        int current = 0;
        for (int i=2; i<=n; ++i) {
            current = prev1+prev2;
            prev2=prev1;
            prev1=current;
        }
        return current;
    }
}
