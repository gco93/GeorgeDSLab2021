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
public class DLL implements DLLInterface {

    private DLLNode head;

    public DLL() {
        this.head = null;
    }

    public DLL(DLLNode head) {
        this.head = head;
    }

    public DLL(Object headValue) {
//        this.head.setValue(headValue); //WRONG because this.head originally is null
        //initialize head node
        this.head = new DLLNode(headValue);
    }

    //same implementation as SLL
    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
            //you can also check here if head.getNext() == null to return 1
            //but it's not necessary as it will be checked in the loop
        } else {
            DLLNode currentNode = this.head;
            int count = 0;
            while (currentNode != null) {
                currentNode = currentNode.getNext();
                count++;
            }
            return count;
        }
    }

    //same implementation as SLL
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

    //same implementation as SLL
    public void makeEmpty() {
        this.head = null;
    }

    //same implementation as SLL
    public DLLNode getHeadNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch head.");
        } else {
            return this.head;
        }
    }

    //same implementation as SLL
    public Object getHeadValue() {
        return this.getHeadNode().getValue();
    }

    //same implementation as SLL
    public DLLNode getTailNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch tail.");
        }
        //initialize
        DLLNode currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    //same implementation as SLL
    public Object getTailValue() {
        return this.getTailNode().getValue();
    }
    
    public void addAll (DLL list2)
    {
        this.getTailNode().setNext(list2.getHeadNode());
        list2.getHeadNode().setPrevious(this.getTailNode());
        
    }
    public DLL intersect (DLL list1, DLL list2)
    {
        
        DLL list3 = new DLL();
        DLLNode currentNode1 = list1.getHeadNode();
        while (currentNode1 != null)
        {
            DLLNode currentNode2 = list2.getHeadNode();
            while (currentNode2 !=null)
            {
                if(currentNode1.getValue().equals(currentNode2.getValue()))
                { 
                    list3.insertAtBack(currentNode1.getValue());
                    break;
                }
                else
                    currentNode2 = currentNode2.getNext();
            }
            
            currentNode1 = currentNode1.getNext();
        }
        
        
        return list3;
    }

    //same implementation as SLL
    public DLLNode getNode(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (isEmpty()) {
            throw new RuntimeException("Cannot fetch node, list is empty!");
        } else {
            DLLNode currentNode = this.head;
            int i = 0;
            while (currentNode != null) {
                if (i == index) {
                    return currentNode;
                }
                i++;
                currentNode = currentNode.getNext();
            }
            throw new RuntimeException("Object at given index is not found!");
        }
    }

    //same implementation as SLL
    @Override
    public Object get(int index) {
        return this.getNode(index).getValue();
    }

    //same implementation as SLL
    @Override
    public int indexOf(Object element) {
        DLLNode currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public void insertAtBack(Object newElement) {
        if (isEmpty()) {
            this.head = new DLLNode(newElement);
            //or this.head.setValue(newElement);
        } else {
            DLLNode tailNode = this.getTailNode();
            DLLNode nodeToAdd = new DLLNode(newElement, null, tailNode);
            tailNode.setNext(nodeToAdd);
        }
    }

    @Override
    public void insertAtFront(Object newElement) {
        if (isEmpty()) {
            this.head = new DLLNode(newElement);
        } else {
            DLLNode nodeToAdd = new DLLNode(newElement, head, null);
            this.head.setPrevious(nodeToAdd); //important to set current head's previous before changing head reference
            this.head = nodeToAdd; //or this.head = this.head.getPrevious();
            //if I don't set the previous of the head before changing it, it remains set to null
            //and I cannot access it from head anymore =>
//            this.head.getNext().setPrevious(head);
        }
    }

    @Override
    public void removeFromBack() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from empty list");
        } else if (this.head.getNext() == null) { //or if this.head equals tailNode
            makeEmpty();
        } else {
            DLLNode tailNode = this.getTailNode();
//          tailNode.setPrevious(null); //doesn't work because nodeBeforeTail is still pointing to tail
            DLLNode nodeBeforeTail = tailNode.getPrevious();
            nodeBeforeTail.setNext(null);
        }
    }

    @Override
    public void removeFromFront() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from empty list");
        } else if (this.head.getNext() == null) { //or if this.head equals tailNode
            makeEmpty();
        } else {
            this.head = this.head.getNext(); //new head is now the next of old head
            this.head.setPrevious(null); //new head's previous is now set to null
        }
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            DLLNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + " --> ");
                currentNode = currentNode.getNext();
            }
            System.out.println("");
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            DLLNode currentNode = this.getTailNode();
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + " <-- ");
                currentNode = currentNode.getPrevious();
            }
            System.out.println("");
        }
    }
}
