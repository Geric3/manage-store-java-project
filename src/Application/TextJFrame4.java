/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author Roger
 */
import javax.swing.*;
public class TextJFrame4 {
    
    

  public static void main(String argv[]) {
    JFrame f = new JFrame("ma fenetre");  
    f.setSize(300,100); 
   
    JButton b =new JButton("Mon bouton");  
    f.getContentPane().add(b);   
    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    ImageIcon image = new ImageIcon("Capture_carré2.png"); 
    f.setIconImage(image.getImage());  
    f.setVisible(true);
  } 
    
}
