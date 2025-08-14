import java.util.*;
public class PersistentAVLExercise {
    static class Node{
        final int v,h;final Node l,r;
        Node(int v,Node l,Node r){this.v=v;this.l=l;this.r=r;this.h=1+Math.max(h(l),h(r));}
    }
    List<Node> versions=new ArrayList<>();
    static int h(Node n){return n==null?0:n.h;}
    static int bal(Node n){return n==null?0:h(n.l)-h(n.r);}
    static Node rR(Node y){Node x=y.l,T2=x.r;Node ny=new Node(y.v,T2,y.r);Node nx=new Node(x.v,x.l,ny);return nx;}
    static Node rL(Node x){Node y=x.r,T2=y.l;Node nx=new Node(x.v,x.l,T2);Node ny=new Node(y.v,nx,y.r);return ny;}
    Node ins(Node n,int v){
        if(n==null)return new Node(v,null,null);
        if(v<n.v){Node l=ins(n.l,v);n=new Node(n.v,l,n.r);}
        else if(v>n.v){Node r=ins(n.r,v);n=new Node(n.v,n.l,r);}
        else return n;
        int b=bal(n);
        if(b>1&&v<n.l.v)return rR(n);
        if(b<-1&&v>n.r.v)return rL(n);
        if(b>1&&v>n.l.v){Node l=rL(n.l);n=new Node(n.v,l,n.r);return rR(n);}
        if(b<-1&&v<n.r.v){Node r=rR(n.r);n=new Node(n.v,n.l,r);return rL(n);}
        return n;
    }
    void insert(int v){
        Node latest=versions.isEmpty()?null:versions.get(versions.size()-1);
        Node newV=ins(latest,v);
        versions.add(newV);
    }
    void inorder(Node n){if(n!=null){inorder(n.l);System.out.print(n.v+" ");inorder(n.r);}}
    void printVersion(int id){inorder(versions.get(id));System.out.println();}
    public static void main(String[] args){
        PersistentAVLExercise p=new PersistentAVLExercise();
        p.insert(10);p.insert(20);p.insert(30);
        p.printVersion(0);
        p.printVersion(1);
        p.printVersion(2);
    }
}
