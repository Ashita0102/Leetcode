class Solution {
    public int heightChecker(int[] heights) {
        // heights[i] is between 1 and 100
        int[] count = new int[101];

        // Count frequency of each height
        for (int h : heights) {
            count[h]++;
        }

        int ans = 0;
        int currentHeight = 1;

        // Walk through original array and compare with "expected" order
        for (int h : heights) {
            // Move currentHeight to the next available height
            while (currentHeight <= 100 && count[currentHeight] == 0) {
                currentHeight++;
            }

            // If current element is not what should be here in sorted order
            if (h != currentHeight) {
                ans++;
            }

            // Use one occurrence of currentHeight
            count[currentHeight]--;
        }

        return ans;
    }
}