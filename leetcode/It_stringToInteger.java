class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1, result = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++; // 去掉空格

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}

/*
解題思路：
模擬 C 語言 atoi()。
先處理前導空格、符號，然後逐位讀取數字。
在運算過程檢查是否溢出。
*/
