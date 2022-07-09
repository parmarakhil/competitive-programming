import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> all = new ArrayList<>();

    public boolean valid(StringBuilder sb){
        // this method checks if number is in range [0, 255] and without leading zeroes
        int n = sb.length() - 1;

        int num = 0;
        int p = 1;
        while(n >= 0 && sb.charAt(n) != '.'){
            num += (sb.charAt(n) - '0') * p;
            p *= 10;
            n--;
        }

        return (num <= 255 && Math.log10(p) <= Math.log10(num) + 1) || (num == 0 && p == 10);
    }


    public void generate(int i, String s, StringBuilder sb, int n, int dots){
        // if dots more than 3 it means there are more than 4 numbers, we don't need it
        if(dots > 3) return;

        if(i >= n) {
            // if there are 3 dots and the last character is not a dot, it means we found valid IP
            if(dots == 3 && sb.charAt(sb.length() - 1) != '.') all.add(sb.toString());
            return;
        }


        // append current character
        sb.append(s.charAt(i));
        // validate last number
        if(!valid(sb)){
            // if not valid, delete last character and return
            sb.setLength(sb.length() - 1);
            return;
        }

        // generate without a dot
        generate(i + 1, s, sb, n, dots);

        sb.append('.');
        // generate with a dot
        generate(i + 1, s, sb, n, dots + 1);
        // delete this dot
        sb.setLength(sb.length() - 1);

        // delete current character (s.charAt(i))
        sb.setLength(sb.length() - 1);
    }

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        generate(0, s, sb, s.length(), 0);

        return all;
    }
}
