import java.awt.*;
import javax.swing.ImageIcon;

public class Character {
	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	protected Image image;
	
	public Character(String srcImg) {
		ImageIcon ii = new ImageIcon(srcImg);
		image = ii.getImage();
		x = 40;
		y = 60;
	}
	
	public void moveCharacter() {
		x+=dx;
		y+=dy;		
	}
	
	public int getXValue() {
		return this.x;
	}
	
	public int getYValue() {
		return this.y;
	}
	
	public Image getImage() {
		return this.image;
	}
}
