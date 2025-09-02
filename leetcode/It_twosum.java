import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // 保證有解
    }
}

/*
解題思路：
利用 HashMap 來存每個數字和它的索引。
遍歷陣列時，檢查 target - nums[i] 是否已經存在於 map 中。
若存在，代表找到兩個數相加等於 target。
時間 O(n)，空間 O(n)。
*/
