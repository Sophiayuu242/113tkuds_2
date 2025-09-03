class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        return haystack.indexOf(needle);
    }
}

/*
解題思路：
題目要求找出 needle 在 haystack 中第一次出現的位置，若不存在回傳 -1。
可以直接使用 Java 的 indexOf() 方法，內部是類似 KMP 的最佳化搜尋。
時間複雜度 O(n*m)，最壞情況需比對每個位置。
*/
