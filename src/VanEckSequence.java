public class VanEckSequence {
    static int MAX = 1000;

    // Array to store terms of sequence
    static int sequence[] = new int[MAX];

    // Utility function to compute
    // Van Eck's sequence
    static void vanEckSequence()
    {

        // Initialize sequence array
        for (int i = 0; i < MAX - 1; i++) {
            sequence[i] = 0;
        }

        // Loop to generate sequence
        for (int i = 0; i < MAX - 1; i++) {

            // Check if sequence[i] has occurred
            // previously or is new to sequence
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] == sequence[i]) {

                    // If occurrence found
                    // then the next term will be
                    // how far back this last term
                    // occurred previously
                    sequence[i + 1] = i - j;
                    break;
                }
            }
        }
    }

    // Utility function to return
    // Nth term of sequence
    static int getNthTerm(int n)
    {

        return sequence[n];
    }

    // Driver code
    public static void main(String[] args)
    {

        // Pre-compute Van Eck's sequence
        vanEckSequence();

        int n = 6;

        // Print nth term of the sequence
        System.out.println(getNthTerm(n));

        n = 100;

        // Print nth term of the sequence
        System.out.println(getNthTerm(n));
    }
}
