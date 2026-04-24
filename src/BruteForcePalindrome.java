public class BruteForcePalindrome {

    // Returns number of comparisons
    public static int longestPalindrome(String text) {

        int n = text.length();
        int comparisons = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                boolean isPalindrome = true;

                int left = i;
                int right = j;

                while (left < right) {
                    comparisons++;

                    if (text.charAt(left) != text.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }

                    left++;
                    right--;
                }

                if (isPalindrome) {
                    int length = j - i + 1;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }

        return comparisons;
    }
}