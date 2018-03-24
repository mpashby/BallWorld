/*Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */
package ps2_PashbyMichele;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class ColorChangingBall extends Ball {
	long lastTime;	
	
	public ColorChangingBall (int canvasWidth, int canvasHeight) {
		super (canvasWidth, canvasHeight);		
	}
		
	 public void actionPerformed(ActionEvent e){
	     super.move();	     	     
	     if (e.getWhen() - lastTime > 500) {
	    	 this.color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
	    	 lastTime = System.currentTimeMillis();
	     }  
	    
	  }
}

