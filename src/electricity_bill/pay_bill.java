package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class pay_bill extends JFrame implements ActionListener {
    String meter;

    JButton pay,back;
    Choice searchMonthCho;
    pay_bill(String meter){
        this.meter=meter;
        setSize(900,600);
        setLocation(300,150);
        setLayout(null);

        JLabel heading = new JLabel("Pay bill");
        heading.setBounds(120,5,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel meterno = new JLabel("Meter number :");
        meterno.setBounds(35,80,200,20);
        add(meterno);

        JLabel meterText = new JLabel("");
        meterText.setBounds(300,80,200,20);
        add(meterText);

        JLabel name = new JLabel("Name :");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nameText = new JLabel("");
        nameText.setBounds(300,140,200,20);
        add(nameText);

        JLabel month = new JLabel("Month :");
        month.setBounds(35,200,200,20);
        add(month);

        searchMonthCho = new Choice();
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");

        searchMonthCho.setBounds(300,200,150,20);

        add(searchMonthCho);

        JLabel unit = new JLabel("Unit :");
        unit.setBounds(35,320,200,20);
        add(unit);

        JLabel unitText = new JLabel();
        unitText.setBounds(300,320,200,20);
        add(unitText);

        JLabel totalBill = new JLabel("Total bill :");
        totalBill.setBounds(35,380,200,20);
        add(totalBill);

        JLabel totalBillText = new JLabel();
        totalBillText.setBounds(300,380,200,20);
        add(totalBillText);

        JLabel status = new JLabel("Status :");
        status.setBounds(35,440,200,20);
        add(status);

        JLabel statusText = new JLabel();
        statusText.setBounds(300,440,200,20);
        statusText.setForeground(Color.RED);
        add(statusText);

        try{
            database c = new database();
            ResultSet rs = c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");
            while (rs.next())
            {
                meterText.setText(meter);
                nameText.setText(rs.getString("name"));
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }

        searchMonthCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                database c = new database();
                try{
                    ResultSet rs = c.statement.executeQuery("select * from bill where meter_no='"+meter+"' and month='"+searchMonthCho.getSelectedItem()+"'");
                    while (rs.next())
                    {
                        unitText.setText(rs.getString("unit"));
                        totalBillText.setText(rs.getString("total_bill"));
                        statusText.setText(rs.getString("status"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBounds(80,480,100,25);
        pay.setForeground(Color.white);
        pay.setBackground(Color.BLACK);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(200,480,100,25);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String []args){
        new pay_bill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==pay)
            {
                try{
                    database c = new database();
                   c.statement.executeUpdate("update bill set status='Paid' where meter_no='"+meter+"' and month='"+searchMonthCho.getSelectedItem()+"'");
                }catch (Exception E){
                    E.printStackTrace();
                }
                setVisible(false);
                new payment_bill(meter);
            }else{
                setVisible(false);
            }
    }
}
