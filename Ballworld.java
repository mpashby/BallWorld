/*Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */
package ps2_PashbyMichele;

/*
Ballworld

A simple animation program which displays a set of bouncing balls.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Ballworld extends JFrame // appears in a GUI window
 implements ActionListener { // responds to Timer events

 // program variables
 private ArrayList<Ball> ballList = new ArrayList<Ball>();
 protected javax.swing.Timer timer= new javax.swing.Timer(20,this);
 private JPanel drawingPanel;
 
 // respond to timer events
 public void actionPerformed(ActionEvent e){
    drawingPanel.repaint(); //add call to a handle collision function
    handleCollisions();
 }

 // constructor
 // sets up the GUI frame and then exits
 Ballworld() 
 {
    // Set the frame attributes
    setSize(1000,700);
    setLocation(50,50);
    setTitle("Ballworld");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
    // Get a reference to the frame's content pane
    Container contentPane = getContentPane();

    // Set up the GUI components within the frame
    JPanel buttonPanel = new JPanel(); // a panel for buttons at the bottom
    contentPane.add("South", buttonPanel); 
    
    // three buttons in the button panel
    JButton addButton = new JButton("Add Ball");
    buttonPanel.add(addButton);
    
    JButton addCurveButton = new JButton("Add Curve Ball");
    buttonPanel.add(addCurveButton);
    
    JButton addColorChangingButton = new JButton("Add Color Changing Ball");
    buttonPanel.add(addColorChangingButton);
    
    JButton addBreathingButton = new JButton("Add Breathing Ball");
    buttonPanel.add(addBreathingButton);
    
    JButton addBlinkingButton = new JButton("Add Blinking Ball");
    buttonPanel.add(addBlinkingButton);
          
    JButton clearButton = new JButton("Delete all Balls");
    buttonPanel.add(clearButton);
    
    JButton closeButton = new JButton("Close Window");
    buttonPanel.add(closeButton);

    // the drawing panel
    drawingPanel = new JPanel(){
       // this method describes how to draw the panel
       public void paintComponent(Graphics g){
          super.paintComponent(g); // redraw the panel
          for(Ball b : ballList){ // redraw the balls
             b.draw(g);
          }
       }
    };
    drawingPanel.setBackground(Color.lightGray);
    contentPane.add("Center",drawingPanel);
    
    // Set up the action listeners for the buttons
    addButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
          // instantiate a Ball
          Ball ball = new Ball(drawingPanel.getWidth(),drawingPanel.getHeight());
          // the ball responds to timer ticks
          timer.addActionListener(ball);
          // add it to the Ball list
          ballList.add(ball);
       }
    });
    
    addCurveButton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		//instantiate a Ball
    		CurveBall curveBall = new CurveBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(curveBall);
            // add it to the Ball list
            ballList.add(curveBall);	
    	}
    });
    
     addColorChangingButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		//instantiate a Ball
    		ColorChangingBall colorChangingBall = new ColorChangingBall(drawingPanel.getWidth(),drawingPanel.getHeight());
            // the ball responds to timer ticks
            timer.addActionListener(colorChangingBall);
            // add it to the Ball list
            ballList.add(colorChangingBall);	
        }  
     });
     
     addBreathingButton.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e){
     		//instantiate a Ball
     		 BreathingBall BreathingBall = new BreathingBall(drawingPanel.getWidth(),drawingPanel.getHeight());
             // the ball responds to timer ticks
             timer.addActionListener(BreathingBall);
             // add it to the Ball list
             ballList.add(BreathingBall);	
         }  
      });
     
     addBlinkingButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e){
       		//instantiate a Ball
       		 BlinkingBall BlinkingBall = new BlinkingBall(drawingPanel.getWidth(),drawingPanel.getHeight());
               // the ball responds to timer ticks
              timer.addActionListener(BlinkingBall);
               // add it to the Ball list
              ballList.add(BlinkingBall);	
           }  
        });
     
    clearButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
          ballList.clear();
       }
    });
    
    closeButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e){
          System.exit(0);
       }
    });
    
    setVisible(true); // make the frame visible on the screen
    timer.start();
 }
   //add collision handling function 
    //handleCollisions.addActionListener(new ActionListener() {
    public void handleCollisions() {
    	for (int i=0; i<ballList.size(); i++) {  //for each ball
   		  for (int j=i+1; j< ballList.size(); j++) {
    			if (ballList.get(i).intersect(ballList.get(j))) {
    				ballList.get(i).collide(ballList.get(j));
    		     }
   		  }
   		
    };    
  }
 
 
 // the main method
 public static void main(String args[])
 {
    // instantiate the frame
    new Ballworld();
 }
 
}

