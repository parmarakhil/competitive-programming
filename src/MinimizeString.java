public class MinimizeString {

    static int minimizeString(String s){
        int left=0, right = s.length()-1;
        for(; left< right && s.charAt(left)== s.charAt(right);){
            char d = s.charAt(left);
            while(left<=right && s.charAt(left)==d) left++;
            while (left<=right && s.charAt(right)==d) right--;

        }
        // return minimum possible length of string
        return right-left+1;
    }
}
