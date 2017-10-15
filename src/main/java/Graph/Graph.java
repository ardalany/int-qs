/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import LinkedList.*;
import Queue.Queue;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * This is a directed graph where each node has a unique value
 * @author Ardalan
 */
public class Graph<T> {
    private final HashMap<T, LinkedList<Vertex<T>>> adjacencyList;
    
    public Graph(){
        adjacencyList = new HashMap<>();
    }
    
    public void addEdge(Vertex<T> from, Vertex<T> to){
        LinkedList<Vertex<T>> fromVertex = adjacencyList.get(from.data);
        
        if(fromVertex == null){
            fromVertex = new LinkedList<>(from);
            adjacencyList.put(from.data, fromVertex);
        }
        
        fromVertex.appendToTail(to);
    }
    
    public LinkedListNode<Vertex<T>> getAdjacentVertices(T vertexData){
        LinkedList<Vertex<T>> vertex = adjacencyList.get(vertexData);
        
        if(vertex != null){
            return vertex.head.next;
        }
        
        return null;
    }
    
    public boolean hasRoute(T from, T to){
        boolean routeFound = false;
        LinkedList<Vertex<T>> fromVertex = adjacencyList.get(from);
        
        if(fromVertex != null){
            Queue<Vertex<T>> verticesToVisit = new Queue<>();
            verticesToVisit.enqueue(fromVertex.head.data);
            
            while(!verticesToVisit.isEmpty() && !routeFound){
                Vertex<T> currentVertex = verticesToVisit.dequeue();
                
                if(currentVertex.data == to){
                    routeFound = true;
                } else {
                    currentVertex.visited = true;
                    
                    LinkedListNode<Vertex<T>> adjacentVertex = getAdjacentVertices(currentVertex.data);
                    
                    while(adjacentVertex != null){
                        if(!adjacentVertex.data.visited) {
                            verticesToVisit.enqueue(adjacentVertex.data);
                        }
                        
                        adjacentVertex = adjacentVertex.next;
                    }
                }
            }
        }
        
        return routeFound;
    }
    
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        
        for(LinkedList<Vertex<T>> vertice : adjacencyList.values()){
            LinkedListNode<Vertex<T>> node = vertice.head;
            ArrayList<String> vertices = new ArrayList<>();
            while(node != null){
                vertices.add(node.data.data.toString());
                node = node.next;
            }
            
            output.append(String.join(",", vertices)).append(" - ");
        }
        
        return output.toString();
    }
}
