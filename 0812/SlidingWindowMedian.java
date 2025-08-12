import java.util.*;
public class SlidingWindowMedian {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private Map<Integer,Integer> delayed = new HashMap<>();
    private int maxSize = 0, minSize = 0;
    private void prune(PriorityQueue<Integer> heap){
        while(!heap.isEmpty() && delayed.getOrDefault(heap.peek(),0)>0){
            int v = heap.peek();
            delayed.put(v, delayed.get(v)-1);
            if(delayed.get(v)==0) delayed.remove(v);
            heap.poll();
        }
    }
    private void balance(){
        if(maxSize > minSize + 1){
            minHeap.add(maxHeap.poll());
            maxSize--; minSize++;
            prune(maxHeap);
        } else if(minSize > maxSize){
            maxHeap.add(minHeap.poll());
            minSize--; maxSize++;
            prune(minHeap);
        }
    }
    private void add(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){ maxHeap.add(num); maxSize++; }
        else { minHeap.add(num); minSize++; }
        balance();
    }
    private void remove(int num){
        if(!maxHeap.isEmpty() && num <= maxHeap.peek()){ delayed.put(num, delayed.getOrDefault(num,0)+1); maxSize--; if(num==maxHeap.peek()) prune(maxHeap); }
        else { delayed.put(num, delayed.getOrDefault(num,0)+1); minSize--; if(num==minHeap.peek()) prune(minHeap); }
        balance();
    }
    public double[] medianSlidingWindow(int[] nums, int k){
        if(k==0) return new double[0];
        List<Double> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
            if(i>=k) remove(nums[i-k]);
            if(i>=k-1){
                prune(maxHeap); prune(minHeap);
                if((k&1)==1) res.add((double)maxHeap.peek());
                else res.add(((double)maxHeap.peek() + (double)minHeap.peek())/2.0);
            }
        }
        double[] out = new double[res.size()];
        for(int i=0;i<res.size();i++) out[i]=res.get(i);
        return out;
    }
    public static void main(String[] args){
        SlidingWindowMedian s = new SlidingWindowMedian();
        double[] r1 = s.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        System.out.println(Arrays.toString(r1));
        double[] r2 = s.medianSlidingWindow(new int[]{1,2,3,4},2);
        System.out.println(Arrays.toString(r2));
    }
}