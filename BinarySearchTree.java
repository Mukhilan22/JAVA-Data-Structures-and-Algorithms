public class BinarySearchTree {   //------BINARY SEARCH TREE------
    Node root;
    class Node{
        int key;
        Node left;
        Node right;

        Node(int val){
            key=val;
            left = null;
            right = null;
        }

    }
    public BinarySearchTree(){
        root=null;
    }
    public BinarySearchTree(int val) {    //----CREATE A NEW BST-----
        root = new Node(val);
    }

    public void insert(int val) {
        insert(root,val); //So that we dont need to tupe root always
    }

    public Node insert(Node root,int val){  //------INSERT A VAL------
        if(root==null){ //if left or right is empty it enters here
            return new Node(val);  //Node created and sent to Node left or right
        }
        if(val>root.key){
            Node left=insert(root.left,val);
        }
        else{
            Node right=insert(root.right,val);
        }
        return root;  //for name sake as some thing shud be returned
    }

    public void inOrder(Node Root){   //-----PRINT BST-----
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.key + ' ');
            inOrder(root.right);
        }
    }

    public Node Search(Node root,int val){
        if(root.key==val){
            return root; //Element found
        }
        if(val>root.key){
            Node left=insert(root.left,val);
        }
        else{
            Node right=insert(root.right,val);
        }
        return null; //Element not found

    }

    /*public Node delete(Node root,int val){  //------DELETE------

            if(root.key>val){
                delete(root.left,val);
            }
            else if(root.key<val){
                delete(root.right,val);
            }


    }*/


    public class main{
        public static void main(String[] args) {
            BinarySearchTree bst= new BinarySearchTree();
            bst.insert(bst.root,10);
            bst.insert(2);
            bst.insert(4);
            bst.insert(6);
            bst.insert(1);
            bst.insert(3);
            bst.inOrder(bst.root);

            }
        }



}
