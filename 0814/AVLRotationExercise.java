public class AVLRotationExercise {
    static class Node {
        int val, height;
        Node left, right;
        Node(int v){ val=v; height=1; }
    }

    int height(Node n){ return n==null?0:n.height; }

    Node update(Node n){ n.height = 1+Math.max(height(n.left),height(n.right)); return n; }

    Node rightRotate(Node y){
        Node x=y.left, T2=x.right;
        x.right=y; y.left=T2;
        update(y); update(x);
        return x;
    }

    Node leftRotate(Node x){
        Node y=x.right, T2=y.left;
        y.left=x; x.right=T2;
        update(x); update(y);
        return y;
    }

    Node leftRightRotate(Node n){
        n.left=leftRotate(n.left);
        return rightRotate(n);
    }

    Node rightLeftRotate(Node n){
        n.right=rightRotate(n.right);
        return leftRotate(n);
    }

    public static void main(String[] args){
        AVLRotationExercise e=new AVLRotationExercise();
        Node root=new Node(30);
        root.left=new Node(20);
        root.left.left=new Node(10);
        root=e.rightRotate(root);
        System.out.println("RightRotate root="+root.val);

        root=new Node(10);
        root.right=new Node(20);
        root.right.right=new Node(30);
        root=e.leftRotate(root);
        System.out.println("LeftRotate root="+root.val);

        root=new Node(30);
        root.left=new Node(10);
        root.left.right=new Node(20);
        root=e.leftRightRotate(root);
        System.out.println("LeftRightRotate root="+root.val);

        root=new Node(10);
        root.right=new Node(30);
        root.right.left=new Node(20);
        root=e.rightLeftRotate(root);
        System.out.println("RightLeftRotate root="+root.val);
    }
}
