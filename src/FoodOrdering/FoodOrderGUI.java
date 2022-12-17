package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame{
    private JPanel panel1;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    List<JRadioButton> Discount;
    List<JCheckBox> Menu;
    public FoodOrderGUI(){
        Menu = new ArrayList<>();
        Menu.add(cBurger);
        Menu.add(cPizza);
        Menu.add(cFries);
        Menu.add(cSoftDrinks);
        Menu.add(cTea);
        Menu.add(cSundae);
        Discount = new ArrayList<>();
        Discount.add(rbNone);
        Discount.add(rb5);
        Discount.add(rb10);
        Discount.add(rb15);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Buy();
                }catch(NullPointerException ee){
                    JOptionPane.showMessageDialog(panel1, "You must order");
                }
            }
        });
    }
    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.panel1);
        app.setTitle("Food Ordering System");
        app.setSize(500,700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void Buy(){
        double total = 0.0;
        int noSelection = 0;
        for(JCheckBox mo: Menu){
            if(mo.isSelected()) {
                if (mo == cPizza) {
                    total = total + 100;
                    noSelection ++;
                }
                if (mo == cBurger) {
                    total = total + 80;
                    noSelection ++;
                }
                if (mo == cFries) {
                    total = total + 65;
                    noSelection ++;
                }
                if (mo == cSoftDrinks) {
                    total = total + 55;
                    noSelection ++;
                }
                if (mo == cTea) {
                    total = total + 50;
                    noSelection ++;
                }
                if (mo == cSundae) {
                    total = total + 40;
                    noSelection ++;
                }
            }
        }
        for(JRadioButton rb: Discount){
            if(rb.isSelected()) {
                if (rb == rb5) {
                    total = total - (total * .05);
                }if( rb == rb10){
                    total = total - (total * .1);
                }if(rb == rb15){
                    total = total-(total * .15);
                }
            }
        }
        if(noSelection == 0){
            throw new NullPointerException();
        }
        JOptionPane.showMessageDialog(panel1, String.format("The total price is Php %.2f", total));
    }
}
