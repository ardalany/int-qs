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
public class StackSorterTest {
    @Test
    public void SortAscending_sorts_a_stack_in_ascending_order(){
        // Set up
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.push(2);
        
        StackSorter sut=new StackSorter();
        
        // Execute
        Stack<Integer> result = sut.SortAscending(stack);
        
        // Assert
        assertEquals("8,7,5,4,2", result.toString());
    }
}
