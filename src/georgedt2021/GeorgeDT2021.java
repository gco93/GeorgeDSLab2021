/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package georgedt2021;

/**
 *
 * @author george
 */
public class GeorgeDT2021 {

    public static boolean isAscending (int[] x )
        {
            for( int i=1; i<x.length-1; i++)
            {
                if(x[i]>x[i+1])
                    return false;
            }
            
            return true;
        }
    public static void main(String[] args) {
        System.out.println("a b  ");
        int[]a = new int[10];
        int[]b = new int[10];
        for (int j=1,k=9 ;j<10; j++,k--)
        {
            b[j]=k;
            a[j]=j;
            System.out.println("" + a[j] + " " + b[j]);
        }
        
        //System.out.println("" + a.length + " " + b.length) ;
        System.out.println("Array a is " + isAscending(a)) ;
        System.out.println("Array b is " + isAscending(b)) ;
            
    }

}
