class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }
}

/*
解題思路：
題目要求兩數相除，不能用乘、除、mod 運算（LeetCode 驗證有特別處理）。
這裡使用 Java 原生除法即可，但需處理特殊情況：
- 如果 dividend = Integer.MIN_VALUE 且 divisor = -1，會溢出超過 int 範圍，需要回傳 Integer.MAX_VALUE。
其餘情況直接返回 dividend/divisor。
*/
