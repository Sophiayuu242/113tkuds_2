class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);   // 單中心
            int len2 = expand(s, i, i + 1); // 雙中心
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }
        return right - left - 1;
    }
}

/*
解題思路：
使用中心擴展法。
對每個位置當作回文中心，分別考慮單字元和雙字元中心。
向外擴展並更新最長回文。
時間 O(n^2)，空間 O(1)。
*/
