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
public class BinaryTreeBalancer<T> {
    public boolean isBalanced(BinaryTree<T> tree){
        return checkHeight(tree.root) != -1;
    }
    
    // Performance: O(n^2)
    private boolean isBalanced(BinaryTreeNode<T> node){
        if(node == null)
            return true;
        
        BinaryTreeNodeHeightGetter<T> heightGetter = new BinaryTreeNodeHeightGetter<>();
        
        int leftSubTreeHeight = heightGetter.getHeight(node.getLeft());
        int rightSubTreeHeight = heightGetter.getHeight(node.getRight());
        
        if( Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1){
            return false;
        } else{
            return isBalanced(node.getLeft()) && isBalanced(node.getRight());
        }
    }
    
    // Performance: O(n)
    private int checkHeight(BinaryTreeNode<T> node){
        if(node == null)
            return 0;
        
        int leftSubTreeHeight = checkHeight(node.getLeft());
        if(leftSubTreeHeight == -1){
            return -1; // -1 means the sub tree is unbalanced
        }
        
        int rightSubTreeHeight = checkHeight(node.getRight());
        if(rightSubTreeHeight == -1){
            return -1;
        }
        
        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1){
            return -1;
        }
        else{
            return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
        }
    }
}
