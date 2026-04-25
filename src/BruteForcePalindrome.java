public class BruteForcePalindrome {

    public static long longestPalindrome(String text) {

        int n = text.length();
        long comparisons = 0; //  FIXED DI NA NEGATIVE YEYY
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                boolean isPalindrome = true;

                int left = i;
                int right = j;

                while (left < right) {
                    comparisons++; // IKAW ANG DAHILAN

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