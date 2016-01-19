import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.net.URL;
 
/**
 *
 * @author Joel Zarley
 */
public class Game
{
    public final static int IMAGE_SIZE = 600;
     
    private final Image image;
                             
    private boolean isOver;
    private int level;
     
    private final Graphics graphics;
         
    Game() 
    {         
	// start level
	level = 1;
        // create Image object
        image = new BufferedImage (IMAGE_SIZE, IMAGE_SIZE, BufferedImage.TYPE_INT_RGB );
        graphics = image.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, IMAGE_SIZE, IMAGE_SIZE);  
    }
 
    public Image getImage()
    {
        return image;
    }
     
    public void start()
    {
        isOver = false; 
    }
         
    public void draw()
    {       
        graphics.setColor(new Color(200, 220, 255)); //blank screen to remove prev critter position
        graphics.fillRect(0,0, IMAGE_SIZE, IMAGE_SIZE );                 
    }
         
    public void processClick( int x, int y )
    {        

        
    }
     
    private int getRandom(int start, int end) //random generator 
    {
        int rnd = (int) (Math.random()*end+start);
        return rnd;
    }
    
    
    private int randomSign(int random) //random positve or negative generator
    {
        int rnd = random;
        int j = getRandom(1,2);
        if(j == 1)
	    {
		rnd = -1 * rnd; //make negative
	    }
        return rnd;
    }
 
    public boolean getIsOver() 
    {
        return isOver;
    }
 
    public void setIsOver(boolean isOver) 
    {
        this.isOver = isOver;
    }
    

    public int getLevel() 
    {
	return level;
    }

    public void setLevel(int level) 
    {
	this.level = level;
    }
  
}
