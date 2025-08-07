import java.util.HashSet;

public class AdvancedStringRecursion {
    public static void main(String[] args) {
        System.out.println("所有排列:");
        permute("", "abc");

        System.out.println("遞迴匹配:");
        System.out.println(match("abc", "a.c")); // 類似正規表示法的簡單實作

        System.out.println("移除重複:");
        System.out.println(removeDuplicates("aabbcc"));

        System.out.println("所有子字串:");
        substrings("abc", 0, "");
    }

    public static void permute(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1));
        }
    }

    public static boolean match(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        return firstMatch && match(text.substring(1), pattern.substring(1));
    }

    public static String removeDuplicates(String s) {
        return removeDuplicatesHelper(s, 0, new HashSet<>(), "");
    }

    public static String removeDuplicatesHelper(String s, int index, HashSet<Character> seen, String result) {
        if (index == s.length()) return result;
        char c = s.charAt(index);
        if (!seen.contains(c)) {
            seen.add(c);
            result += c;
        }
        return removeDuplicatesHelper(s, index + 1, seen, result);
    }

    public static void substrings(String s, int index, String current) {
        if (index == s.length()) {
            if (!current.isEmpty()) System.out.println(current);
            return;
        }
        substrings(s, index + 1, current + s.charAt(index));
        substrings(s, index + 1, current);
    }
}
