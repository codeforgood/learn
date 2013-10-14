import com.sravi.tree.BSTree;

/**
 * User: sravi
 * Date: 10/13/13
 * Time: 12:21 AM
 */
public class MyTreeMain {

    public static void main(String[] args){

        System.out.println("Constructing BST");
        BSTree bst = new BSTree();

        bst.addNode(5);
        bst.addNode(6);
        bst.addNode(8);
        bst.addNode(3);
        bst.addNode(10);
        bst.addNode(1);
        bst.addNode(0);
        bst.addNode(12);
        bst.addNode(2);
        bst.addNode(7);
        bst.addNode(9);
        bst.addNode(4);

        System.out.print("PreOrder BST : ");
        bst.preOrder();
        System.out.println("");
        System.out.print("InOrder BST : ");
        bst.inOrder();
        System.out.println("");

        System.out.println("Search BST for, 5: " + (bst.find(5)? "Found":"Not Found"));
        System.out.println("Search BST for, 9: " + (bst.find(9)? "Found":"Not Found"));

        System.out.println("Is Binary search tree: " + bst.isBST());

        System.out.println("Is Mirror tree: " + bst.isMirror());

        System.out.println("Height of tree: " + bst.getHeight());

        System.out.println("Successor to 3: " + bst.findNext(3));
        System.out.println("Successor to 1: " + bst.findNext(1));
        System.out.println("Successor to 12: " + bst.findNext(12));
        System.out.println("Successor to 8: " + bst.findNext(8));
        System.out.println("Successor to 2: " + bst.findNext(2));
        System.out.println("Successor to 9: " + bst.findNext(9));
    }
}
