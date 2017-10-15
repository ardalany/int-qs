/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author ardal
 */
public class Vertex<T> {
    public T data;
    public boolean visited;
    
   public Vertex(){
       visited = false;
   }
   
   public Vertex(T data) {
       this();
       this.data = data;
   }
}
