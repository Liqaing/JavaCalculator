import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10]; // Hold number button from 0 to 9
    JButton[] funcButtons = new JButton[10]; // Hold function button + - * / ...
    JButton addButton, subButton, mulButton, divButton, negButton,
            decButton, equButton, delButton, clrButton, sqrtButton;
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
        delButton = new JButton("De");
        clrButton = new JButton("Cl");
        negButton = new JButton("+/-");
        sqrtButton = new JButton("√");

        // Add button to funcButton array
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;
        funcButtons[9] = sqrtButton;

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

        //// Delete and Clear button is not in the grid layout on the frame
        //// Set up separate bound for both button
        //delButton.setBounds(50, 430, 130, 50);
        //clrButton.setBounds(220, 430, 130, 50);
        //frame.add(delButton);
        //frame.add(clrButton);

        // Set up panel
        panel = new JPanel(); // Create panel obj
        panel.setBounds(50, 100, 300, 400); // Set up width, height and location for panel
        // Set panel layout to grid
        // Set rows and cols to 5 by 4, and add space on the side
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Add button to the panel
        // row 1
        panel.add(sqrtButton);
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(divButton);

        // row 2
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);

        // row 3
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);

        // row 4
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);

        // row 5
        panel.add(negButton);
        panel.add(numButtons[0]);
        panel.add(decButton);
        panel.add(equButton);

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

        // If numButtons is click
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
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                // Set operator to +
                operator = '+';
                // Clear text field
                textField.setText("");
            }
        }

        // If the sub button was clicked
        if (e.getSource() == subButton) {
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        }

        // If the mul button was clicked
        if (e.getSource() == mulButton) {
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
        }

        // If the div button was clicked
        if (e.getSource() == divButton) {
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
        }

        // If the negate button was clicked
        if (e.getSource() == negButton) {
            if (!textField.getText().isEmpty()) {
                double value = Double.parseDouble(textField.getText());
                value *= -1;
                textField.setText(String.valueOf(value));
            }
        }

        // If the sqrt button was clicked
        if (e.getSource() == sqrtButton) {
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                num1 = Math.sqrt(num1);
                textField.setText(String.valueOf(num1));
            }
        }

        // If the equal button was clicked
        if (e.getSource() == equButton) {
            // Retrieve value for num2
            if (!textField.getText().isEmpty()) {
                num2 = Double.parseDouble(textField.getText());
            }
            // Check which operator was clicked
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    break;
            }
            // Update text field to result
            textField.setText(String.valueOf(result));
            // Update num1 to result, to continue using result for next calculation
            num1 = result;

        }

        // If the clear button was clicked
        if (e.getSource() == clrButton) {
            num1 = 0;
            num2 = 0;
            result = 0;
            textField.setText("");
        }

        // If the delete button was clicked
        if (e.getSource() == delButton) {
            // Retrieve the current value from textField
            String value = textField.getText();
            // Set textField to sub string of value from 0 to length of string - 1
            if (!value.isEmpty()) {
                textField.setText(value.substring(0, value.length()-1));
            }
        }
    }
}
