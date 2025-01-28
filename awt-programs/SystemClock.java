import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemClock extends Frame {
    private Label timeLabel;
    
    public SystemClock() {
        setSize(400, 200); 
        setTitle("System Clock - ADx");         // Set the window title
        setLayout(new GridBagLayout());         // Use GridBagLayout for simple alignment
        setVisible(true); 
        
        // Create a label to display time
        timeLabel = new Label();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));    // Set font size and style
        add(timeLabel);                                         // Add label to the frame
        
        // Handle window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        updateClock();
    }
    
    // Method to update the clock every second
    private void updateClock() {
        Thread clockThread = new Thread(() -> {
            while (true) {
                // Get the current system time
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String time = sdf.format(new Date());
                
                // Update the label with the current time
                timeLabel.setText(time);
                
                try {
                    // Wait for 1 second before updating the time again
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        clockThread.start();                        // Start the clock thread
    }
    
    public static void main(String[] args) {
        new SystemClock();                          // Create an instance of SystemClock to display the window
    }
}
