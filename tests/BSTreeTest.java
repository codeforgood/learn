/**
 * Created with IntelliJ IDEA.
 * User: sravi
 * Date: 10/13/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
import com.sravi.tree.BSTree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BSTreeTest {

    static BSTree bst;

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
    public void checkRoot() {
        assertEquals(bst.getRoot().getVal(), 1);
    }

    @Test
    public void isBSTree(){
        assertTrue(bst.isBST());
    }

    @Test
    public void findNode(){
        assertEquals(bst.find(9), false);
        assertEquals(bst.find(1), true);
        assertEquals(bst.find(7), true);
        assertEquals(bst.find(8), false);
    }
}