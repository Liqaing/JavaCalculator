import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10]; // Hold number 0 - 9
    JButton[] funcButtons = new JButton[8]; // Hold + - * / ...
    JButton addButton, subButton, mulButton, divButton,
            decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("serif", Font.BOLD, 25);

    double num1 = 0, num2 = 0, result = 0;
    char operator; // Hold operator such as + - * /

    public Calculator() {
        // Set up window frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension minimumSize = new Dimension(420, 550);
        frame.setMinimumSize(minimumSize);
        frame.setLayout(null);

        // Set up Text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setFocusable(false);
        frame.add(textField);

        // Create bottom obj
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        // Add button to funcButton array
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;

        for (JButton button : funcButtons) {
            // Add action listener to button
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        // Set up number button
        for (int i = 0, len = numButtons.length; i < len; i++) {
            // Instantiate JButton and assign it to numButton array, Display value of i in button
            numButtons[i] = new JButton(String.valueOf(i));
            // Add action listener to button
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        // Delete and Clear button is not in the grid layout on the frame
        // Set up separate bound for both button
        delButton.setBounds(50, 430, 130, 50);
        clrButton.setBounds(220, 430, 130, 50);
        frame.add(delButton);
        frame.add(clrButton);

        // Set up panel
        panel = new JPanel(); // Create panel obj
        panel.setBounds(50, 100, 300, 300); // Set up width, height and location for panel
        // Set panel layout to grid
        // Set rows and cols to 4 by 4, and add space on the side
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add button to the panel
        // row 1
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(funcButtons[0]);

        // row 2
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(funcButtons[1]);

        // row 3
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(funcButtons[2]);

        // row 4
        panel.add(funcButtons[4]);
        panel.add(numButtons[0]);
        panel.add(funcButtons[5]);
        panel.add(funcButtons[3]);

        // add panel to frame
        frame.add(panel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        // Create new obj
        Calculator calc = new Calculator();
    }

    // Implement action listener interface
    @Override
    public void actionPerformed(ActionEvent e) {

        // Loop through every button in the array
        for (JButton button: numButtons) {
            // Check if the element that trigger the event is the current button
            if (e.getSource() == button) {
                // Update textField to textField + number which the button is holding
                textField.setText(textField.getText().concat(button.getText()));
            }
        }

        // If the decimal button was clicked
        if (e.getSource() == decButton) {
            // Update textField
            textField.setText(textField.getText().concat("."));
        }

        // If the add button was clicked
        if (e.getSource() == addButton) {
            // Convert value in textField to double and store inside num1
            num1 = Double.parseDouble(textField.getText());
            // Set operator to +
            operator = '+';
            // Clear text field
            textField.setText("");
        }


    }
}
