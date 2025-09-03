import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) backtrack(result, current + "(", open + 1, close, max);
        if (close < open) backtrack(result, current + ")", open, close + 1, max);
    }
}

/*
解題思路：
1. 使用回溯法逐步構建合法括號字串。
2. 放左括號的條件：open < n。
3. 放右括號的條件：close < open。
4. 當長度達到 2n，存入結果。
時間複雜度：O(4^n / sqrt(n))，空間複雜度：O(n)。
*/
