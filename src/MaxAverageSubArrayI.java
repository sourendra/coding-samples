/**
 * Leetcode 643
 * Pattern: Fixed-size sliding window
 * Problem: Given an array nums and an integer k, find a contiguous subarray of length k that has the maximum average.
 * Example: nums= [1, 12, -5, -6, 50, 3] & k = 4  then output = 12.75
 * because
 * [1, 12, -5, -6] -> sum = 2
 * [12, -5, -6, 50] -> sum = 51
 * [-5, -6, 50, 3] -> sum = 42
 * maximum sum is 51. Therefore: 51/4 = 12.75
 */
public class MaxAverageSubArrayI {
    public static void main(String[] args) {
        MaxAverageSubArrayI maxAverageSubArrayI = new MaxAverageSubArrayI();
        int[] numbers = {1, 12, -5, -6, 50, 3};
        double maxSumAverage = maxAverageSubArrayI.maxAverageSubArrayI(numbers, 4);
        System.out.println("Maximum Subarray sum for the given array is " + maxSumAverage);
    }

    private double maxAverageSubArrayI(int[] numbers, int k) {
        double currentSum = 0.0;
        for (int i = 0; i < k; i++) {
            currentSum += numbers[i];
        }
        System.out.println("total sum " + currentSum);
        double maxSumAverage = (double) currentSum /k;
        System.out.println("maxSumAverage " + maxSumAverage);
        for (int i = k; i < numbers.length; i++) {
            currentSum -= numbers[i-k];
            currentSum += numbers[i];
            System.out.println("currentSum " + currentSum);
            maxSumAverage = Math.max(currentSum/k, maxSumAverage);
            System.out.println("maxSumAverage " + maxSumAverage);
        }
        return maxSumAverage;
    }
}
