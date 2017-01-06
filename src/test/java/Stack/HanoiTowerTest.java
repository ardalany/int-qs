/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Ardalan
 */
public class HanoiTowerTest {
    @Test
    public void moveToTower3_moves_discs_from_first_tower_to_third_tower(){
        // Set up
        HanoiTower hanoi= new HanoiTower();
        hanoi.addToTower1(3);
        hanoi.addToTower1(2);
        hanoi.addToTower1(1);
        
        // Execute
        hanoi.moveToTower3();
        
        // Assert
        Stack<Integer> tower1 = hanoi.getTower(1);
        assertEquals("", tower1.toString());
        
        Stack<Integer> tower2 = hanoi.getTower(1);
        assertEquals("", tower2.toString());
        
        Stack<Integer> tower3 = hanoi.getTower(3);
        assertEquals("1,2,3", tower3.toString());
    }
}
