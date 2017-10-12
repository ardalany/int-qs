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
public class BinaryTreeNodeHeightGetter<T> {
    public int getHeight(BinaryTreeNode<T> root){
        int height = 0;

        if(root != null && !root.getChildren().isEmpty()){
            height = 1;
            
            int leftSubTreeHeight = getHeight(root.getLeft());
            int rightSubTreeHeight = getHeight(root.getRight());

            height += Math.max(leftSubTreeHeight, rightSubTreeHeight);
        }
        
        return height;
    }
}
