import java.awt.*;
import java.awt.event.*;

public class DialogBox {
    public static void main(String[] args) {
        Frame frame = new Frame("Dialog - ADx");
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        Button button = new Button("Surprise me!");
        frame.add(button); // Automatically centered by GridBagLayout

        // Create a modal dialog with a message and a close button
        Dialog dialog = new Dialog(frame, "SURPRISE!", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));  // Center and add space between components

        // Add a label and a close button to the dialog
        Label message = new Label("Happy New Year!");
        message.setFont(new Font("Arial", Font.BOLD, 28));
        Button closeButton = new Button("Close");

        // Add components to the dialog (message and button on separate lines)
        dialog.add(message);
        dialog.add(closeButton);

        // Event to show the dialog
        button.addActionListener(e -> dialog.setVisible(true));

        // Event to close the dialog
        closeButton.addActionListener(e -> dialog.setVisible(false));

        // Handle frame closing
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
