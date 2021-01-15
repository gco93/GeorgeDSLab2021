/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author Bader
 */
public class TestLinkedList {

    //Homework: 
    //Question 1: merge two lists and return new list
    // public LinkedList merge (LinkedList list1, LinkedList list2) {
    // return list containing list1 and list2
    // }
    
    //Question 2: concat method for two arrays
    //Use System.arraycopy (sourceArray, sourceInitalIndex, destinationArray, destinationIndex, lengthOfSourceArray)
    /**
     * @param args the command line arguments //Testing my code here in main
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myList = new LinkedList("Marc");
        myList.add("Mahdi");
        myList.add("Khodor");
        myList.add("Zeina");

        System.out.println(myList.get(3));
        System.out.println(myList.get(1));

        System.out.println(myList.indexOf("Khodor"));
        
        System.out.println(myList.size());
        
        LinkedList secondList = new LinkedList();
        secondList.add("Sirin");
        secondList.add("Hassan");
        secondList.add("Ahmad");
        
        LinkedList mergedList = LinkedList.merge(myList, secondList);
        mergedList.print();
        System.out.println(mergedList.getprevious("Khodor"));
        mergedList.remove(2);
        mergedList.print();
        mergedList.remove("Sirin");
        mergedList.print();
        mergedList.remove();
        mergedList.print();
        mergedList.removelast();
        mergedList.print();
        mergedList.replace(1, "Nancy");
        mergedList.print();
        mergedList.insert(1,"Sirine");
        mergedList.print();
        mergedList.replaceAll("Nancy", "Sirine");
        mergedList.print();
        System.out.println(mergedList.contains("Mahdi"));

    }

}
