public class UglyNumber {
    public boolean isUgly(int num)
    {
        if (num == 0) return false;
        for (int i = 2; i <= 5; i += i-1)   // a small trick to iterate 2,3,5 (and skip 4)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
