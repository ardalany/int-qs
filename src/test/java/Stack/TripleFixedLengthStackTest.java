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
    /*@TestWith({
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
    }*/
    
    @TestWith({
        "2, 1,   3",
        "3, 5,   8"
    })
    public void should_add_numbers(int addend1, int addend2, int result) {

        assertEquals(result, addend1 + addend2);
    }
}
