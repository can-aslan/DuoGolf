import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Graphics;

import gameobjects.*;

/**
 * A simple panel class which extends JPanel
 * @author Yağız Can Aslan
 * @version 07.09.2021
*/
public class GamePanel extends JPanel
{
    
    // Properties
    final int WIDTH;
    final int HEIGHT;
    final Color LIME;
    Hole hole;

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

        repaint();
    }
    
    // Methods
    @Override
    public void paintComponent( Graphics g) {
        super.paintComponent( g);

        hole.paintComponent( g);
    }
}