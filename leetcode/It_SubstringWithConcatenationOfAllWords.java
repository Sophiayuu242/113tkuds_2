import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return res;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                if (wordCount.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;
                    while (seen.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == words.length) {
                        res.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }
}

/*
解題思路：
題目要求找出所有起始索引，使得子字串為 words 陣列中所有單字的連接，且每個單字出現次數一致。
做法：
1. 計算每個單字的長度 wordLen 與總長度 totalLen。
2. 使用 HashMap 保存每個 word 的出現次數。
3. 採用滑動視窗，每次移動 wordLen，檢查是否符合。
4. 如果超過次數，左指針移動直到合法。
5. 當視窗大小等於 words 數量時，記錄起始索引。
時間複雜度 O(n * wordLen)，空間 O(k)，其中 k 為字典大小。
*/
