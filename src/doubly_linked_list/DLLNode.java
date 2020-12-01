package doubly_linked_list;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bader this class is implemented with the help of the IDE > I just
 * define the fields: value, next, previous > Press ALT + INSERT > IDE fills in
 * the constructors and getters and setters
 */
public class DLLNode {

    private Object value;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public DLLNode(Object value, DLLNode next, DLLNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public void printNode() {
        System.out.println("Node's Value: " + value
                + ", previous node is: " + previous.getValue()
                + ", next node is: " + next.getValue());
    }
}
