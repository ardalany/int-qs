/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.AnimalShelter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ardalan
 */
public class AnimalShelterQueueTest {

    /**
     * Test of enqueue method, of class AnimalShelterQueue.
     */
    @Test
    public void Enqueue_adds_cat_to_cat_queue() {
        // Set up
        Animal animal = new Cat();
        AnimalShelterQueue sut = new AnimalShelterQueue();
        
        // Execute
        sut.enqueue(animal);
        Animal result = sut.dequeueCat();
        
        // Assert
        assertNotNull(result);
    }
    
    @Test
    public void Enqueue_adds_dog_to_dog_queue() {
        // Set up
        Animal animal = new Dog();
        AnimalShelterQueue sut = new AnimalShelterQueue();
        
        // Execute
        sut.enqueue(animal);
        Animal result = sut.dequeueDog();
        
        // Assert
        assertNotNull(result);
    }

    /**
     * Test of dequeueAny method, of class AnimalShelterQueue.
     */
    @Test
    public void DequeueAny_returns_cat_when_cat_is_queued_before_dog() throws InterruptedException {
        // Set up
        Animal dog = new Dog();
        Animal cat = new Cat();
        AnimalShelterQueue sut = new AnimalShelterQueue();
        
        // Execute
        sut.enqueue(cat);
        Thread.sleep(1000);
        sut.enqueue(dog);
        Animal result = sut.dequeueAny();
        
        // Assert
        assertTrue(result instanceof Cat);
    }
    
    @Test
    public void DequeueAny_returns_dog_when_dog_is_queued_before_cat() throws InterruptedException {
        // Set up
        Animal dog = new Dog();
        Animal cat = new Cat();
        AnimalShelterQueue sut = new AnimalShelterQueue();
        
        // Execute
        sut.enqueue(dog);
        Thread.sleep(1000);
        sut.enqueue(cat);
        Animal result = sut.dequeueAny();
        
        // Assert
        assertTrue(result instanceof Dog);
    }
    
}
