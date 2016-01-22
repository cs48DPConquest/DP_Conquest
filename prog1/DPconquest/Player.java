import java.awt.event.KeyEvent;

public class Player extends Character {
	private double BAC;
	public final static double MAX_BAC = 0.30;
	
	public Player(String srcImg) {
		super(srcImg);
	}
	
	public void onKeyPress(KeyEvent ev) {
		int keyCode = ev.getKeyCode();
		
		switch(keyCode) {
			case (KeyEvent.VK_UP):
				this.dy = -1;
				break;
				
			case (KeyEvent.VK_DOWN):
				this.dy = 1;
				break;
				
			case (KeyEvent.VK_LEFT):
				this.dx = -1;
				break;
				
			case (KeyEvent.VK_RIGHT):
				this.dx = 1;
				break;
				
			default:
				break;
		}
	}
	
	public void onKeyRelease(KeyEvent ev) {
		int keyCode = ev.getKeyCode();
		
		switch(keyCode) {
			case (KeyEvent.VK_UP):
				this.dy = 0;
				break;
				
			case (KeyEvent.VK_DOWN):
				this.dy = 0;
				break;
				
			case (KeyEvent.VK_LEFT):
				this.dx = 0;
				break;
				
			case (KeyEvent.VK_RIGHT):
				this.dx = 0;
				break;
				
			default:
				break;
		}
	}
	
	public double getBAC() {
		return this.BAC;
	}
}
