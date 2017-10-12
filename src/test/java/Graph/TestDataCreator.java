/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author ardal
 */
public class TestDataCreator {
    public static BinaryTree<Integer> createTestTree() {
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
    
    public static BinaryTree<Integer> createTestUnbalancedTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root.data = 1;

        // Node 2
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        node2.data = 2;

        // Node 3
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        node3.data = 3;
        
        tree.root.setLeft(node2);
        tree.root.setRight(node3);

        // Node 4
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node4.data = 4;

        // Node 5
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>();
        node5.data = 5;
        
        node4.setLeft(node5);

        node2.setLeft(node4);

        return tree;
    }
}
