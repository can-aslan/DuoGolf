import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameobjects.*;

/**
 * A simple panel class which extends JPanel
 * @author Yağız Can Aslan
 * @version 07.09.2021
*/
public class GamePanel extends JPanel implements ActionListener
{
    
    // Properties
    private final int WIDTH;
    private final int HEIGHT;
    private final Color LIME;
    private Timer timer;
    private Hole hole;
    private GolfBall golfBall;

    // Constructors
    public GamePanel( int width, int height) {
        WIDTH = width;
        HEIGHT = height;  
        LIME = new Color( 145, 230, 121);

        setBackground( LIME);

        setLayout( null);
        setBorder( BorderFactory.createEmptyBorder(5, 5, 10, 5));

        hole = new Hole( WIDTH, HEIGHT);
        add( hole);

        golfBall = new GolfBall( WIDTH, HEIGHT, hole);
        add( golfBall);

        repaint();

        timer = new Timer( 10, this);
        timer.start();
    }
    
    // Methods
    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent( g);

        hole.paintComponent( g);
        golfBall.paintComponent( g);

        timer.start();
    }

    @Override
    public void actionPerformed( ActionEvent e) {
        timer.stop();
        repaint();
    }

    public GolfBall getGolfBall() {
        return golfBall;
    }
}