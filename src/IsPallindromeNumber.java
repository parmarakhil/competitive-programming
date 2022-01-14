public class IsPallindromeNumber {
    public boolean isPalindrome(int x) {
        int y = 0;
        if (x == 0) return true;
        if (x < 0 || x%10 == 0) return false;
        while (x != 0)
        {
            y = y*10 + x%10;
            if (x == y) return true;
            else{
                x = x/10;
                if (x == y) return true;
            }
        }
        return false;
    }
}
