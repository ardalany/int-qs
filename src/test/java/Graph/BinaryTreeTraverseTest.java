/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import LinkedList.LinkedList;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Ardalan
 */
public class BinaryTreeTraverseTest {

    @Test
    public void traverseInOrder_traverses_all_tree_nodes() {
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.traverseInOrder(tree);
        
        // Assert
        assertEquals(6, results.size());
    }
    
    @Test
    public void traverseInOrder_does_inorder_traversal() {
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.traverseInOrder(tree);
        
        // Assert
        assertEquals("[2, 3, 5, 5, 7, 8]", results.toString());
    }

    @Test
    public void dfs_does_depth_first_traverse(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.dfs(tree);
        
        // Assert
        assertEquals("[5, 3, 2, 5, 7, 8]", results.toString());
    }
    
    @Test
    public void bfs_does_depth_first_traverse(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.bfs(tree);
        
        // Assert
        assertEquals("[5, 3, 7, 2, 5, 8]", results.toString());
    }
    
}
