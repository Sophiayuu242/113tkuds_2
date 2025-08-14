import java.util.*;
public class AVLRangeQueryExercise {
    static class Node{int v,h;Node l,r;Node(int x){v=x;h=1;}}
    Node root;
    int h(Node n){return n==null?0:n.h;}
    Node upd(Node n){n.h=1+Math.max(h(n.l),h(n.r));return n;}
    int bal(Node n){return n==null?0:h(n.l)-h(n.r);}
    Node rR(Node y){Node x=y.l,T2=x.r;x.r=y;y.l=T2;upd(y);upd(x);return x;}
    Node rL(Node x){Node y=x.r,T2=y.l;y.l=x;x.r=T2;upd(x);upd(y);return y;}
    Node ins(Node n,int v){
        if(n==null)return new Node(v);
        if(v<n.v)n.l=ins(n.l,v);else if(v>n.v)n.r=ins(n.r,v);else return n;
        upd(n);int b=bal(n);
        if(b>1&&v<n.l.v)return rR(n);
        if(b<-1&&v>n.r.v)return rL(n);
        if(b>1&&v>n.l.v){n.l=rL(n.l);return rR(n);}
        if(b<-1&&v<n.r.v){n.r=rR(n.r);return rL(n);}
        return n;
    }
    void insert(int v){root=ins(root,v);}
    void range(Node n,int lo,int hi,List<Integer> res){
        if(n==null)return;
        if(n.v>lo)range(n.l,lo,hi,res);
        if(n.v>=lo&&n.v<=hi)res.add(n.v);
        if(n.v<hi)range(n.r,lo,hi,res);
    }
    List<Integer> rangeQuery(int lo,int hi){List<Integer> r=new ArrayList<>();range(root,lo,hi,r);return r;}
    public static void main(String[] args){
        AVLRangeQueryExercise t=new AVLRangeQueryExercise();
        int[] a={20,4,26,3,9,15};
        for(int x:a)t.insert(x);
        System.out.println(t.rangeQuery(4,20));
    }
}
