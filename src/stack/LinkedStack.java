/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 * STACK IMPLEMENTS LIFO STRUCTURE (LAST-IN FIRST-OUT)
 *
 * @author Bader
 */
public class LinkedStack implements StackInterface {

    private Node top;
    public int size; //either set as public or use a public getter 

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    public LinkedStack(int size) {
        this.size = size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void makeEmpty() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty. No values to show.");
        } else {
            return this.top.getValue();
        }
    }

    //same as insertAtFront
    @Override
    public void push(Object value) {
        if (isEmpty()) {
            this.top = new Node(value);
        } else {
            //this
            Node newNode = new Node(value);
            newNode.setNext(this.top);
            //OR
//            Node newNode = new Node(value, this.top);
            this.top = newNode;
        }
        this.size++;
    }

    //same as removeFromFront
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty. No values to remove.");
        } else if (size == 1) {
            makeEmpty();
        } else {
            //this will cause an exception if there is only one node in the stack since getNext will return null
            //thus it's better to take the case with one node into consideration in the if-condition
            Node nextNode = this.top.getNext();
            this.top = nextNode;
            this.size--;
        }
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            Node currentNode = this.top;
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + "=> ");
                currentNode = currentNode.getNext();
            }
            System.out.println();
        }
    }
}
