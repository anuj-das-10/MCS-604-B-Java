import java.awt.*;
import java.awt.event.*;

public class ListBox {
    public static void main(String[] args) {
        Frame frame = new Frame("Frame-ListBox");
        frame.setSize(600, 400);
        frame.setLayout(null); // No layout manager for manual positioning

        // Create a Label
        Label label = new Label("Select item(s):");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(50, 70, 250, 30);
        frame.add(label);

        // Create a List (ListBox) with multiple items and enable multiple selection
        List listBox = new List(6, true); // 6 rows visible, multi-selection enabled
        listBox.setBounds(50, 100, 150, 150);
        listBox.add("Potato");
        listBox.add("Tomato");
        listBox.add("Apple");
        listBox.add("Pineapple");
        listBox.add("Orange");
        listBox.add("Mango");
        frame.add(listBox);

        // Create a Button to show selected items
        Button button = new Button("Show Selections");
        button.setBounds(220, 100, 150, 30);
        frame.add(button);

        // Create a Label to display the selected items
        Label resultLabel = new Label();
        resultLabel.setBounds(220, 150, 350, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(resultLabel);

        // Add an Action Listener to the Button
        button.addActionListener(e -> {
            String[] selectedItems = listBox.getSelectedItems();

            if (selectedItems.length > 0) {
                String s = "You have selected: ";
                StringBuilder result = new StringBuilder(s);
                for (String item : selectedItems) {
                    result.append(item).append(", ");
                }
                // Remove the trailing comma and space
                result.setLength(result.length() - 2);
                resultLabel.setText(result.toString());
                System.out.println(result.toString());
            } 
            else {
                resultLabel.setText("No item selected");
                System.out.println("No item selected");
            }
        });

        // Add a Window Listener to handle window close events
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
