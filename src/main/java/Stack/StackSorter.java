/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 * Sorts a stack
 * @author Ardalan
 */
public class StackSorter {

    private Stack<Integer> sortedStack;

    public StackSorter() {
        sortedStack = new Stack<>();
    }

    /**
     * Sorts a stack in ascending order (maximum value at the top of the stack)
     * @param stack An unsorted stack
     * @return A sorted stack in ascending order.
     */
    public Stack<Integer> SortAscending(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int top = stack.pop();

            if (sortedStack.isEmpty()) {
                sortedStack.push(top);
            } else {
                while (!sortedStack.isEmpty() && top < sortedStack.peek()) {
                    stack.push(sortedStack.pop());
                }

                sortedStack.push(top);
            }

        }

        return sortedStack;
    }
}
