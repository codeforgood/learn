import com.sravi.tree.BSTree;

/**
 * Created with IntelliJ IDEA.
 * User: sravi
 * Date: 10/13/13
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyTreeMain {

    public static void main(String[] args){

        System.out.println("Constructing BST");
        BSTree bst = new BSTree();

        bst.addNode(5);
        bst.addNode(4);
        bst.addNode(6);
        bst.addNode(8);
        bst.addNode(3);
        bst.addNode(10);
        bst.addNode(1);
        bst.addNode(0);
        bst.addNode(12);

        System.out.print("PreOrder BST : ");
        bst.preOrder();
        System.out.println("");
        System.out.print("InOrder BST : ");
        bst.inOrder();
        System.out.println("");

        System.out.println("Search BST for, 5: " + ((bst.find(5) == true)? "Found":"Not Found"));
        System.out.println("Search BST for, 9: " + ((bst.find(9) == true)? "Found":"Not Found"));

        System.out.println("Is Binary search tree: " + bst.isBST());

        System.out.println("Is Mirror tree: " + bst.isMirror());

        System.out.println("Height of tree: " + bst.getHeight());
    }
}
