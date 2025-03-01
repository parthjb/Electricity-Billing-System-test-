package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment_bill extends JFrame implements ActionListener {

    JButton back;
    String meter;
    payment_bill(String meter){
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/online-payments");
            j.setBounds(400,150,800,600);
        }catch (Exception E)
        {
            E.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html>Error! Error!</html>");
        }


        JScrollPane pane =new JScrollPane(j);
        add(pane);

        back = new JButton("Back");
        back.setBounds(600,20,80,30);
        back.addActionListener(this);
        j.add(back);

        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
    }

    public static void main(String[]args)
    {
        new payment_bill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new pay_bill(meter);
    }
}
