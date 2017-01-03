/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Ardalan
 */
public class StackWithMin extends Stack<Integer> {
    /**
     * This stack keeps track of the minimums; it only stores the values that are smaller than the firstly pushed value.
     */
    private Stack<Integer> minStack;
    
    public StackWithMin(){
        minStack=new Stack<>();
    }
    
    public void push(int value){
        Integer min = getMinimum();
        
        // no minimums so far, or all of them have been popped
        if(min == null){
            minStack.push(value);
        }else if(value <= min){
            minStack.push(value);
        }
        
        super.push(value);
    }
    
    public Integer pop(){
        Integer value = super.pop();
        Integer min = getMinimum();
        
        if(min != null && value == min.intValue()){
            minStack.pop();
        }
        
        return value;
    }
    
    public Integer getMinimum(){
        return minStack.peek();
    }
}
