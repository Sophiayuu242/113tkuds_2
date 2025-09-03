import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}

/*
解題思路：
用 stack 模擬括號匹配。
1. 遇到左括號，就把對應的右括號壓入 stack。
2. 遇到右括號時，檢查是否與 stack 頂端相同。
3. 全部處理完後 stack 必須為空才算有效。
時間 O(n)，空間 O(n)。
*/
