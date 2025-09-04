import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (target - candidates[i] < 0) continue;
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }
}

/*
解題思路：
回溯：
1. 每次從 start 開始選擇，避免重複組合。
2. 若 target == 0，記錄當前解。
3. 若 target < 0，回退。
時間複雜度：指數級，但剪枝能加速。
*/
