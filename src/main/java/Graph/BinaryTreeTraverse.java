/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;

/**
 *
 * @author Ardalan
 */
public class BinaryTreeTraverse<T> {
    private ArrayList<T> _nodeList;
    
    public ArrayList<T> traverseInOrder(BinaryTree<T> tree){
        _nodeList = new ArrayList<>();
        
        traverseInOrder(tree.root);
        
        return _nodeList;
    }
    
    private void traverseInOrder(BinaryTreeNode<T> node){
        if(node != null) {
            traverseInOrder(node.getLeft());
            _nodeList.add(node.data);
            traverseInOrder(node.getRight());
        }
    }
}
