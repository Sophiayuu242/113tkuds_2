class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char prev = res.charAt(0);
            int count = 1;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == prev) {
                    count++;
                } else {
                    sb.append(count).append(prev);
                    prev = res.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(prev);
            res = sb.toString();
        }
        return res;
    }
}

/*
解題思路：
- 從 "1" 開始，每次讀取前一輪字串的數字描述。
- 用 count 統計連續數字，最後拼接。
時間複雜度：O(n * m)，m 為字串長度。
*/
