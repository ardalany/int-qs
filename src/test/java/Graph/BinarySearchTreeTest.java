package Graph;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ardal
 */
public class BinarySearchTreeTest {
    @Test
    public void insert_adds_node_less_than_root(){
        // Set up
        BinarySearchTree sut = TestDataCreator.createTestBST();
        
        // Execute
        sut.insert(8);
        
        // Assert
        BinaryTreeTraverse<Integer> traverse = new BinaryTreeTraverse<>();
        String nodesList = traverse.traverseInOrder(sut).toString();
        
        assertEquals("[4, 6, 7, 8, 10, 15, 21]", nodesList);
    }
}
