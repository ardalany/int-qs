/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.AnimalShelter;

import Queue.*;
import java.time.*;

/**
 *
 * @author Ardalan
 */
public class AnimalShelterQueue {

    private Queue<Dog> _dogQueue;
    private Queue<Cat> _catQueue;

    public AnimalShelterQueue() {
        _dogQueue = new Queue<>();
        _catQueue = new Queue<>();
    }

    public void enqueue(Animal animal) {
        animal.setArrivalTime(LocalDateTime.now());
        
        if (animal instanceof Cat) {
            _catQueue.enqueue((Cat) animal);
        } else if (animal instanceof Dog) {
            _dogQueue.enqueue((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (_catQueue.peek() == null) {
            return _dogQueue.dequeue();
        } else if (_dogQueue.peek() == null) {
            return _catQueue.dequeue();
        } else {
            LocalDateTime oldestCatArrivalTime = _catQueue.peek().getArrivalTime();
            LocalDateTime oldestDogArrivalTime = _dogQueue.peek().getArrivalTime();

            if (oldestCatArrivalTime.isBefore(oldestDogArrivalTime)) {
                return dequeueCat();
            } else {
                return dequeueDog();
            }
        }
    }

    public Cat dequeueCat() {
        return _catQueue.dequeue();
    }

    public Dog dequeueDog() {
        return _dogQueue.dequeue();
    }
}
