import java.util.*;
public class MovingAverageStream {
    private int size;
    private Deque<Integer> q = new ArrayDeque<>();
    private long sum = 0;
    private TreeMap<Integer,Integer> counts = new TreeMap<>();
    public MovingAverageStream(int size){ this.size = size; }
    public double next(int val){
        q.addLast(val);
        sum += val;
        counts.put(val, counts.getOrDefault(val,0)+1);
        if(q.size()>size){
            int out = q.removeFirst();
            sum -= out;
            counts.put(out, counts.get(out)-1);
            if(counts.get(out)==0) counts.remove(out);
        }
        return (double)sum / q.size();
    }
    public double getMedian(){
        if(q.isEmpty()) return 0;
        int n = q.size();
        int target1 = (n+1)/2;
        int target2 = (n%2==1)?target1:target1+1;
        int cnt=0;
        Integer m1=null,m2=null;
        for(Map.Entry<Integer,Integer> e: counts.entrySet()){
            cnt += e.getValue();
            if(m1==null && cnt>=target1) m1 = e.getKey();
            if(m2==null && cnt>=target2) { m2 = e.getKey(); break; }
        }
        if(n%2==1) return m1;
        return ((double)m1 + (double)m2)/2.0;
    }
    public int getMin(){ return counts.isEmpty()?0:counts.firstKey(); }
    public int getMax(){ return counts.isEmpty()?0:counts.lastKey(); }
    public static void main(String[] args){
        MovingAverageStream ma = new MovingAverageStream(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
        System.out.println(ma.getMedian());
        System.out.println(ma.getMin());
        System.out.println(ma.getMax());
    }
}
