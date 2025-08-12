import java.util.*;
public class StockMaximizer {
    public static int maxProfit(int K, int[] prices){
        if(prices.length==0) return 0;
        int n = prices.length;
        if(K>=n/2){
            int prof=0;
            for(int i=1;i<n;i++) if(prices[i]>prices[i-1]) prof += prices[i]-prices[i-1];
            return prof;
        }
        int[] dpPrev = new int[n];
        int[] dpCurr = new int[n];
        for(int t=1;t<=K;t++){
            int maxDiff = -prices[0];
            for(int d=1;d<n;d++){
                dpCurr[d] = Math.max(dpCurr[d-1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dpPrev[d] - prices[d]);
            }
            System.arraycopy(dpCurr,0,dpPrev,0,n);
            Arrays.fill(dpCurr,0);
        }
        return dpPrev[n-1];
    }
    public static void main(String[] args){
        System.out.println(maxProfit(2,new int[]{2,4,1}));
        System.out.println(maxProfit(2,new int[]{3,2,6,5,0,3}));
        System.out.println(maxProfit(2,new int[]{1,2,3,4,5}));
    }
}
