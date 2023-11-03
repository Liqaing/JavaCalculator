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

    Font myFont = new Font("serif", Font.BOLD, 30);

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
        frame.add(textField);


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
