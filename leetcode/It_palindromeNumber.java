class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}

/*
解題思路：
比較數字的首位與末位。
利用除數 div 取出最高位，mod 取出最低位。
每次比較後去掉頭尾兩位，直到數字縮完。
*/
