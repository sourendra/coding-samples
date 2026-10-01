/**
 * <---- Optum Interview Question --->
 * Given a string 's' and an integer 'k'. In one operation you can pick any character and change it to any character.
 * You can do this operation a maximum of 'k' times.
 * Examples:
 * String -> "ABAB", k = 2,  output -> 4
 * String -> "AABABBA", k = 1, output -> 4
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String text = "AABABBA";
        int maxLength = maxLengthRepeatingCharacterReplacement(text, 1);
        System.out.println("Maximum length is " + maxLength);
    }

    private static int maxLengthRepeatingCharacterReplacement(String text, int k) {
        int left = 0;
        int[] frequencies = new int[26];
        int maxWindowSize = 0;
        int maxFrequencies = 0;
        for (int i = 0; i < text.length(); i++) {
            //update the frequency of the current character
            frequencies[text.charAt(i) - 'A']++;

            //update the max frequencies
            maxFrequencies = Math.max(maxFrequencies, frequencies[text.charAt(i) - 'A']);
            int windowLength = i - left + 1;

            // If window length - max frequencies > k,
            // then we need to shrink the window
            if (windowLength - maxFrequencies > k) {
                frequencies[text.charAt(left) - 'A']--;
                left++;
            }
            windowLength = i - left + 1;
            maxWindowSize = Math.max(maxWindowSize, windowLength);
        }
        return maxWindowSize;
    }
}
