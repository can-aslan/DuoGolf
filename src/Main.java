import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Main class for DuoGolf
 * @author Yağız Can Aslan
 * @version Pre-Alpha 0.1
*/ 
public class Main
{
    public static void main( String args[] )
    {
        // Constants
        final String VERSION = "Pre-Alpha 0.1";
        final String PROG_NAME = "DuoGolf " + VERSION;
        final int WIDTH = 1280;
        final int HEIGHT = 720;
        
        // Variables
        JFrame frame = new JFrame();
        GamePanel panel = new GamePanel( WIDTH, HEIGHT);
        CustomMouseListener listener;
        
        // Program Code
        // Game Panel
        panel.setBounds( 0, 0, frame.getWidth(), frame.getHeight());
        frame.add( panel, BorderLayout.CENTER);
        
        frame.setTitle( PROG_NAME);
        frame.setPreferredSize( new Dimension( WIDTH, HEIGHT));
        frame.setResizable( true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setVisible(true);

        listener = new CustomMouseListener( panel);
        panel.addMouseListener( listener);
    }

    private static class CustomMouseListener implements MouseListener {

        private Point initialDragPoint;
        private Point lastDragPoint;
        private GamePanel panel;

        private CustomMouseListener( GamePanel panel) {
            this.panel = panel;
        }
    
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            initialDragPoint = MouseInfo.getPointerInfo().getLocation();
        }
    
        @Override
        public void mouseReleased(MouseEvent e) {
            lastDragPoint = MouseInfo.getPointerInfo().getLocation();

            int speed = calculateSpeed( initialDragPoint, lastDragPoint);
            int direction = calculateDirection( initialDragPoint, lastDragPoint);

            System.out.println( "Speed: " + speed);
            System.out.println( "Direction: " + direction);

            // panel.getGolfBall().move( 120, 120);
            panel.getGolfBall().setSpeed( speed);
            panel.getGolfBall().setDirection( direction);
        }
    
        private int calculateSpeed( Point init, Point last) {
            int newSpeed = 0;
            double a = Math.abs( init.getX() - last.getX());
            double b = Math.abs( init.getY() - last.getY());

            // Calculate the distance between the initial and the last point using Pythagorean Theorem (a^2 + b^2 = c^2)
            newSpeed = (int) Math.sqrt( Math.pow( a, 2) + Math.pow( b, 2));
    
            return newSpeed;
        }

        private int calculateDirection( Point init, Point last) {
            int direction = 0;
            double a = init.getX() - last.getX();
            double b = init.getY() - last.getY();

            // Get the "Angle of Attack" of the line drawn through arctan
            direction = (int) Math.toDegrees( Math.atan( b/a));
    
            return direction;
        }
    }
}