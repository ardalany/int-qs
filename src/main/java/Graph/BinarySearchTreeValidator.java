package Graph;

import Queue.Queue;

/**
 *
 * @author ardal
 */
public class BinarySearchTreeValidator {
    /**
     * Returns true if the binary tree is a binary search tree, i.e. the root is
     * greater than or equal to its left child, and less than its right child.
     * @param binaryTree a binary tree where all the nodes have non-negative integer values.
     * @return 
     */
    public boolean isBinarySearchTree(BinaryTree<Integer> binaryTree) {
        return isBST(binaryTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBST(BinaryTreeNode<Integer> node, int min, int max) {
        if(node == null) {
            return true;
        }
        
        if(node.data <= min || node.data > max) {
            return false;
        }
        
        return (isBST(node.getLeft(), min, node.data) && isBST(node.getRight(), node.data, max));
    }
}
