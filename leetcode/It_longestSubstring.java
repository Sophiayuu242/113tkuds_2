import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

/*
解題思路：
滑動視窗 + HashSet。
right 向右擴展，如果發現重複字元，就移動 left。
確保每次的子字串都沒有重複字元，更新最大長度。
時間 O(n)，空間 O(n)。
*/
