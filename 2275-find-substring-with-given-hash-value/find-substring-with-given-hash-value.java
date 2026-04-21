class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long p = power;
        long mod = modulo;

        long p_k = 1; // power^k % mod
        for (int i = 0; i < k; i++) {
            p_k = (p_k * p) % mod;
        }

        long cur = 0;
        int bestStart = 0;

        // We build hash from right to left
        for (int i = n - 1; i >= 0; i--) {
            int valAdd = s.charAt(i) - 'a' + 1;

            // add new char at left at power^0 (others get *p)
            cur = (cur * p + valAdd) % mod;

            // if window is longer than k, remove the char that falls out
            int j = i + k;
            if (j < n) {
                int valRemove = s.charAt(j) - 'a' + 1;
                cur = (cur - (valRemove * p_k) % mod + mod) % mod;
            }

            // when window length is exactly k, check hash
            if (i + k - 1 < n && cur == hashValue) {
                bestStart = i; // since we go from right to left, last match is smallest i
            }
        }

        return s.substring(bestStart, bestStart + k);
    }
}