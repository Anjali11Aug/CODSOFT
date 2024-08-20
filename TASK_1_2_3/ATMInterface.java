import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface extends JFrame {
    // This is where I store how much money I have
    int balance = 1000; 

    // These are for showing information on the screen
    JLabel balanceLabel;
    JTextField amountField;
    JTextArea messageArea;

    // This is where I make the ATM window
    public ATMInterface() {
        // Give the window a title and size
        setTitle("My ATM");
        setSize(300, 400);

        // Make sure the window closes when I click the 'x' button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Arrange everything nicely in the window
        setLayout(new FlowLayout());

        // Show how much money I have
        balanceLabel = new JLabel("Balance: $" + balance);
        add(balanceLabel);

        // Make buttons to check balance, deposit, and withdraw
        JButton checkBalanceButton = new JButton("Check Balance");
        add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit");
        add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        add(withdrawButton);

        // Make a place to type the amount
        amountField = new JTextField(10);
        add(amountField);

        // Make a place to show messages
        messageArea = new JTextArea(10, 25);
        messageArea.setEditable(false); // I don't want the user to type here
        add(messageArea);

        // What to do when the "Check Balance" button is clicked
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageArea.setText("Your balance is: $" + balance);
            }
        });

        // What to do when the "Deposit" button is clicked
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the amount the user typed
                String amountText = amountField.getText();

                try {
                    // Try to convert the amount to a number
                    int amount = Integer.parseInt(amountText);
                    if (amount > 0) {
                        // Add the money to my balance
                        balance = balance + amount;
                        // Update the balance label
                        updateBalance();
                        // Show a message saying the deposit was successful
                        messageArea.setText("You deposited $" + amount);
                    } else {
                        // Show a message if the amount is not positive
                        messageArea.setText("Enter a positive number");
                    }
                } catch (NumberFormatException ex) {
                    // Show a message if the user typed something that's not a number
                    messageArea.setText("Invalid amount. Please enter a number.");
                }

                // Clear the amount field for the next time
                amountField.setText("");
            }
        });

        // What to do when the "Withdraw" button is clicked
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the amount the user typed
                String amountText = amountField.getText();

                try {
                    // Try to convert the amount to a number
                    int amount = Integer.parseInt(amountText);
                    if (amount > 0) {
                        // Check if I have enough money
                        if (balance >= amount) {
                            // Subtract the money from my balance
                            balance = balance - amount;
                            // Update the balance label
                            updateBalance();
                            // Show a message saying the withdrawal was successful
                            messageArea.setText("You withdrew $" + amount);
                        } else {
                            // Show a message if I don't have enough money
                            messageArea.setText("Not enough money");
                        }
                    } else {
                        // Show a message if the amount is not positive
                        messageArea.setText("Enter a positive number");
                    }
                } catch (NumberFormatException ex) {
                    // Show a message if the user typed something that's not a number
                    messageArea.setText("Invalid amount. Please enter a number.");
                }

                // Clear the amount field for the next time
                amountField.setText("");
            }
        });
    }

    // This updates the balance label on the screen
    void updateBalance() {
        balanceLabel.setText("Balance: $" + balance);
    }

    // This starts the ATM program
    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        atm.setVisible(true);
    }
}