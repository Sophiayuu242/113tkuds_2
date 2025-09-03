import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}

/*
解題思路：
與 3Sum 類似，但多一層迴圈。
1. 排序陣列。
2. 先固定 nums[i] 與 nums[j]，再用雙指針 left/right 找剩下兩數。
3. 使用 long 避免整數溢位。
4. 避免重複結果要跳過相同元素。
時間 O(n^3)，空間 O(1)。
*/
