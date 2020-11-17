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
public class Professional {
    String name;
    private int age;
    private String profession;
    
    Professional(){
        
    }

    Professional (String workerProfession) {
        this.name = "";
        this.age = 18;
        this.profession = workerProfession;
    }
    
    //Getters
    public String getName (){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    //Setters
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
