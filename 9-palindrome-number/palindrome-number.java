class Solution {
    public boolean isPalindrome(int x) {
        // negatives and numbers ending with 0 (but not 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rev = 0;
        // reverse only half of the number
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // for even length: x == rev
        // for odd length: x == rev / 10 (middle digit ignored)
        return x == rev || x == rev / 10;
    }
}