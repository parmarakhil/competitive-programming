public class Atoi {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        boolean neg = false;
        int i=0;
        while(i<s.length() && s.charAt(i) == ' ') i++;
        if(i==s.length()) return 0;
        if(s.charAt(i)=='+'){
            i++;
        }
        else if(s.charAt(i) == '-'){
            neg = true;
            i++;
        }
        char zero = '0';
        int mul = 1;
        int sum = 0;
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            int val = s.charAt(i)-zero;
            if(!neg && (sum>Integer.MAX_VALUE/10
                    || (sum==Integer.MAX_VALUE/10 && val>=7))){
                return Integer.MAX_VALUE;
            }
            else if(neg && (-sum<Integer.MIN_VALUE/10
                    ||(-sum==Integer.MIN_VALUE/10 && val>=8))){
                return Integer.MIN_VALUE;
            }
            sum = sum*10 + val;
            i++;
        }
        if(neg) return -sum;
        else return sum;
    }
}
