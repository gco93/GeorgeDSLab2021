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
public class ArrayList implements ArrayListInterface {

    // 1. define and initialize array of objects
    // 2. define initial capacity of array, e.g. 10 elements
    // 3. define currentSize of array, initially = 0
    // 4. implement ArrayList constructor
    // 5. implement abstract method of ArrayListInterface
    private Object[] array;
    private int currentSize = 0;

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Object getElement(int index) {
        if (index > 0 || index < currentSize) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    //this is the contain method previously implement, only it returns the index instead of true or false
    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < currentSize; i++) {
            if (element == array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Object newElement) {
        if (currentSize == array.length) {
            //expand array

            Object[] newArray = new Object[array.length * 2];
            /*
            it's less costly to multiply length of array by two, for example, when we want to expand the array
            than add it by one only each time
            because then we will have to expand the array on each add operation when the currentSize reaches the inital size set
             */
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[currentSize] = newElement;
            array = newArray;
            currentSize++;
        } else {
            array[currentSize] = newElement;
            currentSize++;
        }
    }

    //removing last element of array
    @Override
    public void remove() {
        if (currentSize != 0) {
            currentSize--;
            /*just be setting the currentSize to point to the element before,
            this means the array will not accessing the last element anymore, even though physically it's still there
            but to us it doesn't appear
            and then the next time we use the add function it will replaced by the new element and gone for good
             */
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = index; i < currentSize; i++) {
                array[i] = array[i + 1];
                /*
                shifting backwards all elements after array[index] to replace it (and thus remove it) 
                and avoid empty spaces in the array
                 */
            }
            currentSize--;
        }
    }

    @Override
    public void remove(Object oldElement) {
        int index = indexOf(oldElement);
        if (index != -1) {
            remove(index);
            //not setting currentSize--; because it's already been done in the remove(int index) method
        } else {
            throw new NullPointerException("The element you're trying to remove could not be found.");
        }
    }

    //concats two ArrayLists
    @Override
    public ArrayList concat(ArrayList l2) {
        ArrayList l1 = this;

        for (int i = 0; i < l2.size(); i++) {
            l1.add(l2.getElement(i));
        }
        return l1;
    }

    //concat two arrays using System.arraycopy
    public Object[] concat(Object[] array1, Object[] array2) {
        int newSize = array1.length + array2.length;
        Object[] array3 = new Object[newSize];

        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);

        return array3;
    }
    
    public 

    public void print() {
        System.out.print("Index  : \t");
        for (int i = 0; i < currentSize; i++) {
            System.out.print((i) + "\t");
        }

        System.out.print("\nElement : \t");

        for (int i = 0; i < currentSize; i++) {
            System.out.print(array[i] + "\t");
        }

        System.out.println("\n");
    }
}
