class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

/*
解題思路：
假設第一個字串是 prefix，然後跟其他字串比較。
若不是開頭，就縮短 prefix。
直到所有字串都符合為止。
時間複雜度 O(S)，S 是所有字母總長度。
*/
