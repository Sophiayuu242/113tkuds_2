import java.util.*;

public class LC17_PhoneCombos_CSShift {
    static String[] mapping = {
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine().trim();
        sc.close();
        if(digits.length() == 0) return;

        List<String> res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), res);
        for(String s : res) System.out.println(s);
    }

    static void backtrack(String digits, int idx, StringBuilder sb, List<String> res) {
        if(idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = mapping[digits.charAt(idx) - '2'];
        for(char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
