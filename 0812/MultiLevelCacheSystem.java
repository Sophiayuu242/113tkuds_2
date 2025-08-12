import java.util.*;
public class MultiLevelCacheSystem {
    static class LRUCache<K,V> extends LinkedHashMap<K,V>{
        private int cap;
        LRUCache(int cap){ super(cap,0.75f,true); this.cap=cap; }
        protected boolean removeEldestEntry(Map.Entry<K,V> e){ return size()>cap; }
    }
    private LRUCache<Integer,String> L1 = new LRUCache<>(2);
    private LRUCache<Integer,String> L2 = new LRUCache<>(5);
    private LRUCache<Integer,String> L3 = new LRUCache<>(10);
    private Map<Integer,Integer> freq = new HashMap<>();
    public void put(int k, String v){
        if(L1.containsKey(k)){ L1.put(k,v); return; }
        if(L2.containsKey(k)){ L2.remove(k); L1.put(k,v); promoteIfNeeded(); return; }
        if(L3.containsKey(k)){ L3.remove(k); L1.put(k,v); promoteIfNeeded(); return; }
        L1.put(k,v);
        if(L1.size()>L1.cap){
            Iterator<Map.Entry<Integer,String>> it = L1.entrySet().iterator();
            Map.Entry<Integer,String> e = it.next();
            it.remove();
            L2.put(e.getKey(), e.getValue());
        }
        promoteIfNeeded();
    }
    private void promoteIfNeeded(){
        if(L2.size()>L2.cap){
            Iterator<Map.Entry<Integer,String>> it = L2.entrySet().iterator();
            Map.Entry<Integer,String> e = it.next();
            it.remove();
            L3.put(e.getKey(), e.getValue());
        }
    }
    public String get(int k){
        if(L1.containsKey(k)){ freq.put(k, freq.getOrDefault(k,0)+1); return L1.get(k); }
        if(L2.containsKey(k)){ String v = L2.remove(k); L1.put(k,v); freq.put(k, freq.getOrDefault(k,0)+1); if(L1.size()>L1.cap){ Iterator<Map.Entry<Integer,String>> it=L1.entrySet().iterator(); it.next(); it.remove(); } return v; }
        if(L3.containsKey(k)){ String v = L3.remove(k); L1.put(k,v); freq.put(k, freq.getOrDefault(k,0)+1); if(L1.size()>L1.cap){ Iterator<Map.Entry<Integer,String>> it=L1.entrySet().iterator(); it.next(); it.remove(); } return v; }
        return null;
    }
    public void debugPrint(){
        System.out.println("L1:"+L1.keySet());
        System.out.println("L2:"+L2.keySet());
        System.out.println("L3:"+L3.keySet());
    }
    public static void main(String[] args){
        MultiLevelCacheSystem c = new MultiLevelCacheSystem();
        c.put(1,"A"); c.put(2,"B"); c.put(3,"C");
        c.debugPrint();
        c.get(1); c.get(1); c.get(2);
        c.debugPrint();
        c.put(4,"D"); c.put(5,"E"); c.put(6,"F");
        c.debugPrint();
    }
}
