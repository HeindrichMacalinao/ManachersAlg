public class ManacherVisualizer {

    public static void visualize(String input) {

        // Step 1: Transform string
        char[] T = new char[input.length() * 2 + 1];
        int idx = 0;

        for (int i = 0; i < T.length; i++) {
            if (i % 2 == 0) {
                T[i] = '#';
            } else {
                T[i] = input.charAt(idx++);
            }
        }

        int n = T.length;
        int[] P = new int[n];

        int center = 0, right = 0;

        System.out.println("Transformed String:");
        printArray(T);

        System.out.println("\nStep-by-step execution:\n");

        for (int i = 0; i < n; i++) {

            int mirror = 2 * center - i;

            System.out.println("--------------------------------------------------");
            System.out.println("Index i = " + i + " (" + T[i] + ")");
            System.out.println("Mirror = " + mirror);

            if (i < right) {
                P[i] = Math.min(P[mirror], right - i);
                System.out.println("Inside right boundary → P[i] starts at " + P[i]);
            } else {
                P[i] = 0;
                System.out.println("Outside boundary → P[i] starts at 0");
            }

            // Expansion
            while (i - 1 - P[i] >= 0 &&
                    i + 1 + P[i] < n &&
                    T[i - 1 - P[i]] == T[i + 1 + P[i]]) {

                System.out.println("Expanding: " +
                        T[i - 1 - P[i]] + " == " + T[i + 1 + P[i]]);

                P[i]++;
            }

            System.out.println("Final P[" + i + "] = " + P[i]);

            // Update center and right
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];

                System.out.println("New Center = " + center);
                System.out.println("New Right = " + right);
            }

            printPArray(P);
        }

        // Find longest palindrome
        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 0; i < n; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;

        System.out.println("\n=================================");
        System.out.println("Longest Palindrome: " +
                input.substring(start, start + maxLen));
        System.out.println("Length: " + maxLen);
    }

    private static void printArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void printPArray(int[] P) {
        System.out.print("P array: ");
        for (int val : P) {
            System.out.print(val + " ");
        }
        System.out.println("\n");
    }
}