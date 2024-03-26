import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RestaurantGUI {
    private JFrame frame;
    private JTextField itemField, tableNumberField;
    private JButton addButton;
    private JTextArea statusArea;
    private Restaurant restaurant; 

    public RestaurantGUI(Restaurant restaurant) {
        this.restaurant = restaurant;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Restaurant Ordering System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel("Table Number:"));
        tableNumberField = new JTextField(5);
        panel.add(tableNumberField);
        
        panel.add(new JLabel("Dish Item:"));
        itemField = new JTextField(10);
        panel.add(itemField);
        
        addButton = new JButton("Add Dish");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDish();
            }
        });
        panel.add(addButton);
        
        statusArea = new JTextArea(10, 30);
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        frame.add(scrollPane, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private void addDish() {
        try {
            int tableNumber = Integer.parseInt(tableNumberField.getText());
            String item = itemField.getText();
            Dish dish = new Dish(tableNumber, item);
            restaurant.addDish(dish); 
            itemField.setText("");
            tableNumberField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid table number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateStatus(String status) {
        statusArea.append(status + "\n");
    }
    
    // Main method to start the GUI
    public static void main(String[] args) {
        // Initialize your Restaurant and start the GUI
        Restaurant restaurant = new Restaurant();
        new RestaurantGUI(restaurant);
    }
}
