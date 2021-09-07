import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.BorderLayout;

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
        
        // Program Code
        // Game Panel
        panel.setBounds( 0, 0, frame.getWidth(), frame.getHeight());
        frame.add( panel, BorderLayout.CENTER);
        
        frame.setTitle( PROG_NAME);
        frame.setPreferredSize( new Dimension( WIDTH, HEIGHT));
        frame.setResizable( false);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setVisible(true);
    }
}