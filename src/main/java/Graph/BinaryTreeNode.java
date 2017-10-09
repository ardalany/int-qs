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
public class BinaryTreeNode<T> {

    public BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> _left;
    private BinaryTreeNode<T> _right;
    public T data;
    private boolean _visited = false;

    public BinaryTreeNode<T> getLeft() {
        return _left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        _left = left;

        if (left != null) {
            left.parent = this;
        }
    }

    public BinaryTreeNode<T> getRight() {
        return _right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        _right = right;

        if (right != null) {
            right.parent = this;
        }
    }
    
    public boolean isVisited(){
        return _visited;
    }
    
    public void setVisited(boolean value){
        _visited = value;
    }
    
    public ArrayList<BinaryTreeNode<T>> getChildren(){
        ArrayList<BinaryTreeNode<T>> children = new ArrayList<>();
        
        if(_left != null){
            children.add(_left);
        }
        
        if(_right != null){
            children.add(_right);
        }
        
        return children;
    }
}
