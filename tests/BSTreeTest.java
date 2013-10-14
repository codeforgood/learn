/**
 * Created with IntelliJ IDEA.
 * User: sravi
 * Date: 10/13/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
import com.sravi.tree.BSTree;
import com.sravi.tree.TreeNode;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class BSTreeTest {

    static BSTree bst;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public BSTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("\nSETUP CLASS RUNNING");
        bst = new BSTree();
        bst.addNode(1);
        bst.addNode(4);
        bst.addNode(0);
        bst.addNode(7);
        bst.addNode(5);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("\nTEARDOWN CLASS RUNNING -- Nothing to do though");
    }

    @Before
    public void setUp() {
        System.out.println("\nSETUP IS RUNNING -- Nothing to do though");
    }

    @After
    public void tearDown() {
        System.out.println("TEARDOWN IS RUNNING -- Nothing to do though");
    }

    @Test
    public void testRoot() {
        assertEquals(bst.getRoot().getVal(), 1);
    }

    @Test
    public void isBSTree(){
        assertTrue(bst.isBST());
    }

    @Test
    public void notBSTree(){
        BSTree bst1 = new BSTree();
        TreeNode nodeL_1 = new TreeNode(6);
        TreeNode nodeR_1 = new TreeNode(3);
        TreeNode node = new TreeNode(5);
        node.setLeft(nodeL_1);
        node.setRight(nodeR_1);
        bst1.setRoot(node);
        assertFalse(bst1.isBST());
    }

    @Test
    public void findNode(){
        assertEquals(bst.find(9), false);
        assertEquals(bst.find(1), true);
        assertEquals(bst.find(7), true);
        assertEquals(bst.find(8), false);
    }

    @Test
    public void isMirrorTrees(){
        BSTree bst1 = new BSTree();
        TreeNode nodeL_1 = new TreeNode(3);
        TreeNode nodeR_1 = new TreeNode(3);
        TreeNode node = new TreeNode(5);
        node.setLeft(nodeL_1);
        node.setRight(nodeR_1);
        bst1.setRoot(node);
        assertTrue(bst1.isMirror());
    }

    @Test
    public void notMirrorTree(){
        BSTree bst1 = new BSTree();
        TreeNode nodeL_1 = new TreeNode(5);
        TreeNode nodeR_1 = new TreeNode(7);
        TreeNode node = new TreeNode(5);
        node.setLeft(nodeL_1);
        node.setRight(nodeR_1);
        bst1.setRoot(node);
        assertFalse(bst1.isMirror());
    }

    @Test(expected = Exception.class)
    public void testFindNext_invalid_key() throws Exception{
        bst.findNext(17);
    }

    @Test
    public void testFindNext_valid_key_1() throws Exception{
        assertEquals(bst.findNext(4), 5);
    }

    @Test
    public void testFindNext_valid_key_2() throws Exception{
        assertEquals(bst.findNext(0), 1);
    }

    @Test (expected = NullPointerException.class)
    public void testFindNext_valid_key_3 () throws Exception{
       bst.findNext(7);
    }
}
