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
    private final int FRICTION = 10;
    private final int BORDER_SIZE = 2;
    private final int PROG_WIDTH;
    private final int PROG_HEIGHT;
    private final int SIZE_OF_BORDER_AND_GOLF_BALL;
    public final int SIZE = 20;

    private Hole hole;
    private int speed;
    private int velocityX = 3;
    private int velocityY = 3;
    private int direction;
    public int x;
    public int y;
    
    // Constructors
    public GolfBall( int width, int height, Hole hole) {
        speed = 0;

        PROG_WIDTH = width;
        PROG_HEIGHT = height;
        
        this.hole = hole;

        x = PROG_WIDTH - hole.x;
        y = PROG_HEIGHT - hole.y;
        
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
        
        // Move the Golf Ball if necessary
        move( x + velocityX, y + velocityY);

        /*
        if ( speed > 0 ) {
            speed = speed - FRICTION;
        }
        */

        // Golf Ball collision detection with program borders
        if ( x + SIZE >= PROG_WIDTH || x <= 0 ) {
            velocityX = velocityX * (-1);
        }
        
        if ( y + SIZE >= PROG_HEIGHT || y <= 0 ) {
            velocityY = velocityY * (-1);
        }

        // Golf Ball Border
        graphics2D.setColor( BORDER_COLOR);
        graphics2D.fillOval( x - BORDER_SIZE, y - BORDER_SIZE, SIZE_OF_BORDER_AND_GOLF_BALL, SIZE_OF_BORDER_AND_GOLF_BALL);

        // Golf Ball
        graphics2D.setColor( COLOR);
        graphics2D.fillOval( x, y, SIZE, SIZE);

        // TEMPORARY Bounce Border
        graphics2D.drawRect(0, 0, PROG_WIDTH, PROG_HEIGHT);
    }

    public void move( int newX, int newY) {
        if ( !setX( newX) ) {
            System.out.println( "ERROR: New x-coordinate value for the Golf Ball is either too large or too small.");
        }

        if ( !setY( newY) ) {
            System.out.println( "ERROR: New y-coordinate value for the Golf Ball is either too large or too small.");
        }
    }

    @Deprecated
    private boolean setCheckX( int newX) {
        if ( newX >= 0 && newX <= PROG_WIDTH ) {
            x = newX;
            return true;
        }
        
        return false;
    }

    @Deprecated
    private boolean setCheckY( int newY) {
        if ( newY >= 0 && newY <= PROG_WIDTH ) {
            y = newY;
            return true;
        }
        
        return false;
    }

    private boolean setX( int newX) {
        x = newX;
        return true;
    }

    private boolean setY( int newY) {
        y = newY;
        return true;
    }

    public void setSpeed( int newSpeed) {
        speed = newSpeed;
    }

    public void setDirection( int newDirection) {
        direction = newDirection;
    }
}
