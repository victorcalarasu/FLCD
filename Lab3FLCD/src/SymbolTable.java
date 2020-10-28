public class SymbolTable {
    private BinarySearchTree tree;

    public SymbolTable(){
        this.tree=new BinarySearchTree();
    }

    public BinarySearchTree get(){
        return this.tree;
    }

    public void add(String s){
        this.tree.add(s);
    }

    public String toString(){
        return tree.toString();
    }
}
