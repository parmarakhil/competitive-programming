import java.util.Arrays;

public class CountAnargams {

    public static int countAnagrams(String s, String p)
    {
        // change CHARACTERS to support range of supported
        // characters
        int CHARACTERS = 256;
        int sn = s.length();
        int pn = p.length();
        int count = 0;
        if (sn < 0 || pn < 0 || sn < pn)
            return 0;

        char[] pArr = new char[CHARACTERS];
        char[] sArr = new char[CHARACTERS];
        int i = 0;
        // till window size
        for (; i < pn; i++) {
            sArr[CHARACTERS - s.charAt(i)]++;
            pArr[CHARACTERS - p.charAt(i)]++;
        }
        if (Arrays.equals(pArr, sArr))
            count += 1;
        // next window
        for (; i < sn; i++) {
            sArr[CHARACTERS - s.charAt(i)]++;
            sArr[CHARACTERS - s.charAt(i - pn)]--;

            if (Arrays.equals(pArr, sArr))
                count += 1;
        }
        return count;
    }
}
