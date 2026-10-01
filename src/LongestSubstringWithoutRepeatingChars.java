import java.util.HashSet;
import java.util.Set;

/**
 * String -> "pwwkewxpw", output -> 5
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        int count = maxSubstringLengthWithoutRepeatingChars("pwwkewxpw");
        System.out.println("Maximum length of the substring without repeating character is " + count);
    }

    private static int maxSubstringLengthWithoutRepeatingChars(String text) {
        int left = 0;
        int maxLength = 0;
        int start = 0;
        int currentLength = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < text.length(); right++) {
            while (set.contains(text.charAt(right))) {
                set.remove(text.charAt(left));
                left++;
            }
            set.add(text.charAt(right));
            currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = left;
            }
        }
        System.out.println("maxLength: " +maxLength);
        System.out.println("maxLength SubString: " + text.substring(start, start + maxLength));
        return maxLength;
    }
}
