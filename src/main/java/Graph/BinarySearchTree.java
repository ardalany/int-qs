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
public class BinarySearchTree extends BinaryTree<Integer> {
    public void insert(int value){
        if(root.data == null){ // empty tree
            root.data = value;
        }
        else {
            BinaryTreeNode<Integer> currentNode = root;
            BinaryTreeNode<Integer> parentNode = null;
            
            while(currentNode != null){
                parentNode = currentNode;
                
                if(value <= currentNode.data) {
                    currentNode = currentNode.getLeft();
                }
                else {
                    currentNode = currentNode.getRight();
                }
            }
            
            if(value <= parentNode.data){
                parentNode.setLeft(new BinaryTreeNode(value));
            }
            else {
                parentNode.setRight(new BinaryTreeNode(value));
            }
        }
    }
}
