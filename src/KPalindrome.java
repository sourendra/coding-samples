/**
 * Valid Palindrome with at Most K Deletions
 * examples
 * String - abxcycba, k = 1 , output = yes
 * String - axcdyca, K = 2,  output = yes
 * String - axcdyyca, K = 2, output = no
 */
public class KPalindrome {

    public static void main(String[] args) {
        String text = "axcdyyca";
        int k = 2;
        System.out.println(canBePalindrome(text, k) ? "Yes" : "No");

        boolean validPalindrome = validPalindrome("axcdyca");
        System.out.println("It is a valid palindrome. " + validPalindrome);
    }

    private static boolean canBePalindrome(String text, int k) {
        int n = text.length();
        int[][] dp = new int[n][n];

        // dp[i][j] = minimum deletions needed to make text[i..j] a palindrome
        for (int length = 2; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;
                if (text.charAt(left) == text.charAt(right)){
                    dp[left][right] = dp[left+1][right-1];
                } else {
                    dp[left][right] = Math.min(dp[left+1][right], dp[left][right-1]);
                }
            }
        }
        return dp[0][n-1] <= k;
    }

    private static boolean validPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) == text.charAt(right)) {
                left ++;
                right --;
            } else return (isPalindrome(text, left +1, right)) || ((isPalindrome(text, left, right -1)));
        }
        return true;
    }

    private static boolean isPalindrome(String text, int left, int right) {
        while (left < right) {
            if (text.charAt(left) == text.charAt(right)){
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
