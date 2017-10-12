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
        
        // Execute
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);
        
        // Assert
        String result = graph.toString();
        assertEquals("1,2,3 - 2,1,4 - 3,1 - 4,2 - ", result);
    }
    
    @Test
    public void getAdjacentVertices_retuns_adjacent_vertices(){
        // Set up
        Graph<Integer> graph = new Graph<>();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);
        
        // Execute
        LinkedListNode<Integer> result = graph.getAdjacentVertices(2);
        
        // Assert
        assertNotNull(result);
        assertEquals(1, (int)result.data);
        assertNotNull(result.next);
        assertEquals(4, (int)result.next.data);
    }
}
