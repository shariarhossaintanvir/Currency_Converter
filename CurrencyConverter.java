import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CurrencyConverter {

    public static void main(String[] args) {

        // ================= FRAME =================
        JFrame frame = new JFrame("Currency Converter");
        //frame.setSize(450, 380);
        frame.setBounds(50, 50, 450, 410);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(235, 240, 250));

        // ================= SHADOW PANEL (CARD SHADOW) =================
        JPanel shadowPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 25)); // shadow
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        shadowPanel.setBounds(44, 34, 350, 300);
        shadowPanel.setOpaque(false);
        frame.add(shadowPanel);

        // ================= MAIN CARD PANEL =================
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        panel.setBounds(40, 30, 350, 300);
        panel.setOpaque(false);
        panel.setLayout(null);
        frame.add(panel);

        // ================= FONTS =================
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);

        // ================= TITLE =================
        JLabel title = new JLabel("Currency Converter", SwingConstants.CENTER);
        title.setBounds(0, 20, 350, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(title);

        // ================= AMOUNT LABEL =================
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 70, 80, 25);
        amountLabel.setFont(labelFont);
        panel.add(amountLabel);

        // ================= AMOUNT SHADOW =================
        JPanel amountShadow = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(0, 0, 0, 20));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
            }
        };
        amountShadow.setBounds(122, 68, 180, 35);
        amountShadow.setOpaque(false);
        panel.add(amountShadow);

        // ================= AMOUNT FIELD =================
        JTextField amountField = new JTextField();
        amountField.setBounds(120, 65, 180, 35);
        amountField.setFont(fieldFont);
        amountField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panel.add(amountField);

        // ================= CURRENCIES =================
        String[] currencies = {"USD", "BDT", "EUR", "INR", "GBP", "JPY"};

        // ================= FROM =================
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(30, 115, 80, 25);
        fromLabel.setFont(labelFont);
        panel.add(fromLabel);

        /*JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(120, 110, 80, 35);
        fromCurrency.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));
        panel.add(fromCurrency);*/

        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(120, 110, 80, 35);
        fromCurrency.setBackground(Color.WHITE);
        fromCurrency.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));
        panel.add(fromCurrency);

        // ================= TO =================
        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(210, 115, 40, 25);
        toLabel.setFont(labelFont);
        panel.add(toLabel);

        /*JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(250, 110, 80, 35);
        toCurrency.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));
        panel.add(toCurrency);*/

        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(250, 110, 80, 35);
        toCurrency.setBackground(Color.WHITE);
        toCurrency.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1, true));
        panel.add(toCurrency);

        // ================= ROUNDED BUTTON =================
        JButton convertButton = new JButton("Convert") {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                super.paintComponent(g);
            }
        };
        convertButton.setBounds(100, 165, 150, 40);
        convertButton.setFont(buttonFont);
        convertButton.setForeground(Color.WHITE);
        convertButton.setBackground(new Color(0, 120, 215));
        convertButton.setContentAreaFilled(false);
        convertButton.setBorderPainted(false);
        convertButton.setFocusPainted(false);

        convertButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                convertButton.setBackground(new Color(0, 100, 190));
            }
            public void mouseExited(MouseEvent e) {
                convertButton.setBackground(new Color(0, 120, 215));
            }
        });

        panel.add(convertButton);

        // ================= RESULT SHADOW =================
        JPanel resultShadow = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(0, 0, 0, 20));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        resultShadow.setBounds(32, 228, 290, 35);
        resultShadow.setOpaque(false);
        panel.add(resultShadow);

        // ================= RESULT LABEL =================
        JLabel resultLabel = new JLabel("Result:", SwingConstants.CENTER);
        resultLabel.setBounds(30, 225, 290, 35);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        panel.add(resultLabel);

        // ================= BUTTON ACTION (ORIGINAL OFFLINE LOGIC) =================
        convertButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();

                double amountInUSD = 0;
                if (from.equals("USD")) amountInUSD = amount;
                else if (from.equals("BDT")) amountInUSD = amount * 0.0091;
                else if (from.equals("EUR")) amountInUSD = amount * 1.08;
                else if (from.equals("INR")) amountInUSD = amount * 0.012;
                else if (from.equals("GBP")) amountInUSD = amount * 1.27;
                else if (from.equals("JPY")) amountInUSD = amount * 0.0068;

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

        // ================= SHOW =================
        frame.setVisible(true);
    }
}
