/* 8. Traffic signal control is a vital problem and it matters our work life and business. Write a java program that simulates a traffic signal light. ((hint: use SWING, APPLET, EVENT HANDLING)
a. The program allows the user to select one of three color for the traffic light: red, yellow, or green with radio buttons. (Manual signal control)
b. Modify the program to display appropriate messages like “stop” or “ready” or “go” to appear above the buttons in a selected color. Initially there is no message shown.
c. Automate the Traffic Signal to change Traffic Light periodically. */

/*Automatic Signal Control*/

package lab;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pgm8automatic extends Applet implements Runnable {
    String color; int x;
    public void init() {
        color="green";
        x=0;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true){
        if(x<=0 && color=="red")
        {
        	color="yellow";
            x=5;
        }
        else if(x<=0 && color=="yellow")
        {
        	color="green";
        	x=10;
        }
        else if(x<=0 && color=="green")
        {
            color="red";
            x=10;
        }
        while(x!=0){
            x-=1;
        repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(pgm8automatic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }

    @Override
    public void paint(Graphics g) {
    g.drawString(x+"", 50, 50);
    if(color=="red")
    {
    	g.drawString("STOP", 135, 50);
        g.setColor(Color.red);
        g.fillOval(100, 100, 100, 100);
    }
    else if(color=="yellow")
    {
    	g.drawString("READY", 135, 50);
        g.setColor(Color.yellow);
        g.fillOval(100, 100, 100, 100);
    }
    else if(color=="green")
    {
    	g.drawString("GO", 135, 50);
        g.setColor(Color.green);
        g.fillOval(100, 100, 100, 100);
    }    
}
}
