import java.util.*;
public class BinaryTree {     //--------------BINARY TREE--------------
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {  //constructor
            data = val;
            left = null;
            right = null;
        }
    }

    public BinaryTree(int val) { //-----------TO CRETE A BINARY TREE WITH ROOT NODE----------
        root = new Node(val);
    }

    public void insertAtLeft(Node r,int val) { //------------INSERT @ LEFT------------
        Node newNode = new Node(val);
        r.left = newNode;
    }

    public void insertAtRight(Node r,int val) { //-----------INSERT @ RIGHT--------------
        Node newNode = new Node(val);
        r.right = newNode;
    }

    public void preOrder(Node root){   //-------------PREORDER--------------
        while(root!=null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(Node root){  //-------------INORDER---------------
        while(root!=null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }
    public void postOrder(Node root){  //--------------POSTORDER--------------
        while(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
    public class demo{
        public static void main(String[] args) {
            BinaryTree tree=new BinaryTree(7);
            tree.insertAtLeft(tree.root.left,10);
            tree.insertAtLeft(tree.root.right,10);
            tree.insertAtLeft(tree.root.left.left,10);
            tree.insertAtLeft(tree.root.left.right,10);
            tree.insertAtLeft(tree.root.left.left.left,10);
            tree.insertAtLeft(tree.root.right.left,10);
            tree.insertAtLeft(tree.root.right.right,10);



        }
    }
}