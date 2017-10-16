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
    
    @Test
    public void getNodesPerDepth_returns_a_linked_list_per_depth(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<LinkedList<Integer>> result = sut.getNodesPerDepth(tree);
        
        // Assert
        assertEquals(3, result.size());
    }
    
    @Test
    public void getNodesPerDepth_returns_a_linked_list_containing_all_nodes_of_the_same_depth(){
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<LinkedList<Integer>> result = sut.getNodesPerDepth(tree);
        
        // Assert
        assertEquals(5, (int)result.get(0).head.data);
        assertNull(result.get(0).head.next);
        
        assertEquals(3, (int)result.get(1).head.data);
        assertEquals(7, (int)result.get(1).head.next.data);
        assertNull(result.get(1).head.next.next);
        
        assertEquals(2, (int)result.get(2).head.data);
        assertEquals(5, (int)result.get(2).head.next.data);
        assertEquals(8, (int)result.get(2).head.next.next.data);
        assertNull(result.get(1).head.next.next.next);
    }
}
