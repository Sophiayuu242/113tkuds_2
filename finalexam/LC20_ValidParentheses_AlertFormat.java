import java.util.*;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                // 開括號入棧
                stack.push(c);
            } else if (map.containsKey(c)) {
                // 閉括號檢查
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
