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
public class DLL_withTail implements DLLInterface {

    private DLLNode head;
    private DLLNode tail;

    public DLL_withTail() {
        this.head = null;
        this.tail = null;
    }

    public DLL_withTail(DLLNode head) {
        this.head = this.tail = head;
    }

    public DLL_withTail(Object headValue) {
//        this.head.setValue(headValue); //WRONG because this.head originally is null
        //initialize head node
        this.head = this.tail = new DLLNode(headValue);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
            //you can also check here if head.getNext() == null to return 1
            //but it's not necessary as it will be checked in the loop
        } else {
            DLLNode currentNode = this.head;
            int count = 1; //here counter starts from 1 because we are not counting tail node (breaking from loop)
            while (!currentNode.equals(this.tail)) {
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

    public void makeEmpty() {
        this.head = this.tail = null;
    }

    public DLLNode getHeadNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch head.");
        } else {
            return this.head;
        }
    }

    public Object getHeadValue() {
        return this.getHeadNode().getValue();
    }

    public DLLNode getTailNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch tail.");
        } else {
            return this.tail;
        }
    }

    public Object getTailValue() {
        return this.getTailNode().getValue();
    }

    //same as DLL without tail
    public DLLNode getNode(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (isEmpty()) {
            throw new RuntimeException("Cannot fetch node, list is empty!");
        } else {
            DLLNode currentNode = this.head;
            int i = 0;
            while (currentNode != null) { //not necessarily to use .equals to compare with null
                if (i == index) {
                    return currentNode;
                }
                i++;
                currentNode = currentNode.getNext();
            }
            throw new RuntimeException("Object at given index is not found!");
        }
    }

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
            this.head = this.tail = new DLLNode(newElement);
            //or this.head.setValue(newElement);
        } else {
            DLLNode nodeToAdd = new DLLNode(newElement, null, this.tail); //new node's previous is original tail
            this.tail.setNext(nodeToAdd); //original tail is now point to new node
            this.tail = nodeToAdd; //new node is now tail
        }
    }

    //same as DLL without tail
    @Override
    public void insertAtFront(Object newElement) {
        if (isEmpty()) {
            this.head = this.tail = new DLLNode(newElement);
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
        } else if (this.head.getNext() == null) { //or if this.head equals this.tail
            makeEmpty();
        } else {
//          tailNode.setPrevious(null); //doesn't work because nodeBeforeTail is still pointing to tail
            DLLNode nodeBeforeTail = this.tail.getPrevious();
            nodeBeforeTail.setNext(null);
            this.tail = nodeBeforeTail; //important to update tail
        }
    }

    //same as DLL without tail
    @Override
    public void removeFromFront() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from empty list");
        } else if (this.head.getNext() == null) { //or if this.head equals this.tail
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
