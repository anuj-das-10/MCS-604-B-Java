import java.awt.*;
import java.awt.event.*;

public class LayoutManager {
    public static void main(String[] args) {
        Frame frame = new Frame("LayoutManagers - ADx");
        frame.setSize(400, 300);
        
        // Create panel and buttons
        Panel panel = new Panel();
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");

        // Add dropdown (Choice) to select LayoutManager
        Choice layoutChoice = new Choice();
        layoutChoice.add("FlowLayout");
        layoutChoice.add("BorderLayout");
        layoutChoice.add("GridLayout");

        // Event listener to switch layouts
        layoutChoice.addItemListener(e -> {
            panel.removeAll();
            panel.add(btn1);
            panel.add(btn2);
            panel.add(btn3);
            panel.add(btn4);
            panel.add(btn5);

            switch (layoutChoice.getSelectedItem()) {
                case "FlowLayout" -> panel.setLayout(new FlowLayout());
                case "BorderLayout" -> {
                    panel.setLayout(new BorderLayout());
                    panel.add(btn1, BorderLayout.NORTH);
                    panel.add(btn2, BorderLayout.SOUTH);
                    panel.add(btn3, BorderLayout.EAST);
                    panel.add(btn4, BorderLayout.WEST);
                    panel.add(btn5, BorderLayout.CENTER);
                }
                case "GridLayout" -> panel.setLayout(new GridLayout(2, 2));
            }
            panel.validate();
        });

        // Set default layout and add components
        panel.setLayout(new FlowLayout());
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);

        // Add dropdown and panel to frame
        frame.add(layoutChoice, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Handle window closing
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
