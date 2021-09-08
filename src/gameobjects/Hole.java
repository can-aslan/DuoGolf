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
public class Hole extends JComponent
{
    // Properties
    private final Color COLOR = new Color( 50, 50, 50); // Dark Gray
    private final Color BORDER_COLOR = new Color( 100, 100, 100); // Lighter Dark Gray
    private final int BORDER_SIZE = 1;
    private final int PROG_WIDTH;
    private final int PROG_HEIGHT;
    private final int SIZE_OF_BORDER_AND_GOLF_BALL;
    private boolean playerScored;
    public final int SIZE = 30;
    public int x;
    public int y;
    
    // Constructors
    public Hole( int width, int height) {
        PROG_WIDTH = width;
        PROG_HEIGHT = height;
        
        do {
            x = (int) (Math.random() * ((PROG_WIDTH - 2*SIZE) / 2));
        } while ( x < (2*SIZE) || x > (PROG_WIDTH - (2*SIZE)));

        do {
            y = (int) (Math.random() * ((PROG_HEIGHT - 2*SIZE) / 2));
        } while ( y < (2*SIZE) || y > (PROG_HEIGHT - (2*SIZE)));

        playerScored = false;
        
        SIZE_OF_BORDER_AND_GOLF_BALL = SIZE + 2*BORDER_SIZE;

        repaint();
    }
    
    // Methods
    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent( g);
        Graphics2D graphics2D = (Graphics2D) g;

        // Anti-Aliasing
        graphics2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Hole Border
        graphics2D.setColor( BORDER_COLOR);
        graphics2D.fillOval( x - BORDER_SIZE, y - BORDER_SIZE, SIZE_OF_BORDER_AND_GOLF_BALL, SIZE_OF_BORDER_AND_GOLF_BALL);

        // Hole
        graphics2D.setColor( COLOR);
        graphics2D.fillOval( x, y, SIZE, SIZE);
    }
}
