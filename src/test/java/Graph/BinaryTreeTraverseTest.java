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
    public void getNextInOrderNode_returns_leftmost_node_in_right_subtree_when_node_has_a_right_child() {
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestBST();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        BinaryTreeNode<Integer> result = sut.getNextInOrderNode(tree.root.getLeft());
        
        // Assert
        assertEquals(7, (int)result.data);
    }
    
    @Test
    public void getNextInOrderNode_with_right_child_node_returns_parents_next_node() {
        // Set up
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.root.data = 10;
        
        BinaryTreeNode<Integer> node15 = new BinaryTreeNode<>(15);
        tree.root.setRight(node15);
        
        BinaryTreeNode<Integer> node20 = new BinaryTreeNode<>(20);
        node15.setLeft(node20);
        
        BinaryTreeNode<Integer> node21 = new BinaryTreeNode<>(21);
        node20.setLeft(node21);
        
        BinaryTreeNode<Integer> node22 = new BinaryTreeNode<>(22);
        node20.setRight(node22);
        
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        BinaryTreeNode<Integer> result = sut.getNextInOrderNode(node22);
        
        // Assert
        assertEquals(15, (int)result.data);
    }
    
    @Test
    public void getNextInOrderNode_with_rightmost_node_returns_null() {
        // Set up
        BinaryTree<Integer> tree = TestDataCreator.createTestBST();
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        BinaryTreeNode<Integer> node = tree.root.getRight().getRight();
        
        // Execute
        BinaryTreeNode<Integer> result = sut.getNextInOrderNode(node);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void findLCA_finds_lowest_common_ancestor_of_two_nodes(){
        // Set up
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        root.setRight(node2);
        
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        node2.setLeft(node3);
        
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        node3.setLeft(node4);
        node3.setRight(node5);
        
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        node4.setLeft(node6);
        
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        BinaryTreeNode<Integer> ancestor = sut.findLCA(node6, node5);
        
        // Assert
        assertEquals(node3, ancestor);
    }
    
    @Test
    public void findLCA_finds_lowest_common_ancestor_of_root_and_child(){
        // Set up
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        root.setRight(node2);
        
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        node2.setLeft(node3);
        
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        node3.setLeft(node4);
        node3.setRight(node5);
        
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        node4.setLeft(node6);
        
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        BinaryTreeNode<Integer> ancestor = sut.findLCA(node4, root);
        
        // Assert
        assertEquals(root, ancestor);
    }
    
    @Test
    public void findLCAByRoot_finds_lowest_common_ancestor_of_two_nodes(){
        // Set up
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        root.setRight(node2);
        
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        node2.setLeft(node3);
        
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        node3.setLeft(node4);
        node3.setRight(node5);
        
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        node4.setLeft(node6);
        
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        BinaryTreeNode<Integer> ancestor = sut.findLCAByRoot(node6, node5, root);
        
        // Assert
        assertEquals(node3, ancestor);
    }
    
    @Test
    public void findLCAByRoot_finds_lowest_common_ancestor_of_root_and_child(){
        // Set up
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        root.setRight(node2);
        
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        node2.setLeft(node3);
        
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        node3.setLeft(node4);
        node3.setRight(node5);
        
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        node4.setLeft(node6);
        
        BinaryTreeTraverse<Integer> sut = new BinaryTreeTraverse<>();
        
        // Execute
        BinaryTreeNode<Integer> ancestor = sut.findLCAByRoot(node4, root, root);
        
        // Assert
        assertEquals(root, ancestor);
    }
}
