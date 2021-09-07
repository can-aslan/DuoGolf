package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

/**
 * Hole Class
 * @author Yağız Can Aslan
 * @version 07.09.2021
*/
public class GolfBall extends JComponent
{
    // Properties
    private final Color BORDER_COLOR = new Color( 10, 10, 10); // Dark Gray
    private final Color COLOR = new Color( 210, 211, 212); // White
    private final int BORDER_SIZE = 3;
    private final int PROG_WIDTH;
    private final int PROG_HEIGHT;
    private final int SIZE_OF_BORDER_AND_GOLF_BALL;
    public final int SIZE = 30;

    private Hole hole;
    public int x;
    public int y;
    
    // Constructors
    public GolfBall( int width, int height, Hole hole) {
        PROG_WIDTH = width;
        PROG_HEIGHT = height;
        
        this.hole = hole;

        x = PROG_WIDTH - hole.x;
        y = PROG_HEIGHT - hole.y;
        
        SIZE_OF_BORDER_AND_GOLF_BALL = SIZE + BORDER_SIZE;

        repaint();
    }
    
    // Methods
    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent( g);
        Graphics2D graphics2D = (Graphics2D) g;

        // Anti-Aliasing
        graphics2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Golf Ball Border
        graphics2D.setColor( BORDER_COLOR);
        graphics2D.fillOval( x - BORDER_SIZE, y - BORDER_SIZE, SIZE_OF_BORDER_AND_GOLF_BALL, SIZE_OF_BORDER_AND_GOLF_BALL);

        // Golf Ball
        graphics2D.setColor( COLOR);
        graphics2D.fillOval( x, y, SIZE, SIZE);        
    }
}
