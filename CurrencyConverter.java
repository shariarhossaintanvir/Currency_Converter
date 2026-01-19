import javax.swing.*;
import java.awt.*;

public class CurrencyConverter {

    public static void main(String[] args) {

        //FRAME
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(450, 380);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(220, 230, 245));

        //PANEL (CARD)
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(40, 30, 350, 300);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        frame.add(panel);

        //FONTS
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);

        //TITLE
        JLabel title = new JLabel("Currency Converter", SwingConstants.CENTER);
        title.setBounds(0, 15, 350, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(title);

        //AMOUNT
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 60, 80, 25);
        amountLabel.setFont(labelFont);
        panel.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(120, 60, 180, 30);
        amountField.setFont(fieldFont);
        panel.add(amountField);

        //CURRENCIES
        String[] currencies = {"USD", "BDT", "EUR", "INR", "GBP", "JPY"};

        //FROM
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(30, 105, 80, 25);
        fromLabel.setFont(labelFont);
        panel.add(fromLabel);

        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(120, 105, 80, 30);
        panel.add(fromCurrency);

        //TO
        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(210, 105, 40, 25);
        toLabel.setFont(labelFont);
        panel.add(toLabel);

        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(250, 105, 80, 30);
        panel.add(toCurrency);

        //BUTTON
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(100, 155, 150, 35);
        convertButton.setFont(buttonFont);
        convertButton.setBackground(new Color(0, 120, 215));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);
        panel.add(convertButton);

        //RESULT
        JLabel resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setBounds(30, 210, 290, 30);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panel.add(resultLabel);

        //BUTTON ACTION
        convertButton.addActionListener(e -> {

            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();

                // ----- STEP 1: FROM -> USD -----
                double amountInUSD = 0;

                if (from.equals("USD")) amountInUSD = amount;
                else if (from.equals("BDT")) amountInUSD = amount * 0.0091;
                else if (from.equals("EUR")) amountInUSD = amount * 1.08;
                else if (from.equals("INR")) amountInUSD = amount * 0.012;
                else if (from.equals("GBP")) amountInUSD = amount * 1.27;
                else if (from.equals("JPY")) amountInUSD = amount * 0.0068;

                // ----- STEP 2: USD -> TO -----
                double result = 0;

                if (to.equals("USD")) result = amountInUSD;
                else if (to.equals("BDT")) result = amountInUSD * 109.5;
                else if (to.equals("EUR")) result = amountInUSD * 0.93;
                else if (to.equals("INR")) result = amountInUSD * 83;
                else if (to.equals("GBP")) result = amountInUSD * 0.79;
                else if (to.equals("JPY")) result = amountInUSD * 147;

                resultLabel.setText("Result: " + String.format("%.2f", result));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
            }
        });

        //SHOW
        frame.setVisible(true);
    }
}

//2nd branch for rayhan