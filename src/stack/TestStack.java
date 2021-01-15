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
public class TestStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);

        System.out.println("Linked stack with 4 values: ");
        linkedStack.print();

        System.out.println("Peeking at linked stack: ");
        System.out.println(linkedStack.peek());

        linkedStack.pop();
        linkedStack.pop();

        System.out.println("Linked stack after popping twice: ");
        linkedStack.print();

        System.out.println("===============================================");

        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(15);
        arrayStack.push(30);
        arrayStack.push(45);
        arrayStack.push(60);
        
        System.out.println(arrayStack.getMin());

        System.out.println("Array stack with 4 values: ");
        arrayStack.print();

        System.out.println("Peeking at array stack: ");
        System.out.println(arrayStack.peek());

        arrayStack.pop();
        arrayStack.pop();

        System.out.println("Array stack after popping twice:");
        arrayStack.print();
    }

}
