class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // odd length palindromes, center at i
            count += expandFromCenter(s, i, i);
            // even length palindromes, center between i and i+1
            count += expandFromCenter(s, i, i + 1);
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int n = s.length();
        int localCount = 0;

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            localCount++;
            left--;
            right++;
        }

        return localCount;
    }
}