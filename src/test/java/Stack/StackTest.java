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
public class StackTest {
    @Test
    public void toString_returns_comma_delimited_values_of_stack_nodes(){
        // Set up
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Execute
        String result = stack.toString();
        
        // Assert
        assertEquals("3,2,1", result);
    }
    
    @Test
    public void getCount_returns_correct_count(){
        // Set up
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Execute
        int count = stack.getCount();
        
        // Assert
        assertEquals(3, count);
    }
}
