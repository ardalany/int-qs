/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;





/**
 *
 * @author Ardalan
 */
@RunWith(ZohhakRunner.class)
public class TripleFixedLengthStackTest {
    @TestWith({
        "1",
        "2",
        "3"
    })
    public void push_returns_true_when_an_item_is_pushed_to_stack(int stackID){
        // Set up
        TripleFixedLengthStack stack=new TripleFixedLengthStack(1);
        
        // Execute
        boolean result = stack.push("a", stackID);
        
        // Assert
        assertTrue(result);
    }
    
    @TestWith({
        "1",
        "2",
        "3"
    })
    public void push_returns_false_a_stack_is_full(int stackID){
        // Set up
        TripleFixedLengthStack stack=new TripleFixedLengthStack(2);
        stack.push("a", stackID);
        stack.push("b", stackID);
        
        // Execute
        boolean result = stack.push("c", stackID);
        
        // Assert
        assertFalse(result);
    }
    
    @TestWith({
        "1",
        "2",
        "3"
    })
    public void pop_returns_top_node(int stackID){
        // Set up
        TripleFixedLengthStack stack=new TripleFixedLengthStack(2);
        stack.push("a", stackID);
        stack.push("b", stackID);
        
        // Execute
        String node1 = stack.pop(stackID);
        String node2 = stack.pop(stackID);
        
        // Assert
        assertEquals("b", node1);
        assertEquals("a", node2);
    }
    
    @TestWith({
        "1",
        "2",
        "3"
    })
    public void pop_returns_null_when_stack_is_empty(int stackID){
        // Set up
        TripleFixedLengthStack stack=new TripleFixedLengthStack(2);
        
        // Execute
        String node = stack.pop(stackID);
        
        // Assert
        assertEquals(null, node);
    }
    
    @TestWith({
        "1",
        "2",
        "3"
    })
    public void pop_returns_null_when_all_elements_are_popped(int stackID){
        // Set up
        TripleFixedLengthStack stack=new TripleFixedLengthStack(2);
        stack.push("a", stackID);
        stack.push("b", stackID);
        stack.pop(stackID);
        stack.pop(stackID);
        
        // Execute
        String node = stack.pop(stackID);
        
        // Assert
        assertEquals(null, node);
    }
}
