public class Driver {

    public static void main(String[] args) {
        ManacherVisualizer.visualize("abcacbbc");
        int[] sizes = {10, 100, 1000, 10000};

        for (int n : sizes) {

            String testData = generateText(n);

            // =========================
            // 🔴 BRUTE FORCE TIMING
            // =========================

            // 1. Start time
            long startTimeBF = System.nanoTime();

            // 2. Execute algorithm
            long bfComparisons = BruteForcePalindrome.longestPalindrome(testData);

            // 3. End time
            long endTimeBF = System.nanoTime();

            // 4. Duration
            long durationBF = endTimeBF - startTimeBF;

            // =========================
            // 🟢 MANACHER TIMING
            // =========================

            long startTimeM = System.nanoTime();

            int mComparisons = Manacher.longestPalindrome(testData);

            long endTimeM = System.nanoTime();

            long durationM = endTimeM - startTimeM;

            // =========================
            // 5. OUTPUT (Chart of Truth)
            // =========================

            System.out.println("n = " + n +
                    " | BF Time = " + durationBF + " ns" +
                    " | BF Comp = " + bfComparisons +
                    " | M Time = " + durationM + " ns" +
                    " | M Comp = " + mComparisons);
        }
    }

    // Manual generator (NO shortcuts)
    public static String generateText(int n) {

        String text = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                text += "a";
            } else {
                text += "b";
            }
        }

        return text;
    }
}