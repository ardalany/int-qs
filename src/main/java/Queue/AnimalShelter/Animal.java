/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.AnimalShelter;

import java.time.*;

/**
 *
 * @author Ardalan
 */
public abstract class Animal {
    private LocalDateTime _arrivalTime;
   
    
    public LocalDateTime getArrivalTime(){
        return _arrivalTime;
    }
    
    public void setArrivalTime(LocalDateTime dateTime){
        _arrivalTime = dateTime;
    }
}
