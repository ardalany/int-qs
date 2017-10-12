/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author ardal
 */
public class BinaryTreeSearchTest {
    @Test
    public void dfs_prints_all_nodes_in_depth_first_order() {
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.traverseInOrder(tree);
        
        // Assert
        assertEquals(6, results.size());
    }
}
