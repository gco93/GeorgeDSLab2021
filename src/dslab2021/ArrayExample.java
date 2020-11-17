/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab2021;

/**
 *
 * @author Bader
 */
public class ArrayExample {
    
    public static void contains(int value, int[] array) {
        //Write logic here
        
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
         if(value == array[i]){
             found = true;
             break;
        }
        }
        
        if(found){
        System.out.println(value + "is found");
        } else {
        System.out.println(value + "is not found");
        }
    }
    public static int [] concatfor(int[]a,int[]b) 
    {
        int[]c=new int[a.length + b.length];
        for(int i=0;i<a.length;i++)
        {
            c[i]=a[i];
        }
        for(int i=0;i<b.length;i++)
        {
            c[a.length+i]=b[i];
        }
        return c;
    }
    public static void main(String[] args) {
        int [] array = {41, 6, 91, 24, 54, 78};
        int [] array2 = {41, 6, 91, 24, 54, 78};
        //TODO: write a function called contains that tells me if a certain value if present inside the array or not
        contains(5, array);
        contains(91, array);
        
        System.out.println(concatfor(array, array2)[11]);
        
        //this method is supported because if we do
        //System.arraycopy(array2, 0, array, array.length, array2.length);
        //it wiil trow an exeption that not enaugh space in array2 exeeded length
        int[] d = new int [array.length*2];
        System.arraycopy(array, 0, d, 0, array.length);
        System.arraycopy(array2, 0, d, array.length, array2.length);
        
        
        
    }
}
