package lists;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bader
 */
public interface ListInterface {
    //return size of list
    int size();
    
    //returns if list is empty or not
    boolean isEmpty();
    
    //adds new element at the end of the list
    void add (Object newElement);
    
    //gets element at given index
    Object get(int index);
    
    //gets index of given element
    int indexOf(Object element);
    
    //removes last element in list
    void remove();
    
    //removes element at given index
    Object remove (int index);
    
    //removed element from the end of the list
    boolean remove (Object element);
}
