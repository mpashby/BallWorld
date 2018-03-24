/*Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */
package ps2_PashbyMichele;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class BlinkingBall extends Ball {
    private int count;
	long lastTime;
	private Color tempColor;
	
	public BlinkingBall (int canvasWidth, int canvasHeight) {
		super(canvasWidth, canvasHeight);
		lastTime = System.currentTimeMillis();
		tempColor = this.color;
	}
	
	public void actionPerformed(ActionEvent e){
	     super.move();	          	     	     
	     if (e.getWhen() - lastTime > 500) {
	    	 count++;
		     
		     if (count % 2 == 0) {
		    	 this.color = tempColor;
		     } else {
		       this.color = new Color (0,0,0,0);
		     }
	    	 lastTime = System.currentTimeMillis();
	     }  
	}    
}
