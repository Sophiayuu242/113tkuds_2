import java.util.*;
public class MeetingRoomScheduler {
    public static int minMeetingRooms(int[][] intervals){
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] it : intervals){
            if(!pq.isEmpty() && pq.peek() <= it[0]) pq.poll();
            pq.add(it[1]);
        }
        return pq.size();
    }
    private static int binarySearchPrevious(int[][] intervals, int idx){
        int lo=0, hi=idx-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(intervals[mid][1] <= intervals[idx][0]) lo=mid+1;
            else hi=mid-1;
        }
        return hi;
    }
    public static int maxTotalTimeWithOneRoom(int[][] intervals){
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));
        int n=intervals.length;
        int[] dp = new int[n];
        int[] dur = new int[n];
        for(int i=0;i<n;i++) dur[i]=intervals[i][1]-intervals[i][0];
        for(int i=0;i<n;i++){
            int incl = dur[i];
            int p = binarySearchPrevious(intervals, i);
            if(p!=-1) incl += dp[p];
            dp[i] = Math.max(i>0?dp[i-1]:0, incl);
        }
        return dp[n-1];
    }
    public static void main(String[] args){
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(minMeetingRooms(new int[][]{{9,10},{4,9},{4,17}}));
        System.out.println(minMeetingRooms(new int[][]{{1,5},{8,9},{8,9}}));
        System.out.println(maxTotalTimeWithOneRoom(new int[][]{{1,4},{2,3},{4,6}}));
    }
}
