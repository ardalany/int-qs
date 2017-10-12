/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author ardal
 */
public class BinaryTreeTest {
    @Test
    public void getHeight_returns_zero_when_tree_has_one_node(){
        // Set up
        BinaryTree<Integer> sut = new BinaryTree<>();
        
        // Execute
        int height = sut.getHeight();
        
        // Assert
        assertEquals(0, height);
    }
    
    @Test
    public void getHeight_returns_correct_height(){
        // Set up
        BinaryTree<Integer> sut = new BinaryTree<>();
        sut.root.data = 5;

        // Node 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        node2.data = 2;

        // Node 3
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        node3.data = 3;
        node3.setLeft(node2);

        sut.root.setLeft(node3);

        // Node 7
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node7.data = 7;

        sut.root.setRight(node7);
        
        // Execute
        int height = sut.getHeight();
        
        // Assert
        assertEquals(2, height);
    }
}
