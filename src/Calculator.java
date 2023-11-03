import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numButton = new JButton[10]; // Hold number 0 - 9
    JButton[] funcButton = new JButton[8]; // Hold + - * / ...
    JButton addButton, subButton, mulButton, divButton,
            decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("serif", Font.BOLD, 25);

    double num1 = 0, num2 = 0, result = 0;
    char operation; // Hold operation such as + - * /

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
        funcButton[0] = addButton;
        funcButton[1] = subButton;
        funcButton[2] = mulButton;
        funcButton[3] = divButton;
        funcButton[4] = decButton;
        funcButton[5] = equButton;
        funcButton[6] = delButton;
        funcButton[7] = clrButton;

        for (JButton button : funcButton) {
            // Add action listener to button
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        // Set up number button
        for (int i = 0, len = numButton.length; i < len; i++) {
            // Instantiate JButton and assign it to numButton array, Display value of i in button
            numButton[i] = new JButton(String.valueOf(i));
            // Add action listener to button
            numButton[i].addActionListener(this);
            numButton[i].setFont(myFont);
            numButton[i].setFocusable(false);
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

    }
}
