/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import LinkedList.LinkedList;
import Queue.Queue;
import java.util.ArrayList;
import java.util.HashSet;

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
    
    /**
     * Returns the next node in the in-order traversal, or null if it is the last node
     * of the traversal.
     * @param node
     * @return 
     */
    public BinaryTreeNode<T> getNextInOrderNode(BinaryTreeNode<T> node) {
        if(node != null) {
            BinaryTreeNode<T> rightChild = node.getRight();

            if(rightChild != null) {
                BinaryTreeNode<T> leftMostChild = rightChild;

                while(leftMostChild.getLeft() != null) {
                    leftMostChild = leftMostChild.getLeft();
                }

                return leftMostChild;
            } else {
                BinaryTreeNode<T> currentNode = node.parent;

                while(currentNode!= null) {
                    if (currentNode.parent != null && currentNode.parent.getLeft() == currentNode) {
                        return currentNode.parent;
                    }

                    currentNode = currentNode.parent;
                }

                return currentNode;
            }
        }
        
        return null;
    }
    
    /**
     * 
     * @param node1
     * @param node2
     * @return null if no common ancestor is found
     */
    public BinaryTreeNode<T> findLCA(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2){
        // if a node is root, it will be the ancestor
        if(node1.parent == null) {
            return node1;
        } 
        
        if(node2.parent == null) {
            return node2;
        }
        
        HashSet<BinaryTreeNode<T>> ancestors = new HashSet<>();
        
        // Get all the ancestors of node1 all the way to the root
        BinaryTreeNode<T> currentNode = node1;
        while(currentNode != null) {
            ancestors.add(currentNode);
            
            currentNode = currentNode.parent;
        }
        
        // Go through the ancestors of node2 from the node to the root.
        // The first node that is found in node1's ancestors is their lowest common ancestor
        currentNode = node2;
        while(currentNode != null){
            if(ancestors.contains(currentNode)) {
                return currentNode;
            }
            
            currentNode = currentNode.parent;
        }
        
        return null;
    }
    
    /**
     * This method checks if node1 and node2 are in the same subtree of root.
     * This algorithm is for when we cannot access parents from a given node.
     * @param node1
     * @param node2
     * @param root
     * @return 
     */
    public BinaryTreeNode<T> findLCAByRoot(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2, BinaryTreeNode<T> root) {
        if(node1 == root) {
            return node1;
        }
        
        if(node2 == root) {
            return node2;
        }
        
        boolean isNode1ALeftDescendant = isDescendant(root.getLeft(), node1);
        boolean isNode2ALeftDescendant = isDescendant(root.getLeft(), node2);
        
        // The root is the LCA when one node is in the left sub tree and the other in the right sub tree
        if(isNode1ALeftDescendant != isNode2ALeftDescendant) {
            return root;
        }
        
        if(isNode1ALeftDescendant) {
            return findLCAByRoot(node1, node2, root.getLeft());
        }
        else{
            return findLCAByRoot(node1,node2,root.getRight());
        }
    }
    
    public boolean isDescendant(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
        // we've reached a leaf - the node is not a descendant.
        if(root == null) {
            return false;
        }
        
        if(root == node) {
            return true;
        }
        
        return isDescendant(root.getLeft(), node) || isDescendant(root.getRight(), node);
    }
}

