package doubly_linked_list;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bader
 */
public interface DLLInterface {

    //return size of list
    int size();

    //returns if list is empty or not
    boolean isEmpty();

    //gets node's element at given index
    Object get(int index);

    //gets index of given element's node
    int indexOf(Object element);

    //adds new node with value newElement at the end of the list
    void insertAtBack(Object newElement);
    
    //adds new node with value newElement at the beginning of the list
    void insertAtFront(Object newElement);

    //removes last node in list
    void removeFromBack();
    
    //remove first node in list
    void removeFromFront();

    //prints the element of the array
    void print();
}
