package Graph;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ardal
 */
public class BinarySearchTreeDataInserterTest {

    @Test
    public void insert_returns_a_bst_with_minimal_height_with_an_array_of_odd_size() {
        // Set up
        int[] values = new int[] {1, 2, 3, 4, 5, 6, 7};
        BinarySearchTreeDataInserter sut = new BinarySearchTreeDataInserter();
        
        // Execute
        BinarySearchTree result = sut.insert(values);
        
        // Assert
        assertEquals(2, result.getHeight());
        
        BinaryTreeTraverse<Integer> traverse = new BinaryTreeTraverse<>();
        String nodesList = traverse.traverseInOrder(result).toString();
        
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", nodesList);
    }

    @Test
    public void insert_returns_a_bst_with_minimal_height_with_an_array_of_even_size() {
        // Set up
        int[] values = new int[] {1, 2, 3, 4, 5, 6};
        BinarySearchTreeDataInserter sut = new BinarySearchTreeDataInserter();
        
        // Execute
        BinarySearchTree result = sut.insert(values);
        
        // Assert
        assertEquals(2, result.getHeight());
        
        BinaryTreeTraverse<Integer> traverse = new BinaryTreeTraverse<>();
        String nodesList = traverse.traverseInOrder(result).toString();
        
        assertEquals("[1, 2, 3, 4, 5, 6]", nodesList);
    }
}
