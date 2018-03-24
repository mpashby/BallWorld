/*Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */
package ps2_PashbyMichele;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class BreathingBall extends Ball {
	long lastTime;
	private int dcount;
	
	public BreathingBall (int canvasWidth, int canvasHeight) {
		super(canvasWidth, canvasHeight);
		lastTime = System.currentTimeMillis();
	}
	
    public void actionPerformed(ActionEvent e){
	     super.move();
	     	     
	     if (e.getWhen() - lastTime > 500) {
	    	 dcount++;
	    	 if (dcount % 2 ==1) {
	    	     this.diameter += 20;
	    	 } else {
	    		 this.diameter -=20;
	    	 }
	         lastTime = System.currentTimeMillis();
	     }
    }
}
