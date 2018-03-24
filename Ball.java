/*Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */
package ps2_PashbyMichele;
/*
Ball -- represents one ball in the Ball World application
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball implements ActionListener
{
  // the Ball's properties
  private int canvasWidth, canvasHeight;
  protected int xpos,ypos;
  protected double xvelocity,yvelocity;
  protected int diameter;
  protected double mass;
  protected Color color;

  // the Ball constructor
  // parameters are the width and height of the canvas
  public Ball(int width, int height){
     canvasWidth = width;
     canvasHeight = height;
     
     // the diameter is a random int between 50 and 100 
     diameter = (int)(50*Math.random())+50;
     mass=(diameter/2)* (diameter/2)*(diameter/2);
     // the velocity components 
     xvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
     yvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
     
     // the initial (x,y) position of the ball
     xpos=(int)(canvasWidth*Math.random());
     ypos=(int)(canvasHeight*Math.random());
     
     // pick a random color
     color=new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
  }
  
  public int getXpos() {
	  return xpos;
  }
  
  public int getYpos () {
	  return ypos;
  }
  
  public int getDiameter() {
	  return diameter;
  }
  
  public double getXVel() {
	  return xvelocity;
  }
  
  public double getYVel() {
	  return yvelocity;
  }
  
  public double getMass() {
	  return mass;
  }

  // how the ball moves
  public void move(){
     int xmax = canvasWidth;
     int ymax = canvasHeight;
     
     // update the x position
     xpos+=xvelocity;
     // if past the right boundary, bounce back to the left
     if(xpos+diameter > xmax){
        xpos = xpos - 2*(xpos+diameter-xmax);
        xvelocity = -xvelocity;
     }
     // if past the left boundary, bounce back to the right
     if(xpos < 0){
        xpos = -xpos;
        xvelocity = -xvelocity;
     }
     
     // update the y position      
     ypos+=yvelocity;
     // if past the bottom boundary, bounce back up
     if(ypos+diameter > ymax){
        ypos = ypos - 2*(ypos+diameter-ymax);
        yvelocity = -yvelocity;
     }
     // if past the upper boundary, bounce back down
     if(ypos < 0){
        ypos = -ypos;
        yvelocity = -yvelocity;
     }
  }
  
  
  public double distance(Ball other) {
	  int xpos2=other.xpos;
	  int ypos2=other.ypos;
	  double distance=Math.sqrt(((xpos-xpos2)*(xpos-xpos2))+((ypos-ypos2)*(ypos-ypos2)));
	  return distance;
  }
  
  public boolean intersect(Ball other) {
	  if (distance(other)<=diameter/2 + other.diameter/2) {
		  return true;
	  } 
		  return false;
	  
  }
  
  public void collide(Ball other) { 
	  //create temporary variable to store old velocity
   if (other != this) {
	  double tempXV = this.xvelocity;
	  double tempYV = this.yvelocity;
	  double tempXV2 = other.xvelocity;
	  double tempYV2 = other.yvelocity;
	  
	  double newVelX1 = (tempXV * (mass -other.mass)
			  + (2* other.mass * tempXV2)) / (mass + other.mass);
	  
	  
      double newVelY1 =  (tempYV * (mass -other.mass)
    		  + (2* other.mass * tempYV2)) / (mass + other.mass);
      double newVelX2 = (tempXV2 * (other.mass- mass) 
    		  + (2* mass * tempXV)) / (mass + other.mass);
      double newVelY2 = (tempYV2 * (other.mass - mass)
    		  + (2* mass* tempYV)) / (mass + other.mass);
      
      
      this.xvelocity = newVelX1;
      this.yvelocity = newVelY1;
      other.xvelocity = newVelX2;
      other.yvelocity = newVelY2;
      
      
      this.xpos += (int)newVelX1;
      this.ypos += (int)newVelY1;
      other.xpos += (int)newVelX2;
      other.ypos += (int)newVelY2;  
	}
}

  // how to draw this ball
  public void draw(Graphics g){
     g.setColor(color);   //g. built in functions
     g.fillOval(xpos,ypos,diameter,diameter);
  }

  // how the ball responds to a timer tick
  public void actionPerformed(ActionEvent e){
     move();
  
  }
  
}