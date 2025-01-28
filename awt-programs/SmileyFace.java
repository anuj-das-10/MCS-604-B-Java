import java.awt.*;
import java.awt.event.*;

public class SmileyFace extends Frame {
    
    public SmileyFace() {
        setSize(400, 400);                  // Set the window size
        setTitle("Smiley Face - ADx");      // Set the window title
        setVisible(true);                   // Make the window visible
        setBackground(Color.BLACK);         // Set the background color to black
    }
    
    // Override the paint method to draw the smiley face
    public void paint(Graphics g) {
        // Use Graphics2D for more control
        Graphics2D g2d = (Graphics2D) g;
        
        // Set color for the face (yellow)
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(100, 100, 200, 200); // Draw face (circle)

        // Set color for the eyes (black)
        g2d.setColor(Color.BLACK);
        g2d.fillOval(150, 150, 30, 30); // Left eye
        g2d.fillOval(220, 150, 30, 30); // Right eye

        // Set color for the mouth (black)
        g2d.setColor(Color.BLACK);

        // Set a thicker stroke for the mouth
        g2d.setStroke(new BasicStroke(10));             // Make the arc bolder

        // Draw a smoother arc (bigger arc for a smoother curve)
        g2d.drawArc(130, 170, 140, 80, 0, -180);        // Draw mouth (arc)
    }
    
    public static void main(String[] args) {
        SmileyFace smiley = new SmileyFace();
        
        // Handle window closing event
        smiley.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
