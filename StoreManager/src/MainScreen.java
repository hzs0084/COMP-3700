import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    public JButton productButton = new JButton("Product View"); // This command helps to create a button to click on the UI
    public JButton customerButton = new JButton("Customer View");
    public JButton orderButton = new JButton("Order View");

    public MainScreen() {

        this.setTitle("Main Screen");       // Set the title of the UI Window
        this.setSize(new Dimension(600, 300));  //Set the dimension of the UI Window
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(productButton);     //You use JPanel to add buttons to the main screen
        buttonPanel.add(customerButton);    //In the previous command you create the buttons but you don't add them to the UI
        buttonPanel.add(orderButton);       //This actually adds them to the UI

        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreManager.getInstance().getProductView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //We need to gather the instances and now load each view
                StoreManager.getInstance().getProductView().setVisible(true); // Show the ProductView!      //This two commands help you load the view after you click on the said buttons
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreManager.getInstance().getOrderView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                StoreManager.getInstance().getOrderView().setVisible(true);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreManager.getInstance().getCustomerView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //We need to gather the instances and now load each view
                StoreManager.getInstance().getCustomerView().setVisible(true); // Show the ProductView!      //This two commands help you load the view after you click on the said buttons
            }
        });

        this.getContentPane().add(buttonPanel);

    }
}
