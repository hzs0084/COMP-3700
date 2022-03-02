import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderController implements ActionListener {

    OrderView myView;
    DataAccess myDAO;

    public OrderController(OrderView view, DataAccess dao) {
        myView = view;
        myDAO = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == myView.btnLoad) {
            loadOrderAndDisplay();

        }

        if(e.getSource() == myView.btnSave) {
            saveOrder();

        }

    }

    private void saveOrder() {

        System.out.println("Button Save in OrderView is clicked!");
        OrderModel orderModel = new OrderModel();

        try {

            int orderID = Integer.parseInt(myView.txtOrderID.getText());
            orderModel.setOrderID(orderID);
            orderModel.setOrderDate(myView.txtOrderDate.getText());
            orderModel.setCustomerName(myView.txtCustomerName.getText());
            orderModel.setTotalCost(Double.parseDouble(myView.txtTotalCost.getText()));
            orderModel.setTotalTax(Double.parseDouble(myView.txtTotalTax.getText()));

            myDAO.saveOrder(orderModel);
            JOptionPane.showMessageDialog(null, "Order saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for OrderID");
            ex.printStackTrace();
        }

    }


    private void loadOrderAndDisplay() {

        try {
            int orderID = Integer.parseInt(myView.txtOrderID.getText());
            OrderModel orderModel = myDAO.loadOrder(orderID);
            myView.txtOrderDate.setText(orderModel.getOrderDate());
            myView.txtCustomerName.setText(orderModel.getCustomerName());
            myView.txtTotalCost.setText(String.valueOf(orderModel.getTotalCost()));
            myView.txtTotalTax.setText(String.valueOf(orderModel.getTotalTax()));

        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for OrderID");
            ex.printStackTrace();
        }
    }


}



