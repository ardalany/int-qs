/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.*;

/**
 *
 * @author Ardalan
 */
public class HanoiTower {
    private ArrayList<Stack<Integer>> _stacks;
    
    public HanoiTower(){
        _stacks = new ArrayList<>();
        _stacks.add(new Stack<>());
        _stacks.add(new Stack<>());
        _stacks.add(new Stack<>());
    }
    
    /**
     * Adds a disc to the first tower.
     * @param disc Identify discs as integers.
     */
    public void addToTower1(int disc){
     _stacks.get(0).push(disc);
    }
    
    /**
     * Moves all the discs from tower 1 to tower 3. 
     * Call addToTower1() before this method.
     */
    public void moveToTower3(){
        moveDiscs(_stacks.get(0).getCount(), 1, 3, 2);
    }
    
    /**
     * Returns the requested tower as a stack of integers.
     * @param i 1, 2, or 3
     * @return 
     */
    public Stack<Integer> getTower(int i){
        return _stacks.get(i-1);
    }
    
    
    /**
     * Moves a number of discs from one tower to another, using a middle tower.
     * @param numOfDiscs Number of discs to move
     * @param from source tower (1, 2, or 3)
     * @param to destination tower (1, 2, or 3)
     * @param using middle tower for help (1, 2, or 3)
     */
    private void moveDiscs(int numOfDiscs, int from, int to, int using){
        if(numOfDiscs == 1){
            int disc = _stacks.get(from - 1).pop();
            _stacks.get(to - 1).push(disc);
        }
        else{
            moveDiscs(numOfDiscs - 1, from, using, to);
            moveDiscs(1, from, to, using);
            moveDiscs(numOfDiscs - 1, using, to, from);
        }
    }
}
