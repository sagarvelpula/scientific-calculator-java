import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {
    JTextField textField;
    double num1, num2, result;
    String operator;
    double memory = 0;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "sqrt",
            "log", "MC", "MR", "M+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            if ("0123456789.".contains(command)) {
                textField.setText(textField.getText() + command);
            } else if ("+-*/".contains(command)) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            } else if ("=".equals(command)) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> result = num1 / num2;
                }
                textField.setText("" + result);
            } else if ("sin".equals(command)) {
                result = Math.sin(Math.toRadians(Double.parseDouble(textField.getText())));
                textField.setText("" + result);
            } else if ("cos".equals(command)) {
                result = Math.cos(Math.toRadians(Double.parseDouble(textField.getText())));
                textField.setText("" + result);
            } else if ("tan".equals(command)) {
                result = Math.tan(Math.toRadians(Double.parseDouble(textField.getText())));
                textField.setText("" + result);
            } else if ("sqrt".equals(command)) {
                result = Math.sqrt(Double.parseDouble(textField.getText()));
                textField.setText("" + result);
            } else if ("log".equals(command)) {
                result = Math.log(Double.parseDouble(textField.getText()));
                textField.setText("" + result);
            } else if ("MC".equals(command)) {
                memory = 0;
                textField.setText("");
            } else if ("MR".equals(command)) {
                textField.setText("" + memory);
            } else if ("M+".equals(command)) {
                memory += Double.parseDouble(textField.getText());
                textField.setText("");
            }
        } catch (NumberFormatException ex) {
            textField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
