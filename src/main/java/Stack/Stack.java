/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import LinkedList.LinkedListNode;
import java.util.ArrayList;

/**
 *
 * @author Ardalan
 */
public class Stack<T> {

    private LinkedListNode<T> _top;

    public void push(T value) {
        if (_top == null) {
            _top = new LinkedListNode<>(value);
        } else {
            LinkedListNode<T> newNode = new LinkedListNode<>(value);
            newNode.next = _top;
            _top = newNode;
        }
    }

    public T pop() {
        if (_top == null) {
            return null;
        } else {
            T data = _top.data;
            _top = _top.next;

            return data;
        }
    }
    
    public T peek() {
        if (_top == null) {
            return null;
        } else {
            return _top.data;
        }
    }
    
    @Override
    public String toString(){
        ArrayList<String> nodeStrings = new ArrayList<>();
        
        LinkedListNode<T> currentNode = _top;
        
        while(currentNode != null){
            nodeStrings.add(currentNode.data.toString());
            
            currentNode = currentNode.next;
        }
        
        return String.join(",", nodeStrings);
    }
    
    public int getCount(){
        int count = 0;
        
        LinkedListNode<T> currentNode = _top;
        
        while(currentNode != null){
            count++;
            
            currentNode = currentNode.next;
        }
        
        return count;
    }
}
