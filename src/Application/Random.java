/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.*;
public class Random {  
    public static void main (String args[]) {  
        Random r = new Random();
    
      double a =  Math.random() ; //entier entre -9 et 9
      int b,p,q;
      String tes,txt,tex ="";
      
      double valeur = Math.random() * 10000000; 
      double valeur1 = Math.random() * 10;
      b= (int) Math.round(valeur);
      p= (int) Math.round(valeur1);
      q= (int) Math.round(a)*10;
      tex="ME00";
      tes="ME010580";
      
      tex += String.valueOf(q);
      txt = String.valueOf(b);
      tes += String.valueOf(p);
      
      if(p==0||p==5||p==7){
          tex +=txt;
        System.out.print(tex);
        System.out.print(q);
        System.out.println();
      }else if(p==1||p==3||p==9){
          tes="ME010580";
          tes +=txt;
          System.out.println(tes);
      }else{
          txt="ME1405";
          txt +=txt;
         System.out.println(txt);
      }
      
      
      System.out.println("q ="+q);
      System.out.println("test ="+tex);
        System.out.println("test ="+tes);
      System.out.println("b ="+b);
      System.out.println("p ="+p);
       System.out.println(" un nombre aléatoire"+ a);
} 

    
}
