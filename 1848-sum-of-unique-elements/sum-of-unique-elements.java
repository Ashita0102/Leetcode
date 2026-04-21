class Solution {
    public int sumOfUnique(int[] nums) {
        // nums[i] is between 1 and 100
        int[] freq = new int[101];

        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        int sum = 0;
        // Add numbers that appear exactly once
        for (int value = 1; value <= 100; value++) {
            if (freq[value] == 1) {
                sum += value;
            }
        }

        return sum;
    }
}