import java.util.*;

public class M12_MergeKTimeTables {
    static class Entry implements Comparable<Entry> {
        int time, listIndex, elementIndex;
        Entry(int t, int l, int e) {
            time = t;
            listIndex = l;
            elementIndex = e;
        }
        public int compareTo(Entry other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }

        List<Integer> result = mergeKLists(lists);
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }

    private static List<Integer> mergeKLists(List<List<Integer>> lists) {
        List<Integer> merged = new ArrayList<>();
        PriorityQueue<Entry> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                pq.add(new Entry(lists.get(i).get(0), i, 0));
            }
        }

        while (!pq.isEmpty()) {
            Entry cur = pq.poll();
            merged.add(cur.time);
            int nextIdx = cur.elementIndex + 1;
            if (nextIdx < lists.get(cur.listIndex).size()) {
                pq.add(new Entry(lists.get(cur.listIndex).get(nextIdx), cur.listIndex, nextIdx));
            }
        }
        return merged;
    }
}