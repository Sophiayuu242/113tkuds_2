
import java.util.*;

public class LC40_CombinationSum2_Procurement {
    static List<List<Integer>> res;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        sc.close();

        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>());
        for(List<Integer> l: res){
            for(int i=0;i<l.size();i++){
                System.out.print(l.get(i));
                if(i<l.size()-1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void backtrack(int[] nums, int start, int target, List<Integer> path){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target<0) return;

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue; // skip duplicates
            path.add(nums[i]);
            backtrack(nums, i+1, target-nums[i], path); // II版每數字僅一次
            path.remove(path.size()-1);
        }
    }
}
