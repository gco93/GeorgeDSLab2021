/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Bader
 */
public interface StackInterface {

    boolean isEmpty();

    void makeEmpty();

    Object peek();

    //similar to insertAtFront
    void push(Object value);

    //similar to removeFromFront
    void pop();

    void print();

}
