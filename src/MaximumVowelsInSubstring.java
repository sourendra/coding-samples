/**
 * LeetCode 1456: Maximum Number of Vowels in a Substring of Given Length
 *
 * Problem: Given a string a and an integer k, find the maximum number of vowels in any substring of length k.
 *
 * Vowels are a, e, i, o, u
 * Example: s = "abciiidef" , k = 3
 *
 * Substring of length 3:
 * "abc" -> 1
 * "bci" -> 1
 * "cii" -> 2
 * "iii" -> 3 <-- maximum
 * "iid" -> 2
 * "ide" -> 2
 * "def" -> 1
 */

public class MaximumVowelsInSubstring {

    public static void main(String[] args) {
        MaximumVowelsInSubstring maximumVowelsInSubstring = new MaximumVowelsInSubstring();
        int count = maximumVowelsInSubstring.maxNumberOfVowelsInSubstring("abciiidef", 3);
        System.out.println("Maximum number of vowels in the substring are: " + count);
    }

    private int maxNumberOfVowelsInSubstring(String chars, int k) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(chars.charAt(i)))
                count ++;
        }
        maxCount = count;
        for (int i = k; i < chars.length(); i++) {
            if (isVowel(chars.charAt(i-k)))
                count--;
            if (isVowel(chars.charAt(i)))
                count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
