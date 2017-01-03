/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;


/**
 * This class creates three stacks of the same length, using a single array.
 * @author Ardalan
 */
public class TripleFixedLengthStack {
    private final String[] _stacks;
    
    /**
     * The indices of the stacks' top nodes
     */
    private final int[] _stackTops;
    
    private final int _stackSize;
    
    /**
     * 
     * @param stackSize The size of each stack
     */
    public TripleFixedLengthStack(int stackSize){
        _stackSize = stackSize;
        
        _stacks = new String[3 * _stackSize];
        
        _stackTops = new int[]{ -1, _stackSize - 1, (2 * _stackSize) - 1 };
    }
    
    /**
     * 
     * @param value the value to be added to a stack
     * @param stackID which stack should the value be pushed to? 1, 2, or 3.
     * @return returns false if the stack is full.
     */
    public boolean push(String value, int stackID){
        if(stackID > 3 || stackID < 1){
            throw new IllegalArgumentException("stackID must be 1, 2, or 3. Actual value: " + String.valueOf(stackID));
        }
        
        // is the stack full?
        if(_stackTops[stackID - 1] == ((stackID * _stackSize) - 1)){
            return false;
        }
        else{
            _stackTops[stackID - 1]++;
            _stacks[_stackTops[stackID - 1]] = value;

            return true;
        }
    }
    
    /**
     * 
     * @param stackID which stack should the value be popped from? 1, 2, or 3.
     * @return returns null if the stack is empty.
     */
    public String pop(int stackID){
        if(stackID > 3 || stackID < 1){
            throw new IllegalArgumentException("stackID must be 1, 2, or 3. Actual value: " + String.valueOf(stackID));
        }
        

        // is the stack empty?
        if(_stackTops[stackID - 1] == ((stackID - 1) * _stackSize) - 1){
            return null;
        }
        else
        {
            String value = _stacks[_stackTops[stackID - 1]];
            _stacks[_stackTops[stackID - 1]] = null;
            _stackTops[stackID - 1]--;
            return value;
        }
    }
}
