import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.text.DecimalFormat;
 
/**
 *
 * @author Joel Zarley
 */

public class ControlPanel extends JPanel implements ActionListener, MouseListener
{
    private int PAUSE=200; // milliseconds 200
     
    private final View view;
    private final Game game;
    
    private final JLabel  gameLevelLabel = new JLabel( "Level:  " );
    private final JTextField gameLevelTextField;
    private final JButton newGameButton = new JButton( "Press to Play" );
    private final JLabel  gameDurationLabel = new JLabel( "  Game Duration (s): " );
    private final JTextField gameDurationTextField = new JTextField();
     
    private final Timer animationTimer;
    private long gameStartTime;
     
    ControlPanel( View view, Game game ) 
    {
        this.view = view;
        this.game = game;
        
        //init gameLevel from game
        gameLevelTextField = new JTextField(String.valueOf(game.getLevel()));
      
        setLayout( new GridLayout( 1, 5 ) );// modified to 5
        add( gameLevelLabel );// added gameLevelLabel
        add( gameLevelTextField );// added gameLevelTextfield
        add( newGameButton );
        add( gameDurationLabel );
        add( gameDurationTextField );
 
        
        animationTimer = new Timer( PAUSE, this );
        gameDurationTextField.setEditable( false );
        initialize();
    }
 
    private void initialize() 
    {
        newGameButton.addActionListener( new ActionListener()
	    {
            @Override
            public void actionPerformed( ActionEvent actionEvent ) 
		{
		    newGameButtonActionPerformed( actionEvent );
		}
	    });
         
        // register this as the listener for mouse events in the View JPanel
        view.addMouseListener( this );
    }
 
    private void newGameButtonActionPerformed( ActionEvent actionEvent ) 
    {
        gameDurationTextField.setText(""); //blank TextField
        gameStartTime = System.currentTimeMillis(); //start time
        animationTimer.restart();
        game.start(); //begin new game
        
    }
    /**
     * Implementation of ActionListener of Timer
     * @param e unused 
     */
    @Override
    public void actionPerformed( ActionEvent e) 
    {
        game.draw();    // blanks their previous positions and moves them
        view.paintComponent(view.getGraphics()); // repaints image
        double playTime = (System.currentTimeMillis() - gameStartTime) / 1000.000; //in secs
        DecimalFormat df = new DecimalFormat("##0.000");
        gameDurationTextField.setText(df.format(playTime));//output time in secs with 3 sig figs
        
        if (game.getIsOver() || playTime > 10) // check if game is over
	    {
		// stop timer
		animationTimer.stop();
		gameLevelTextField.setText(String.valueOf(game.getLevel()));
	    }
         
    }
 
    
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    // implementation of MouseListener
    @Override
    public void mousePressed(MouseEvent e) 
    {
	if(game.getIsOver()) //if over just return
	    {
		return;
	    }
        game.processClick(e.getX(), e.getY());
	// deleted "stop and start" of the timer for efficiency
        view.paintComponent(view.getGraphics());      
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    @Override
    public void mouseEntered(MouseEvent e) {}
     
    @Override
    public void mouseExited(MouseEvent e) {}
    
    
    
}
