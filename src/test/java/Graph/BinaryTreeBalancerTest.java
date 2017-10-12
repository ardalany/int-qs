/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ardal
 */
public class BinaryTreeBalancerTest {
    @Test
    public void isBalanced_returns_false_with_an_unbalanced_tree(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestUnbalancedTree();
        BinaryTreeBalancer<Integer> sut = new BinaryTreeBalancer<>();
        
        // Execute
        boolean result = sut.isBalanced(tree);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void isBalanced_returns_true_with_a_balanced_tree(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeBalancer<Integer> sut = new BinaryTreeBalancer<>();
        
        // Execute
        boolean result = sut.isBalanced(tree);
        
        // Assert
        assertTrue(result);
    }
}
