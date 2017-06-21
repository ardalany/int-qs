/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

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
        BinaryTree<Integer> tree = createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.traverseInOrder(tree);
        
        // Assert
        assertEquals(6, results.size());
    }
    
    @Test
    public void traverseInOrder_does_inorder_traversal() {
        // Set up
        BinaryTree<Integer> tree = createTestTree();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        ArrayList<Integer> results = sut.traverseInOrder(tree);
        
        // Assert
        assertEquals("[2, 3, 5, 5, 7, 8]", results.toString());
        
    }

    private BinaryTree<Integer> createTestTree() {
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

        // Node 8
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>();
        node8.data = 8;

        // Node 7
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node7.data = 7;
        node7.setRight(node8);

        tree.root.setRight(node7);

        return tree;
    }
}
