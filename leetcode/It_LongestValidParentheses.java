class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

/*
解題思路：
DP 解法：
- dp[i] 表示以 s[i] 為結尾的最長有效括號長度。
- 若 s[i] == ')' 且 s[i-1] == '('，dp[i] = dp[i-2] + 2。
- 若 s[i] == ')' 且 s[i-1] == ')'，需檢查與前面匹配的 '('。
時間複雜度：O(n)，空間 O(n)。
*/
