class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original = x, rev = 0;
        while (x != 0) {
            int digit = x % 10;
            if (rev > (Integer.MAX_VALUE - digit) / 10) return false;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev == original;
    }
}
