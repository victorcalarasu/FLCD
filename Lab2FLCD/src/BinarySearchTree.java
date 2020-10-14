class Node{
    String value;
    int index;
    Node left;
    Node right;

    public Node(String value,int index){
        this.value=value;
        this.index=index;
        this.left=null;
        this.right=null;
    }

    public int getIndex(){return this.index;}
}


public class BinarySearchTree {
    Node root;
    int globalindex;

    public BinarySearchTree(){
        //Constructor function for BST
        this.root=null;
        this.globalindex=0;
    }

    public Node getRoot(){
        //Returns the root of the BST
        return this.root;
    }
    //Pre: r -> current node, node -> what we want to add
    //Post: Node
    public Node addNode(Node r,String node){
        if (r==null){
            //We've reached a leaf so we can add the element or the tree is empty so we just insert
            globalindex++;
            return new Node(node,globalindex);
        }
        if (node.compareTo(r.value)<0){
            //If the element is smaller than the root, proceeds left
            r.left=addNode(r.left,node);
        }
        if (node.compareTo(r.value)>0){
            //If the element is bigger than the root, proceeds right
            r.right=addNode(r.right,node);
        } else{
            //If it is equal it does nothing
            return r;
        }
        return r;
    }

    //Pre: what we want to add
    //Post:Insertion of the new item ( if it happens )
    public void add(String node){
        //Calls the recursive function for the add method
        this.root=addNode(root,node);
    }

    //pre: r-> current node ; node -> the node we are looking for
    //post: true if it exists inside de BST, false otherwise
    public boolean find(Node r,String node){
        if (r==null){
            //If the BST is empty then the element is not inside
            return false;
        }
        if(r.value.compareTo(node)==0){
            //If the the element of the node is equal to what we search for, return true
            return true;
        }
        if (node.compareTo(r.value)<0){
            //If it's smaller, search left
            return find(r.left,node);
        }
        else{
            //If it's bigger search right
            return find(r.right,node);
        }

    }

    //pre: node -> what we are looking for
    //post: true/false
    public boolean search(String node){
        //Recursive call for the search function
        return find(this.root,node);
    }

    public void InOrder(Node node){
        if (node!=null){
            InOrder(node.left);
            System.out.print(" " + node.value);
            InOrder(node.right);
        }
    }
}
