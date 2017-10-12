/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Queue.Queue;
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
    
    public ArrayList<T> dfs(BinaryTree<T> tree){
        _nodeList = new ArrayList<>();
        
        dfs(tree.root);
        
        return _nodeList;
    }
    
    private void dfs(BinaryTreeNode<T> node){
        _nodeList.add(node.data);
        
        if(node.getLeft() != null){
            dfs(node.getLeft());
        }
        
        if(node.getRight() != null) {
            dfs(node.getRight());
        }
    }
    
    public ArrayList<T> bfs(BinaryTree<T> tree){
        _nodeList = new ArrayList<>();
        Queue<BinaryTreeNode<T>> nodesToVisit = new Queue<>();
        
        //_nodeList.add(tree.root.data);
        //tree.root.setVisited(true);
        
        nodesToVisit.enqueue(tree.root);
        
        while(!nodesToVisit.isEmpty()){
            BinaryTreeNode<T> node = nodesToVisit.dequeue();
            
            if(!node.isVisited()){
                _nodeList.add(node.data);
                node.setVisited(true);
                
                BinaryTreeNode<T> leftChildNode = node.getLeft();
                BinaryTreeNode<T> rightChildNode = node.getRight();
                
                if(leftChildNode != null){
                    nodesToVisit.enqueue(leftChildNode);
                }
                
                if(rightChildNode != null){
                    nodesToVisit.enqueue(rightChildNode);
                }
            }
        }
        
        return _nodeList;
    }
}

