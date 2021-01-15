/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_list;

/**
 *
 * @author Bader
 */
public class TestMyArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new ArrayList
        ArrayList testArray = new ArrayList(2);
        
        //test add function
        testArray.add("Java");
        testArray.add("Python");
        testArray.add("Swift");
        testArray.add("JavaScript");
        testArray.print();
        
        //test remove function
        System.out.println("Removing last element:");
        testArray.remove();
        testArray.print();
        
        //test remove element function
        System.out.println("Remove Python element");
        testArray.remove("Python");
        testArray.print();
        
        //test remove index function
        System.out.println("Removing element at index 0");
        testArray.remove(0);
        testArray.print();
        
        ArrayList testArray2 = new ArrayList(5);
        testArray2.add("London");
        testArray2.add("Paris");
        
        System.out.println("Concating another Arraylist:");
        testArray.concat(testArray2);
        testArray.print();
    }
}
