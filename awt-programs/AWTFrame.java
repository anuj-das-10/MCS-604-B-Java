import java.awt.*;
import java.awt.event.*;

class AWTFrame {
    public static void main(String[] args) {
        Frame frame = new Frame("Frame-ADX!");
        frame.setSize(600, 400);                  // Set Frame Size
        frame.setLayout(new GridBagLayout());      // Set layout manager (optional, default is BorderLayout)
        Label lb = new Label("Welcome to AWT Frame!");
        lb.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(lb);
        frame.setVisible(true);                 // Set Visibility of the Frame

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();                // Close the frame
                System.exit(0);                 // Exit the program
            }
        });
    }
}