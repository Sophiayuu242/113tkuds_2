import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) left++;
                else if (sum > target) right--;
                else return sum; // 完全相等，直接回傳
            }
        }
        return closest;
    }
}

/*
解題思路：
題目要求找出三數之和最接近 target。
1. 先排序陣列。
2. 固定一個數 nums[i]，用雙指針 left、right 掃描另外兩數。
3. 計算 sum 與 target 差距，若更接近就更新 closest。
4. 根據 sum 與 target 比較調整指針。
時間 O(n^2)，空間 O(1)。
*/
