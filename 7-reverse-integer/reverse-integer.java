class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int rev = 0;

        while (x != 0) {
            int d = x % 10;
            x /= 10;

            if (rev > (Integer.MAX_VALUE - d) / 10) {
                return 0;
            }

            rev = rev * 10 + d;
        }

        return sign * rev;
    }
}