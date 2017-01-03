/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ardalan
 */
public class StackWithMinTest {
    @Test
    public void getMinimum_returns_min(){
        // Set up
        StackWithMin stack = new StackWithMin();
        stack.push(10);
        stack.push(8);
        stack.push(6);
        stack.push(7);
        
        // Execute
        Integer result = stack.getMinimum();
        
        // Assert
        assertNotNull(result);
        assertEquals(6, result.intValue());
    }
    
    @Test
    public void getMinimum_returns_min_after_a_smaller_value_is_popped(){
        // Set up
        StackWithMin stack = new StackWithMin();
        stack.push(10);
        stack.push(6);
        stack.push(8);
        stack.push(5);
        stack.push(7); // the min is 5
        
        stack.pop(); // the min is still 5
        stack.pop(); // the min is 6
        
        // Execute
        Integer result = stack.getMinimum();
        
        // Assert
        assertNotNull(result);
        assertEquals(6, result.intValue());
    }
}
