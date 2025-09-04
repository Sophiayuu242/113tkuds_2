class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

/*
解題思路：
1. 從右往左找第一個遞增位置 i。
2. 再從右往左找第一個比 nums[i] 大的數 j，交換 i 和 j。
3. 反轉 i+1 之後的數列，得到最小的遞增序列。
時間複雜度：O(n)，空間 O(1)。
*/
