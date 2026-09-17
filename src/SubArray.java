import java.util.*;

public class SubArray {

    /***
     * All the programs follow Sliding window
     */

    public static void main(String[] args) {
        SubArray subArray = new SubArray();
        int[] numArray = {1, 4, 1, 10, 25, 3, 5, 10, 26};
        subArray.maxSum(numArray, 3);
        subArray.maxSumOptimal(numArray, 3);
        int[] targetArray = {2, 3, 2, 2, 3, 1, 3, 8, 5, 0, 2, 4};
        subArray.getTargetSum(targetArray, 3, 7);
        subArray.hasSubstringAnagram("greyhounds", "hoy");
        subArray.countSubstringAnagram("gattactat", "att");
        int[] subArraySum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        subArray.findSubArraySum(subArraySum, 15);
    }

    // Max Sum Subarray size k
    // num: [1, 4, 1, 10, 25, 3, 5, 10, 26] size 3 -> here time complexity is O(nk)
    public void maxSum(int[] numArray, int size) {
        int maxSum = Integer.MIN_VALUE;
        if (numArray.length > size) {
            for (int i = 0; i <= numArray.length - size; i++) {
                int currentSum = numArray[i] + numArray[i+1] + numArray[i+2];
                System.out.println("current sum " + currentSum);
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        System.out.println("maximum sum of the subarray size 3 is " + maxSum);
    }

    /// Max Sum Subarray size k
    /// num: [1, 4, 1, 10, 25, 3, 5, 0, 26] size 3 -> here time complexity is O(n)
    private void maxSumOptimal(int[] numArray, int size) {
        int currentSum = numArray[0] + numArray[1] + numArray[2];
        int maxSum = currentSum;
        for (int i = 0; i < numArray.length - size; i++) {
            currentSum = currentSum - numArray[i];
            currentSum += numArray[i+size];
            System.out.println("current sum " + currentSum);
            if (currentSum > maxSum)
                maxSum = currentSum;
        }
        System.out.println("Maximum sum of the subarray size 3 is " + maxSum);
    }

    /// Subarray target sum size k
    /// num: [2, 3, 2, 2, 3, 1, 3, 8, 5, 0, 2, 4] size 3 and target is 7. -> there are 5 subarrays in total.
    /// -> here time complexity is O(n)
    private void getTargetSum(int[] numArray, int size, int target) {
        int count = 0;
        int currentSum = numArray[0] + numArray[1] + numArray[2];
        if (currentSum == target) count++;
        for (int i = 0; i < numArray.length - size; i++) {
            currentSum -= numArray[i];
            currentSum += numArray[i+size];
            if (currentSum == target) count ++;
        }
        System.out.println("There are total " + count + " subarrays that targets " + target);
    }

    /// Has substring anagram
    /// "greyhounds", "hoy"
    private void hasSubstringAnagram(String word, String anagram){
        Set<Character> anagramSet = new HashSet<>(anagram.length());
        anagramSet.add(anagram.charAt(0));
        anagramSet.add(anagram.charAt(1));
        anagramSet.add(anagram.charAt(2));
        Set<Character> currentWindow = new HashSet<>(3);
        currentWindow.add(word.charAt(0));
        currentWindow.add(word.charAt(1));
        currentWindow.add(word.charAt(2));
        boolean hasAnagram = false;
        hasAnagram = currentWindow.equals(anagramSet);
        int k = anagram.length();
        for (int i = 0; i < word.length() - k; i++) {
            currentWindow.remove(word.charAt(i));
            currentWindow.add(word.charAt(i+k));
            if (currentWindow.equals(anagramSet))
                hasAnagram = currentWindow.equals(anagramSet);
        }
        if (hasAnagram)
            System.out.println("The word " + word + " has the anagram " + anagram);
        else System.out.println("The word " + word + " does not have the anagram " + anagram);
    }

    /// count substring anagram
    /// gattactat, att
    private void countSubstringAnagram(String word, String anagram) {
        Map<Character, Integer> anagramMap = new HashMap<>();
        anagramMap.put(anagram.charAt(0), 1);
        anagramMap.put(anagram.charAt(1), anagramMap.getOrDefault(anagram.charAt(1), 0) + 1);
        anagramMap.put(anagram.charAt(2), anagramMap.getOrDefault(anagram.charAt(2), 0) + 1);
        Map<Character, Integer> currentMap = new HashMap<>(3);
        currentMap.put(word.charAt(0), 1);
        currentMap.put(word.charAt(1), currentMap.getOrDefault(word.charAt(1), 0) + 1);
        currentMap.put(word.charAt(2), currentMap.getOrDefault(word.charAt(2), 0) + 1);
        System.out.println(anagramMap + " " + currentMap);
        int k = anagram.length();
        int count = anagramMap.equals(currentMap) ? 1 : 0;
        for (int i = 0; i < word.length() - k; i++) {
            System.out.println("value: " +currentMap.get(word.charAt(i)));
            if (currentMap.get(word.charAt(i)) != null){
                if (currentMap.get(word.charAt(i)) > 1)
                    currentMap.put(word.charAt(i), currentMap.getOrDefault(word.charAt(i), 0) -1);
                else currentMap.remove(word.charAt(i));
            }
            currentMap.put(word.charAt(i+k), currentMap.getOrDefault(word.charAt(i+k), 0) + 1);
            if (anagramMap.equals(currentMap)) count++;
        }
        System.out.println("There are total " + count + " anagrams in " + word);
    }

    /// Find subarray sum (Sliding window with variable size)
    private void findSubArraySum(int[] numArray, int targetSum) {
        int start = 0;
        int windowSum = 0;
        for (int i = 0; i < numArray.length; i++) {
            windowSum += numArray[i];
            while (windowSum > targetSum){
                windowSum -= numArray[start];
                start += 1;
            }
            if (windowSum == targetSum){
                System.out.println("Start and end index are " + start + " and " + i);
            }
        }
    }
}
