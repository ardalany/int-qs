/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Ardalan
 */
public class BinaryTree<T> {
    public final BinaryTreeNode<T> root;
    
    public BinaryTree(){
        root = new BinaryTreeNode();
        root.parent = null;
    }
    
    public int getHeight(){
        return new BinaryTreeNodeHeightGetter<T>().getHeight(root);
    }
}
