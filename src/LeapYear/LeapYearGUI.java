package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JLabel Jlabel;
    public  LeapYearGUI(){
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(tfYear.getText());
                    yearChecker(year);
                }catch (NumberFormatException i){
                    JOptionPane.showMessageDialog(panel1,"Input Must be a Number");
                }

            }
        });
    }
    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel1);
        app.setTitle("Leap Year Checker");
        app.setSize(500, 700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    public void yearChecker(int year){
        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
            JOptionPane.showMessageDialog(panel1,"Leap Year");
        else
            JOptionPane.showMessageDialog(panel1,"Not a Leap Year");
    }
}

