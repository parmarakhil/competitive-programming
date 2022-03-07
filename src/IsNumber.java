public class IsNumber {

    public boolean isNumber(String s)
    {
        int len = s.length();
        boolean hasDot = false;     // if current string has '.'
        boolean hasE = false;       // if current string has e/E
        boolean hasDigit = false;   // if current string has digit.
        char c;                     // iterate s one character at a time.

        for (int i = 0; i < len; i++)
        {
            c = s.charAt(i);

            if (Character.isDigit(c))   // current character is digit.
                hasDigit = true;
            else if (c == '+' || c == '-')
            {
                // A sign character must be at the start or followed by e/E;
                if (i != 0 && s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e')
                    return false;
            }
            else if (c == '.')
            {
                // there must be only one '.' and no dot is allowed after the 'e'/'E'.
                if (hasDot || hasE)
                    return false;
                hasDot = true;
            }
            else if (c == 'e' || c == 'E')
            {
                // there must already has digit before an e/E, and only one e/E is allowed.
                if (!hasDigit || hasE)
                    return false;
                hasE = true;
                hasDigit = false;   // *important, because there must be at least one digit after 'e'/'E';
            }
            else
                return false;   // no other characters allowed.
        }

        return hasDigit;    // default: should has at least one digit.
    }
}
