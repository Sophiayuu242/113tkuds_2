import java.util.*;
public class AVLLeaderboardSystem {
    static class Node{
        int score,h,size;String name;
        Node l,r;
        Node(String n,int s){name=n;score=s;h=1;size=1;}
    }
    Node root;
    int h(Node n){return n==null?0:n.h;}
    int sz(Node n){return n==null?0:n.size;}
    Node upd(Node n){n.h=1+Math.max(h(n.l),h(n.r));n.size=1+sz(n.l)+sz(n.r);return n;}
    int bal(Node n){return n==null?0:h(n.l)-h(n.r);}
    Node rR(Node y){Node x=y.l,T2=x.r;x.r=y;y.l=T2;upd(y);upd(x);return x;}
    Node rL(Node x){Node y=x.r,T2=y.l;y.l=x;x.r=T2;upd(x);upd(y);return y;}
    Node ins(Node n,String name,int s){
        if(n==null)return new Node(name,s);
        if(s>n.score)n.l=ins(n.l,name,s);else n.r=ins(n.r,name,s);
        upd(n);int b=bal(n);
        if(b>1&&s>n.l.score)return rR(n);
        if(b<-1&&s<=n.r.score)return rL(n);
        if(b>1&&s<=n.l.score){n.l=rL(n.l);return rR(n);}
        if(b<-1&&s>n.r.score){n.r=rR(n.r);return rL(n);}
        return n;
    }
    void add(String n,int s){root=ins(root,n,s);}
    int rank(Node n,int s){
        if(n==null)return 0;
        if(s>n.score)return rank(n.l,s);
        if(s<n.score)return sz(n.l)+1+rank(n.r,s);
        return sz(n.l)+1;
    }
    int getRank(int s){return rank(root,s);}
    void topK(Node n,List<String> r,int k){
        if(n==null||r.size()>=k)return;
        topK(n.l,r,k);
        if(r.size()<k)r.add(n.name+":"+n.score);
        topK(n.r,r,k);
    }
    List<String> getTopK(int k){List<String> r=new ArrayList<>();topK(root,r,k);return r;}
    public static void main(String[] args){
        AVLLeaderboardSystem lb=new AVLLeaderboardSystem();
        lb.add("A",100);lb.add("B",200);lb.add("C",150);
        System.out.println(lb.getRank(150));
        System.out.println(lb.getTopK(2));
    }
}
