class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128]; // ASCII
        for (int i = 0; i < 128; i++) last[i] = -1;

        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (last[ch] >= left) {
                left = last[ch] + 1;
            }
            last[ch] = right;
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}