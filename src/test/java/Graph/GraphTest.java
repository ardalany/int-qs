/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import LinkedList.LinkedListNode;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ardalan
 */
public class GraphTest {
    @Test
    public void addEdge_adds_edges_to_a_graph(){
        // Set up
        Graph<Integer> graph=new Graph<>();
        Vertex<Integer> vertice1 = new Vertex(1);
        Vertex<Integer> vertice2 = new Vertex(2);
        Vertex<Integer> vertice3 = new Vertex(3);
        Vertex<Integer> vertice4 = new Vertex(4);
        
        // Execute
        graph.addEdge(vertice1, vertice2);
        graph.addEdge(vertice1, vertice3);
        graph.addEdge(vertice2, vertice1);
        graph.addEdge(vertice3, vertice1);
        graph.addEdge(vertice2, vertice4);
        graph.addEdge(vertice4, vertice2);
        
        // Assert
        String result = graph.toString();
        assertEquals("1,2,3 - 2,1,4 - 3,1 - 4,2 - ", result);
    }
    
    @Test
    public void getAdjacentVertices_retuns_adjacent_vertices(){
        // Set up
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> vertice1 = new Vertex(1);
        Vertex<Integer> vertice2 = new Vertex(2);
        Vertex<Integer> vertice3 = new Vertex(3);
        Vertex<Integer> vertice4 = new Vertex(4);

        graph.addEdge(vertice1, vertice2);
        graph.addEdge(vertice1, vertice3);
        graph.addEdge(vertice2, vertice1);
        graph.addEdge(vertice3, vertice1);
        graph.addEdge(vertice2, vertice4);
        graph.addEdge(vertice4, vertice2);
        
        // Execute
        LinkedListNode<Vertex<Integer>> result = graph.getAdjacentVertices(2);
        
        // Assert
        assertNotNull(result);
        assertEquals(1, (int)result.data.data);
        assertNotNull(result.next);
        assertEquals(4, (int)result.next.data.data);
    }
    
    @Test
    public void hasRoute_returns_false_with_no_route_from_one_vertex_to_another(){
        // Set up
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> vertex1 = new Vertex(1);
        Vertex<Integer> vertex2 = new Vertex(2);
        Vertex<Integer> vertex3 = new Vertex(3);
        
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex3, vertex2);
        
        // Execute
        boolean result = graph.hasRoute(vertex1.data, vertex3.data);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void hasRoute_returns_true_with_a_route_from_one_vertex_to_another(){
        // Set up
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> vertex1 = new Vertex(1);
        Vertex<Integer> vertex2 = new Vertex(2);
        Vertex<Integer> vertex3 = new Vertex(3);
        
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex3, vertex1);
        
        // Execute
        boolean result = graph.hasRoute(vertex1.data, vertex3.data);
        
        // Assert
        assertTrue(result);
    }
}
