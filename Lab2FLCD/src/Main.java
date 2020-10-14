public class Main {
    public static void main(String[] args){
        BinarySearchTree tree=new BinarySearchTree();
        tree.add("caine");
        tree.add("aaa");
        tree.add("cbaine");
        tree.add("sss");
        tree.add("rara");
        tree.add("flcd");
        tree.InOrder(tree.getRoot());
        System.out.println();
        System.out.println(tree.search("sss"));
        System.out.println(tree.search("abcd"));
        System.out.println();
    }
}
