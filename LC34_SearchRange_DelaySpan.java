import java.util.*;

public class LC34_SearchRange_DelaySpan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        sc.close();

        int[] res = searchRange(nums, target);
        System.out.println(res[0]+" "+res[1]);
    }

    static int[] searchRange(int[] nums, int target){
        return new int[]{lowerBound(nums,target), upperBound(nums,target)};
    }

    static int lowerBound(int[] nums, int target){
        int l=0, r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>=target) r=mid-1;
            else l=mid+1;
        }
        if(l<nums.length && nums[l]==target) ans=l;
        return ans;
    }

    static int upperBound(int[] nums, int target){
        int l=0,r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]<=target) l=mid+1;
            else r=mid-1;
        }
        if(r>=0 && nums[r]==target) ans=r;
        return ans;
    }
}
