import java.util.*;

class Solution {
    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(res, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/*
解題思路：
這題是回溯法 (Backtracking)。
1. 建立數字到字母的映射表。
2. 使用遞迴，每層決定一個數字的所有字母。
3. 當 index == digits 長度，代表組合完成，加入答案。
時間 O(3^n * 4^m)，n/m 為輸入中 3 鍵與 4 鍵數量。
*/
