class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}

/*
解題思路：
逐位數取出 x 的末尾數字，累積到 res。
使用 long 檢查是否溢出，若超出 32-bit int 範圍就回傳 0。
*/
