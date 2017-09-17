import java.applet.Applet;
import javax.swing.JOptionPane;
import java.awt.Graphics;

 /**

  * The HelloWorld class implements an applet that

  * simply displays "Hello World!".

  */

 public class HelloWorld extends Applet {
     public void paint(Graphics g) {
         g.drawString("Hello World Applet", 100, 25);
         g.drawString("By Aviel Resnick", 25, 75);
         
         String name = JOptionPane.showInputDialog(null, "What's your name?");
         g.drawString("Hello " + name + ",", 25, 50);
         
         String a = JOptionPane.showInputDialog(null, "What's your first number?");
         String b = JOptionPane.showInputDialog(null, "What's your second number?");
         String c = JOptionPane.showInputDialog(null, "What's your third number?");
         
         int intA = Integer.parseInt(a);
         int intB = Integer.parseInt(b);
         int intC = Integer.parseInt(c);
         
         int average = (intA + intB + intC) / 3;
         
         g.drawString("The Average is " + average , 25, 100);

     } 
 }