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
public class ArrayStack implements StackInterface {

    private Object array[];
    private int top;

    public ArrayStack() {
        //default values
        array = new Object[10];
        top = -1; //index is at -1, i.e. no initialized values yet  
    }

    public ArrayStack(int maxSize) {
        array = new Object[maxSize];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top + 1 == 0;
    }

    @Override
    public void makeEmpty() {
        if (!isEmpty()) {
            top = -1;
            //no need to do anything with the array values as they cannot be read and will be overwritten when new values are added
        }
    }

    public boolean isFull() {
        return top + 1 == array.length;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty. No values to show.");
        } else {
            return array[top];
        }
    }

    //simiar to insertAtFront
    @Override
    public void push(Object value) {
        if (isFull()) {
            expand();
        }
        top++;
        array[top] = value;
    }

    //similar to removeFromFront
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty. No values to remove.");
        } else {
            top--;
        }
    }

    public void expand() {
        Object[] newArray = new Object[array.length * 2];
        //deep cloning using for loop
        System.arraycopy(array, 0, newArray, 0, array.length);
        // or System.arraycopy
//        System.arraycopy(array, 0, newArray, 0, array.length);
        this.array = newArray;
    }
    
    public int getMin()
    {
        ArrayStack work = new ArrayStack();
        work=this;
        int min = work.top;
        while(work.isEmpty())
        {
            if(min < work.peek())
                min = work.top;
            work.pop();
        }
        
        return min;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(array[i] + "=> ");
            }
            System.out.println();
        }
    }
}
