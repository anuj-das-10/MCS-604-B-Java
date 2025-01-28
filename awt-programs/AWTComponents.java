import java.awt.*;
import java.awt.event.*;

public class AWTComponents {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Components - ADx");
        frame.setSize(500, 400);
        frame.setLayout(null);
        
        // ----- Choice (Dropdown) -----
        Label choiceLabel = new Label("Select a fruit:");
        choiceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        choiceLabel.setBounds(50, 50, 100, 20);
        frame.add(choiceLabel);

        Choice choice = new Choice();
        choice.setBounds(160, 50, 150, 20);
        choice.add("Apple");
        choice.add("Banana");
        choice.add("Orange");
        frame.add(choice);

        // ----- Radio Buttons -----
        Label genderLabel = new Label("Select Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 14));
        genderLabel.setBounds(50, 90, 120, 20);
        frame.add(genderLabel);

        CheckboxGroup genderGroup = new CheckboxGroup();
        Checkbox maleRadio = new Checkbox("Male", genderGroup, false);
        maleRadio.setFont(new Font("Arial", Font.BOLD, 14));
        maleRadio.setBounds(180, 90, 80, 20);
        Checkbox femaleRadio = new Checkbox("Female", genderGroup, false);
        femaleRadio.setFont(new Font("Arial", Font.BOLD, 14));
        femaleRadio.setBounds(280, 90, 100, 20);
        frame.add(maleRadio);
        frame.add(femaleRadio);

        // ----- Checkbox -----
        Checkbox checkbox = new Checkbox(" I agree to the terms and conditions!");
        checkbox.setFont(new Font("Arial", Font.BOLD, 13));
        checkbox.setBounds(50, 130, 250, 30);
        frame.add(checkbox);

        // ----- Button to Show Selections -----
        Button submitButton = new Button("Submit");
        submitButton.setBounds(50, 170, 80, 30);
        frame.add(submitButton);

        // ----- Label to Display Results -----
        Label resultLabel = new Label();
        resultLabel.setBounds(50, 210, 400, 30);
        frame.add(resultLabel);

        // ----- Event Handling -----
        submitButton.addActionListener(e -> {
            String selectedFruit = choice.getSelectedItem();
            String agreement = checkbox.getState() ? "Agreed" : "Not Agreed";
            String gender = genderGroup.getSelectedCheckbox() != null ?
                    genderGroup.getSelectedCheckbox().getLabel() : "Not Selected";
            
            resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
            resultLabel.setText("Fruit: " + selectedFruit + ", Agreement: " + agreement + ", Gender: " + gender);
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
