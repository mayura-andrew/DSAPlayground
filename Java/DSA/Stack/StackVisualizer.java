package Stack;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class StackVisualizer extends JFrame {
    private Stack<Integer> stack;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField inputField;

    public StackVisualizer() {
            Stack<Integer> stack = new Stack<>();
            listModel = new DefaultListModel<>();
            list = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(list);

            inputField = new JTextField();
            JButton pushButton = new JButton("Push");
        pushButton.addActionListener(e -> {
            String inputValue = inputField.getText();
            if (!inputValue.isEmpty()) {
                try {
                    int value = Integer.parseInt(inputValue);
                    stack.push(value);
                    listModel.addElement(String.valueOf(value));
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton popButton = new JButton("Pop");
        popButton.addActionListener(e -> {
            if (!stack.isEmpty()) {
                stack.pop();
                listModel.removeElementAt(listModel.size() - 1);
            } else {
                JOptionPane.showMessageDialog(this, "Stack is empty, cannot pop.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(pushButton, BorderLayout.WEST);
        inputPanel.add(popButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StackVisualizer::new);
    }
}