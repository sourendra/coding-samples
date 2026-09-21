import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class Anagrams {

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        boolean isAnagram = anagrams.checkAnagram("listen", "silent");
        System.out.println("listen and silent are anagram: " + isAnagram);
        boolean isAnagramOptimal = anagrams.checkAnagramUsingArray("Listen", "Silent");
        System.out.println("listen and silent are anagram: " + isAnagramOptimal);
    }

    /// here the time complexity is O(n+k). k is for map for loop.
    private boolean checkAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if (!entry.getValue().equals(0)) return false;
        }
        return true;
    }

    /// here the time complexity is O(n).
    private boolean checkAnagramUsingArray(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        int[] frequencies = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            frequencies[word1.charAt(i) - 'a']++;
            frequencies[word2.charAt(i) - 'a'] --;
        }
        return Arrays.stream(frequencies).noneMatch(num-> num > 0);
    }
}
