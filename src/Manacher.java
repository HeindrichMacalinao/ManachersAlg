public class Manacher {

    // Returns number of comparisons (for analysis)
    public static int longestPalindrome(String input) {

        // Step 1: Transform string manually → #a#b#c#
        char[] transformed = new char[input.length() * 2 + 1];
        int index = 0;

        for (int i = 0; i < transformed.length; i++) {
            if (i % 2 == 0) {
                transformed[i] = '#';
            } else {
                transformed[i] = input.charAt(index);
                index++;
            }
        }

        int n = transformed.length;
        int[] P = new int[n];

        int center = 0;
        int right = 0;

        int comparisons = 0;

        // Step 2: Core Manacher loop
        for (int i = 0; i < n; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                if (P[mirror] < (right - i)) {
                    P[i] = P[mirror];
                } else {
                    P[i] = right - i;
                }
            } else {
                P[i] = 0;
            }

            // Step 3: Expand around center i
            while (i - 1 - P[i] >= 0 &&
                    i + 1 + P[i] < n &&
                    transformed[i - 1 - P[i]] == transformed[i + 1 + P[i]]) {

                P[i]++;
                comparisons++;
            }

            // Step 4: Update center and right
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        return comparisons;
    }
}