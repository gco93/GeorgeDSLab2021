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
public class TestDLL {

    /**
     * @param args the command line arguments //Testing my code here in main
     */
    public static void main(String[] args) {
        CDLL myList = new CDLL("Bader");
//        DLL_withTail myList = new DLL_withTail("Bader");
//        DLL_withTailAndSize myList = new DLL_withTailAndSize("Bader");

        myList.insertAtBack("Chantal");
        myList.insertAtFront("George");
        myList.insertAtBack("Sirine");
        myList.insertAtBack("Serhal");
        myList.insertAtFront("Obeid");

        myList.print();

        System.out.println("Element at index 3 is: " + myList.get(3));

        System.out.println("George has index of: " + myList.indexOf("George"));

        System.out.println("Size of list is: " + myList.size());

        //Testing of remove functions
        System.out.println("Removing from back.");
        myList.removeFromBack();
        myList.print();
        myList.printReverse();

        System.out.println("Removing from front.");
        myList.removeFromFront();
        myList.print();
        myList.printReverse();
    }

}
