import java.util.*;

public class M03_TopKConvenience {
    static class Item {
        String name;
        int qty;
        int index;
        Item(String n, int q, int i) {
            name = n;
            qty = q;
            index = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        PriorityQueue<Item> pq = new PriorityQueue<>(
            (a, b) -> a.qty != b.qty ? a.qty - b.qty : a.index - b.index
        );

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            Item item = new Item(name, qty, i);

            if (pq.size() < K) {
                pq.offer(item);
            } else if (qty > pq.peek().qty || 
                      (qty == pq.peek().qty && i < pq.peek().index)) {
                pq.poll();
                pq.offer(item);
            }
        }

        List<Item> result = new ArrayList<>(pq);
        result.sort((a, b) -> {
            if (b.qty != a.qty) return b.qty - a.qty;
            return a.index - b.index;
        });

        for (Item item : result) {
            System.out.println(item.name + " " + item.qty);
        }
    }
}

/*
 * Time Complexity: O(n log K)
 * 說明：
 * - 每筆資料最多觸發一次 heap 操作 (插入或替換)，成本 O(log K)。
 * - n 筆資料總共 O(n log K)，其中 K << n。
 * - 最後輸出排序 K 筆 O(K log K)，相比 O(n log K) 可忽略。 */