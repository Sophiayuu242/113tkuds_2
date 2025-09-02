class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}

/*
解題思路：
把數字按照羅馬數字對應表從大到小拆解。
每次減去一個對應值，並把符號加到結果。
例如 1994 -> 1000(M) + 900(CM) + 90(XC) + 4(IV)。
時間複雜度 O(1)（最多處理固定 13 個符號）。
*/
