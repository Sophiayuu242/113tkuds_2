public class AVLDeleteExercise {
    static class Node {
        int val,height; Node left,right;
        Node(int v){ val=v;height=1; }
    }
    Node root;

    int h(Node n){ return n==null?0:n.height; }

    int bal(Node n){ return n==null?0:h(n.left)-h(n.right); }

    Node upd(Node n){ n.height=1+Math.max(h(n.left),h(n.right)); return n; }

    Node rotR(Node y){ Node x=y.left,T2=x.right; x.right=y;y.left=T2;upd(y);upd(x);return x; }
    Node rotL(Node x){ Node y=x.right,T2=y.left; y.left=x;x.right=T2;upd(x);upd(y);return y; }

    Node ins(Node n,int v){
        if(n==null) return new Node(v);
        if(v<n.val) n.left=ins(n.left,v);
        else if(v>n.val) n.right=ins(n.right,v);
        else return n;
        upd(n);
        int b=bal(n);
        if(b>1&&v<n.left.val) return rotR(n);
        if(b<-1&&v>n.right.val) return rotL(n);
        if(b>1&&v>n.left.val){n.left=rotL(n.left);return rotR(n);}
        if(b<-1&&v<n.right.val){n.right=rotR(n.right);return rotL(n);}
        return n;
    }

    void insert(int v){ root=ins(root,v); }

    Node min(Node n){ while(n.left!=null)n=n.left; return n; }

    Node del(Node n,int v){
        if(n==null) return null;
        if(v<n.val) n.left=del(n.left,v);
        else if(v>n.val) n.right=del(n.right,v);
        else{
            if(n.left==null||n.right==null) n=(n.left!=null)?n.left:n.right;
            else{ Node t=min(n.right); n.val=t.val; n.right=del(n.right,t.val);}
        }
        if(n==null) return n;
        upd(n);
        int b=bal(n);
        if(b>1&&bal(n.left)>=0) return rotR(n);
        if(b>1&&bal(n.left)<0){n.left=rotL(n.left);return rotR(n);}
        if(b<-1&&bal(n.right)<=0) return rotL(n);
        if(b<-1&&bal(n.right)>0){n.right=rotR(n.right);return rotL(n);}
        return n;
    }

    void delete(int v){ root=del(root,v); }

    void inorder(Node n){ if(n!=null){ inorder(n.left);System.out.print(n.val+" ");inorder(n.right);} }

    public static void main(String[] args){
        AVLDeleteExercise t=new AVLDeleteExercise();
        int[] a={20,10,30,25,40};
        for(int x:a) t.insert(x);
        t.inorder(t.root);System.out.println();
        t.delete(30);
        t.inorder(t.root);System.out.println();
    }
}
