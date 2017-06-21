/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import LinkedList.*;
import java.util.ArrayList;

/**
 *
 * @author Ardalan
 */
public class Graph<T> {
    private final ArrayList<LinkedList<T>> adjacencyList;
    
    public Graph(){
        adjacencyList = new ArrayList<>();
    }
    
    public void addEdge(T vertice1, T vertice2){
        boolean verticeFound = false;
        int index = 0;
        
        while(index < adjacencyList.size() && !verticeFound){
            LinkedList<T> vertice = adjacencyList.get((index));
            
            if(vertice.head.data.equals(vertice1)){
                vertice.appendToTail(vertice2);
                verticeFound = true;
            }
            
            index++;
        }
        
        if(!verticeFound){
            LinkedList<T> vertice = new LinkedList<>(vertice1);
            vertice.appendToTail(vertice2);
            adjacencyList.add(vertice);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        
        for(LinkedList<T> vertice : adjacencyList){
            LinkedListNode<T> node = vertice.head;
            ArrayList<String> vertices = new ArrayList<>();
            while(node != null){
                vertices.add(node.data.toString());
                node = node.next;
            }
            
            output.append(String.join(",", vertices)).append(" - ");
        }
        
        return output.toString();
    }
}
