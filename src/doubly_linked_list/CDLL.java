/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubly_linked_list;

/**
 *
 * @author george
 */
public class CDLL implements DLLInterface{
    private DLLNode head;
    private DLLNode tail;
    private int size = 0;

    public CDLL()
    {
        this.head=this.tail=null;
        this.size=0;
    }
    
    public CDLL(DLLNode head) {
        this.head = this.tail = head;
        this.head.setNext(this.head);
        this.head.setPrevious(this.head);
        this.size++;
    }
    
    public CDLL( Object headvalue)
    {
        this.head = this.tail = new DLLNode (headvalue);
        this.head.setNext(head);
        this.head.setPrevious(head);
        this.size++;
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void makeempty()
    {
        this.head = this.tail = null;
        this.size = 0;
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
            while (i<=this.size) { 
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

    @Override
    public int indexOf(Object element) {
        DLLNode currentNode = this.head;
        int index = 0;
        while (index<=this.size) {
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
            this.head.setNext(head);
            this.head.setPrevious(head);
            
        } else
            {
            DLLNode nodeToAdd = new DLLNode(newElement, null, this.tail); //new node's previous is original tail
            this.tail.setNext(nodeToAdd); //original tail is now point to new node
            this.tail = nodeToAdd; //new node is now tail
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            }
        this.size++;
    }

    @Override
    public void insertAtFront(Object newElement) {
        if (isEmpty()) {
            this.head = this.tail = new DLLNode(newElement);
            this.head.setNext(head);
            this.head.setPrevious(head);
            
        } else
        {
            DLLNode nodetoadd = new DLLNode (newElement, this.head, null);
            this.head.setPrevious(nodetoadd);
            this.head=nodetoadd;
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
        }
        size++;
    }

    @Override
    public void removeFromBack() {
             if (isEmpty()) {
            throw new RuntimeException("Cannot remove from empty list");
        } else if (size == 1) { //or if this.head equals this.tail
            makeempty();
        } else {
//          tailNode.setPrevious(null); //doesn't work because nodeBeforeTail is still pointing to tail
            DLLNode nodeBeforeTail = this.tail.getPrevious();
            nodeBeforeTail.setNext(this.head);
            this.head.setPrevious(nodeBeforeTail);
            this.tail = nodeBeforeTail; //important to update tail
            this.size--;
        }
    
    }

    @Override
    public void removeFromFront() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from empty list");
        } else if (size == 1) { //or if this.head equals this.tail
            makeempty();
        } else {
            this.head = this.head.getNext(); //new head is now the next of old head
            this.head.setPrevious(this.tail); //new head's previous is now set to null
            this.tail.setNext(this.head);
            this.size--;
        }
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            DLLNode currentNode = head;
            //System.out.println("-->");
            for (int i =1 ; i<= this.size ; i++) {
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
            //System.out.println("<--");
            for (int i =1 ; i<= this.size ; i++) {
                System.out.print(currentNode.getValue() + " <-- ");
                currentNode = currentNode.getPrevious();
            }
            System.out.println("");
        }
    }
    
    
    
}
