import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 1876: Substrings of Size three with distinct characters.
 * Pattern: Fixed-size Sliding Window
 * Window size: 3
 *
 * Problem: Given a string s, return the number of substrings of length 3 that contain 3 distinct characters.
 * Example: s= "xyzzaz"
 * Output: 1
 * The length 3 substrings are:
 * "xyz" -> x, y, z --> ✅distinct
 * "yzz" -> y, z, z --> ❌
 * "zza" -> z, z, a --> ❌
 * "zaz" -> z, a, z --> ❌
 */
public class SubStringSizeKWithDistinctChars {
    public static void main(String[] args) {
        SubStringSizeKWithDistinctChars subStringSizeKWithDistinctChars = new SubStringSizeKWithDistinctChars();
        String chars = "xyzzazb";
        int count = subStringSizeKWithDistinctChars.substringsWithDistinctChars(chars);
        System.out.println("There are total " + count + " substrings in the string " + chars);
    }

    private int substringsWithDistinctChars(String chars) {
       int count = 0;
        for (int i = 0; i <= chars.length() - 3; i++) {
            char a = chars.charAt(i);
            char b = chars.charAt(i+1);
            char c = chars.charAt(i+2);
            if (a != b && b != c && a != c)
                count++;
        }
        return count;
    }
}
