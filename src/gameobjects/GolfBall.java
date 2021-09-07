package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

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
    private final int BORDER_SIZE = 2;
    private final int PROG_WIDTH;
    private final int PROG_HEIGHT;
    private final int SIZE_OF_BORDER_AND_GOLF_BALL;
    private CustomMouseListener listener;
    private Point initialDragPoint;
    private Point lastDragPoint;
    private int speed;
    public final int SIZE = 20;

    private Hole hole;
    public int x;
    public int y;
    
    // Constructors
    public GolfBall( int width, int height, Hole hole) {
        speed = 0;
        listener = new CustomMouseListener();

        PROG_WIDTH = width;
        PROG_HEIGHT = height;
        
        this.hole = hole;

        x = PROG_WIDTH - hole.x;
        y = PROG_HEIGHT - hole.y;
        
        SIZE_OF_BORDER_AND_GOLF_BALL = SIZE + 2*BORDER_SIZE;

        addMouseListener( listener);

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

    

    private int calculateSpeed( Point init, Point last) {
        int newSpeed = 0;
        
        newSpeed = (int) Math.sqrt( Math.pow( Math.abs( init.getX() - last.getX()), 2) + Math.pow( Math.abs( init.getY() - last.getY()), 2));

        speed = newSpeed;
        return speed;
    }

    private class CustomMouseListener implements MouseListener {

        private CustomMouseListener() {
            System.out.println( "CustomMouseListener initialized.");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println( "clicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println( "pressed");
            initialDragPoint = MouseInfo.getPointerInfo().getLocation();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println( "released");
            lastDragPoint = MouseInfo.getPointerInfo().getLocation();
            System.out.println( "Speed: " + calculateSpeed( initialDragPoint, lastDragPoint));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println( "entered");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println( "exited");
        }
    }
}
