public class FindneedleInString {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        final int n = haystack.length() - needle.length();
        if (n < 0) {
            return -1;
        }

        int haystackSum = hash(haystack, needle.length() - 1);
        int needleSum = hash(needle, needle.length());

        for (int i=0; i<=n; i++) {
            haystackSum += haystack.charAt(i + needle.length() - 1);
            int k = i;
            while (haystackSum == needleSum && k-i < needle.length()
                    && haystack.charAt(k) == needle.charAt(k-i)) {
                k++;
            }
            if (k - needle.length() == i) {
                return i;
            }
            haystackSum -= haystack.charAt(i);
        }
        return -1;
    }

    private int hash(final String str, final int count) {
        int sum = 0;
        for (int i=0; i<count; i++) {
            sum += str.charAt(i);
        }
        return sum;
    }
}
