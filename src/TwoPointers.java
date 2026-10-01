import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers twoPointers = new TwoPointers();
        int[] nums = {0, 0, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 10};
        twoPointers.removeDuplicatesFromSortedArray(nums);
    }

    /// [0, 0, 1, 2, 3, 3, 4, 5, ,6, 6, 7, 8, 9, 10]
    /// output-> [0, 1, 2, 3, 4,5 ,6 ,7 , 8, 9, 10]
    private void removeDuplicatesFromSortedArray(int[] numbers) {
        int j = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[j-1]) {
                numbers[j] = numbers[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(numbers));
        Arrays.stream(numbers).boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .keySet()
//                .sorted(Integer::compareTo)
                .forEach(System.out::println);
    }
}
