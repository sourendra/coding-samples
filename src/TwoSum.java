import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target .
 * twice.
 * You can return the answer in any order.
 * You may assume that each input would have exactly one solution, and you may not use the same element
 */
public class TwoSum {
    
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] indices = twoSum.findTwoSum(nums, 7);
        System.out.println("The indices are " + Arrays.toString(indices));
        int[] arr = {2, 3, 4, 5, 6, 1, 9, 11, 10};
        twoSum.selectionSort(arr);
    }
    
    private int[] findTwoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
