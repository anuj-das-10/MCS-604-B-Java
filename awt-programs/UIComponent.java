import java.awt.*;
import java.awt.event.*;

class UIComponent {
    public static void main(String[] args) {
        Frame frame = new Frame("Simple AWT UI");
        frame.setSize(400, 300);
        frame.setLayout(null);      // Disable layout manager

        // Add a Label
        Label label = new Label("Enter your name:");
        label.setBounds(50, 50, 120, 30);
        frame.add(label);

        // Add a TextField
        TextField textField = new TextField();
        textField.setBounds(180, 50, 150, 30);
        frame.add(textField);

        // Add a Button
        Button button = new Button("Submit");
        button.setBounds(150, 100, 80, 30);
        frame.add(button);

        // Add an Action Listener for the Button
        button.addActionListener(e -> {
            String name = textField.getText();
            System.out.println("Hello, " + name + "!");
        });

        // Add Window Listener to close the frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
