package LAB06;

public class test {
    public static void main(String[] args){
        BST<Integer> tree = new BST<>() ;
        tree.insert(8);
        tree.insert(4);
        tree.insert(9);
        tree.insert(2);
        tree.insert(7);

        System.out.print("Breadth-First traversal prints: ");tree.breadthFirst();System.out.println("");
        System.out.print("Preorder Depth First Traversal prints: "); tree.preorder(); System.out.println("");
        System.out.print("Inorder Depth First Traversal prints: "); tree.inorder();System.out.println("");
        System.out.print("Post Order Depth First Traversal prints: "); tree.postorder();System.out.println("");
        System.out.println("Tests");
        System.out.println("The number of nodes: " + tree.count());
        System.out.println("'4' is a leaf? "+ tree.isLeaf(4) );
        System.out.println("'7' is a leaf? "+ tree.isLeaf(7) );
        System.out.println("Number of leafs is "+ tree.countLeaves());
        System.out.println("Height is "+ tree.height());
    }
}
