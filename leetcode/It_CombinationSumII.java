import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // 跳過重複
            if (target - candidates[i] < 0) break;
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}

/*
解題思路：
回溯 + 去重：
1. 排序，確保相同數字相鄰。
2. 遍歷時若與前一個相同且在同一層，則跳過，避免重複組合。
3. 與 Combination Sum 不同，這裡每個數字只能用一次。
時間複雜度：指數級。
*/
