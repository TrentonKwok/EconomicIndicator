import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTest {

    @Test
    public void testGet(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");
        assertEquals("one", tree.get(1));
        assertEquals("two", tree.get(2));
        assertEquals("three", tree.get(3));
    }

    @Test
    public void testGetNonExistent(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(1, "a");
        assertNull(tree.get(99));
    }

    @Test
    public void testSize(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        assertEquals(0, tree.size());
        tree.put(1, "a");
        tree.put(2, "b");
        assertEquals(2, tree.size());
    }

    @Test
    public void testIsEmpty(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        assertTrue(tree.isEmpty());
        tree.put(1, "a");
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testNoRepeat(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(1, "one");
        tree.put(1, "ONE");
        assertEquals("ONE", tree.get(1));
        assertEquals(1, tree.size());
    }

    @Test
    public void testContains(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(1, "a");
        assertTrue(tree.contains(1));
        assertFalse(tree.contains(99));
    }

    @Test
    public void testMinAndMax(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(3, "c");
        tree.put(1, "a");
        tree.put(5, "e");
        assertEquals(1, (int)tree.min());
        assertEquals(5, (int)tree.max());
    }

    @Test
    public void testMinMaxEmpty(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        assertNull(tree.min());
        assertNull(tree.max());
    }

    @Test
    public void testLLRotation(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(30, "c");
        tree.put(20, "b");
        tree.put(10, "a");
        assertEquals(2, tree.height());
        assertEquals(3, tree.size());
        assertEquals("a", tree.get(10));
        assertEquals("b", tree.get(20));
        assertEquals("c", tree.get(30));
    }

    @Test
    public void testRRRotation(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(10, "a");
        tree.put(20, "b");
        tree.put(30, "c");
        assertEquals(2, tree.height());
        assertEquals(3, tree.size());
        assertEquals("a", tree.get(10));
        assertEquals("b", tree.get(20));
        assertEquals("c", tree.get(30));
    }

    @Test
    public void testLRRotation(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(30, "c");
        tree.put(10, "a");
        tree.put(20, "b");
        assertEquals(2, tree.height());
        assertEquals("a", tree.get(10));
        assertEquals("b", tree.get(20));
        assertEquals("c", tree.get(30));
    }

    @Test
    public void testRLRotation(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(10, "a");
        tree.put(30, "c");
        tree.put(20, "b");
        assertEquals(2, tree.height());
        assertEquals("a", tree.get(10));
        assertEquals("b", tree.get(20));
        assertEquals("c", tree.get(30));
    }

    @Test
    public void testDeleteLeaf(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(2, "b");
        tree.put(1, "a");
        tree.put(3, "c");
        tree.delete(1);
        assertNull(tree.get(1));
        assertEquals(2, tree.size());
        assertEquals("b", tree.get(2));
        assertEquals("c", tree.get(3));
    }

    @Test
    public void testDeleteNodeWithOneChild(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(2, "b");
        tree.put(1, "a");
        tree.put(3, "c");
        tree.put(4, "d");
        tree.delete(3);
        assertNull(tree.get(3));
        assertEquals(3, tree.size());
        assertEquals("d", tree.get(4));
    }

    @Test
    public void testDeleteNodeWithTwoChildren(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(2, "b");
        tree.put(1, "a");
        tree.put(4, "d");
        tree.put(3, "c");
        tree.put(5, "e");
        tree.delete(4);
        assertNull(tree.get(4));
        assertEquals(4, tree.size());
        assertEquals("c", tree.get(3));
        assertEquals("e", tree.get(5));
    }

    @Test
    public void testDeleteNonExistent(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(1, "a");
        tree.put(2, "b");
        tree.delete(99);
        assertEquals(2, tree.size());
        assertEquals("a", tree.get(1));
        assertEquals("b", tree.get(2));
    }

    @Test
    public void testDeleteLLRebalance(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(20, "a");
        tree.put(10, "b");
        tree.put(30, "c");
        tree.put(5, "d");

        tree.delete(30);
        assertEquals(3, tree.size());
        assertEquals(2, tree.height());
        assertEquals("b", tree.get(10));
        assertEquals("d", tree.get(5));
        assertEquals("a", tree.get(20));
    }

    @Test
    public void testDeleteRRRebalance(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(20, "a");
        tree.put(10, "b");
        tree.put(30, "c");
        tree.put(40, "d");
        tree.delete(10);
        assertEquals(2, tree.height());
        assertEquals(3, tree.size());
    }

    @Test
    public void testDeleteLRRebalance(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(20, "a");
        tree.put(10, "b");
        tree.put(30, "c");
        tree.put(15, "d");
        tree.delete(30);
        assertEquals(2, tree.height());
        assertEquals(3, tree.size());
    }

    @Test
    public void testDeleteRLRebalance(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(20, "a");
        tree.put(10, "b");
        tree.put(30, "c");
        tree.put(25, "d");
        tree.delete(10);
        assertEquals(2, tree.height());
        assertEquals(3, tree.size());
    }

    @Test
    public void testDeleteAll(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");
        tree.delete(1);
        tree.delete(2);
        tree.delete(3);
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.height());
    }

    @Test
    public void testRandomInsertCheck(){
        AVLTree<Integer, Integer> tree = new AVLTree<Integer, Integer>();
        java.util.Random random = new java.util.Random(42);
        int n = 1000;
        for(int i = 0; i < n; i++){
            int key = random.nextInt(10000);
            tree.put(key, key);
        }
        double maxHeight = 1.44 * (Math.log(tree.size() + 2) / Math.log(2));
        assertTrue(tree.height() <= maxHeight);
    }

    @Test
    public void testSequentialInsertCheck(){
        AVLTree<Integer, Integer> tree = new AVLTree<Integer, Integer>();
        for(int i = 1; i <= 1000; i++){
            tree.put(i, i);
        }
        double maxHeight = 1.44 * (Math.log(tree.size() + 2) / Math.log(2));
        assertTrue(tree.height() <= maxHeight);
        assertEquals(1000, tree.size());
    }

    @Test
    public void testIteratorOrder(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        tree.put(3, "c");
        tree.put(1, "a");
        tree.put(5, "e");
        tree.put(2, "b");
        tree.put(4, "d");

        String result = "";
        for(String value : tree){
            result = result + value;
        }
        assertEquals("abcde", result);
    }

    @Test
    public void testIteratorSize(){
        AVLTree<Integer, String> tree = new AVLTree<Integer, String>();
        int count = 0;
        for(String value : tree){
            count++;
        }
        assertEquals(0, count);
    }
}