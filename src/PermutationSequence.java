import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationSequence {
    // For Calculating Factorial
    Map<Integer, Integer> map = new HashMap<>();

    public int factorial(int n){
        if(n==1){
            return 1;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        int fact = n*factorial(n-1);

        map.put(n, fact);
        return fact;
    }

    String ans = "";
    int fact = 0;



    // Main Method
    public String getPermutation(int n, int k) {
        if(n==1){
            return "1";
        }
        ans = "";
        fact = factorial(n-1);
        List<Integer> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        solve(n, k-1, list);
        return ans;
    }

    // Recursive Method to solve for lower inputs
    public void solve(int n , int k, List<Integer> list){
        if(n==0){
            return;
        }

        int adder = k/fact;
        int newK = k%fact;
        ans += Integer.toString(list.get(adder));
        list.remove(adder);

        if(list.size()==0){
            return;
        }

        fact=fact/list.size();

        solve(n-1, newK, list);
    }
}
