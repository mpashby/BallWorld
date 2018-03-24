/*Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */
package ps2_PashbyMichele;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class CurveBall extends Ball {	
	private double curvature;
	
	  public CurveBall (int canvasWidth, int canvasHeight) {  //constructor
		super (canvasWidth, canvasHeight);
		//curvature is a random double between 15 and 20
		curvature=(double)(5*Math.random())+15; 
		
	  }
	  
	  public void move () {
	      super.move();
		  xvelocity -= yvelocity / curvature;
		  yvelocity += xvelocity/ curvature;
	  }
	  
}
 