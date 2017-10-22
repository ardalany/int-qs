package Graph;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ardal
 */
public class BinarySearchTreeValidatorTest {
    @Test
    public void isBinarySearchTree_returns_true_with_binary_Search_tree(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestBST();
        BinarySearchTreeValidator sut = new BinarySearchTreeValidator();
        
        // Execute
        boolean result = sut.isBinarySearchTree(tree);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void isBinarySearchTree_returns_false_with_a_binary_tree_with_a_left_non_bst_sub_tree(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestBinaryTree();
        BinarySearchTreeValidator sut = new BinarySearchTreeValidator();
        
        // Execute
        boolean result = sut.isBinarySearchTree(tree);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void isBinarySearchTree_returns_false_with_a_binary_tree_with_a_right_non_bst_sub_tree(){
        // Set up
        BinaryTree<Integer> tree = createTestBinaryTreeWithNonBSTRightSubTree();
        BinarySearchTreeValidator sut = new BinarySearchTreeValidator();
        
        // Execute
        boolean result = sut.isBinarySearchTree(tree);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void isBinarySearchTree_returns_true_with_an_empty_binary_tree(){
        // Set up
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = null;
        BinarySearchTreeValidator sut = new BinarySearchTreeValidator();
        
        // Execute
        boolean result = sut.isBinarySearchTree(tree);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void isBinarySearchTree_returns_true_with_a_single_node_binary_tree(){
        // Set up
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root.data = 1;
        BinarySearchTreeValidator sut = new BinarySearchTreeValidator();
        
        // Execute
        boolean result = sut.isBinarySearchTree(tree);
        
        // Assert
        assertTrue(result);
    }
    
    private BinaryTree<Integer> createTestBinaryTreeWithNonBSTRightSubTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root.data = 5;

        // Node 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        node2.data = 2;

        // Node 5
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>();
        node5.data = 5;

        // Node 3
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        node3.data = 3;
        node3.setLeft(node2);
        node3.setRight(node5);

        tree.root.setLeft(node3);

        // Node 4
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node4.data = 4;

        // Node 7
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node7.data = 7;
        node7.setRight(node4);

        tree.root.setRight(node7);

        return tree;
    } 
}
