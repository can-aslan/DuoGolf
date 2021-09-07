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
    private final Color BORDER_COLOR = new Color( 50, 50, 50); // Dark Gray
    private final int BORDER_SIZE = 2;
    private final int PROG_WIDTH;
    private final int PROG_HEIGHT;
    public final int SIZE = 30;
    private boolean playerScored;
    public int x;
    public int y;
    
    // Constructors
    public Hole( int width, int height) {
        PROG_WIDTH = width;
        PROG_HEIGHT = height;
        
        x = (int) (Math.random() * PROG_WIDTH / 2);
        y = (int) (Math.random() * PROG_HEIGHT / 2);
        
        playerScored = false;
        
        repaint();
    }
    
    // Methods
    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent( g);
        Graphics2D graphics2D = (Graphics2D) g;

        // Anti-Aliasing
        graphics2D.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Hole
        graphics2D.setColor( BORDER_COLOR);
        graphics2D.fillOval( x, y, SIZE, SIZE);

        // TODO Hole Border
    }
}
