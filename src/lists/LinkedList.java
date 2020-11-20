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
public class LinkedList implements ListInterface {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(Object nodeValue) {
        this.head = new Node(nodeValue);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
            //you can also check here if head.getNext() == null to return 1
            //but it's not necessary as it will be checked in the loop
        } else {
            Node currentNode = this.head;
            int count = 0;
            while (currentNode != null) {
                currentNode = currentNode.getNext();
                count++;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
        //similar to
//        if(this.head == null){
//            return false;
//        } else {
//            return true;
//        }
    }

    //clear linked list
    public void makeEmpty() {
        this.head = null;
    }

    @Override
    public void add(Object newElement) {
        if (head == null) { //or if(isEmpty())
            head = new Node(newElement);
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(newElement));
        }
    }

    public Node getHeadNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch head.");
        } else {
            return this.head;
        }
    }

    public Object getHeadValue() {
        return this.getHeadNode().getValue();
    }

    public Node getTailNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch tail.");
        }
        //initialize
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public Object getTailValue() {
        return this.getTailNode().getValue();
    }

    //remove initial conditions
    public Node getNode(int index) {
        //no need since we are throwing default exception after while loop
//        if (index < 0 || index >= size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        } else if (isEmpty()) {
//            throw new RuntimeException("Cannot fetch node, list is empty!");
//        } else {

        Node currentNode = this.head;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                return currentNode;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        throw new RuntimeException("Object at given index is not found!");
//        }
    }

    @Override
    public Object get(int index) {
        return this.getNode(index).getValue();
    }

    //similar to contain method
    @Override
    public int indexOf(Object element) {
        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            //TODO: solve on your own for course homework
            if (currentNode.getValue().equals(element)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    //TODO: homework remove element from back
    
    public void removelast()
    {
        if(isEmpty())
            throw new RuntimeException("list is empty!");
        Node del = this.head;
        for(int i=0;del != this.getTailNode();i++)
        {
            del.getNext();
        }
        del.setNext(null);
    }
    
    @Override
    public void remove() {
        if(isEmpty())
            throw new RuntimeException("list is empty");
        this.head.equals(this.getNode(1));
    }

    //Course & Lab homework
    //Hint: make use of get functions defined above
    @Override
    public Object remove(int index) {
        if(isEmpty())
            throw new RuntimeException("list is empty");
        if(this.size() == 1)
        {
            Node del = this.head;
            this.makeEmpty();
            return del;
        }
        else
        {
        Node del = new Node(this.getNode(index));
        this.getNode(index-1).setNext(this.getNode(index+1));
        return del;
        }
    }

    @Override
    public boolean remove(Object element) {
        if(isEmpty())
            return false;
        if(this.size() == 1)
        {
            this.makeEmpty();
            return true;
        }
        if(this.getNode(this.indexOf(element)) != null)
        {
            //this.getNode(this.indexOf(element)-1).setNext(this.getNode(this.indexOf(element)+1));
            this.remove(this.indexOf(element));
            return true;
        }
        
        return false;
    }

    //TODO: test this function
    public static LinkedList merge(LinkedList list1, LinkedList list2) {
        //TODO: add logic here
        
        //list1: 1 => 2 => 3
        //list2: 4 => 5 => 6
        //list3: 1 => 2 => 3 => 4 => 5 => 6
        
        if (list1.isEmpty()) //if list1.head == null
        {
            return list2;
        }
        if (list2.isEmpty()) {
            return list1;
        }

        if (list1.isEmpty() && list2.isEmpty()) {
            throw new RuntimeException();
        }
        
        //first way
//        LinkedList mergedList1 = new LinkedList();
//
//        Node head1 = list1.head; //or list1.getHeadNode();
//        Node head2 = list2.head; //or list2.getHeadNode();
//
//        Node tail1 = list1.getTailNode();
////        Node tail2 = list2.getTailNode(); I didn't use it
//
//        mergedList1.head = head1;
//        tail1.setNext(head2);

        //second way
        LinkedList mergedList2 = list1;
        mergedList2.getTailNode().setNext(list2.head);

        return mergedList2; //or uncomment first way, comment second way, and return mergedList1 to test first way;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + " --> ");
                currentNode = currentNode.getNext();
            }
            System.out.println("");
        }
    }
}
