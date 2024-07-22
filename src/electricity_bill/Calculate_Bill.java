package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Calculate_Bill extends JFrame implements ActionListener{

    JLabel nameText,addressText;

    JButton submit , cancle;
    TextField unitText;
    Choice meter_Num_Cho,month_Cho;
    Calculate_Bill(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading = new JLabel("Calculate Bills");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meter_Number = new JLabel("Meter Number:");
        meter_Number.setBounds(50,80,100,20);
        panel.add(meter_Number);

        meter_Num_Cho = new Choice();
        try{
                database c = new database();
                ResultSet rs = c.statement.executeQuery("select * from new_customer");
                while(rs.next())
                {
                    meter_Num_Cho.add(rs.getString("meter_no"));
                }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
        meter_Num_Cho.setBounds(180,80,100,20);
        panel.add(meter_Num_Cho);

        JLabel name = new JLabel("Name :");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(180,120,150,20);
        panel.add(nameText);

        JLabel address = new JLabel("Address :");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        try{
            database c = new database();
            ResultSet rs = c.statement.executeQuery("select * from new_customer where meter_no='"+meter_Num_Cho.getSelectedItem()+"' ");
            while (rs.next())
            {
                nameText.setText(rs.getString("name"));
                addressText.setText(rs.getString("address"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        meter_Num_Cho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    database c = new database();
                    ResultSet rs = c.statement.executeQuery("select * from new_customer where meter_no='"+meter_Num_Cho.getSelectedItem()+"' ");
                    while (rs.next())
                    {
                        nameText.setText(rs.getString("name"));
                        addressText.setText(rs.getString("address"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JLabel unit = new JLabel("Unit consumed :");
        unit.setBounds(50,200,100,20);
        panel.add(unit);

        unitText = new TextField("");
        unitText.setBounds(180,200,150,20);
        panel.add(unitText);

        JLabel month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        month_Cho = new Choice();
        month_Cho.add("January");
        month_Cho.add("February");
        month_Cho.add("March");
        month_Cho.add("April");
        month_Cho.add("May");
        month_Cho.add("June");
        month_Cho.add("July");
        month_Cho.add("August");
        month_Cho.add("September");
        month_Cho.add("October");
        month_Cho.add("November");
        month_Cho.add("December");
        month_Cho.setBounds(180,240,150,20);
        panel.add(month_Cho);


        submit = new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        cancle = new JButton("Cancle");
        cancle.setBounds(220,300,100,25);
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        panel.add(cancle);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/budget.png"));
        Image i2 = i1.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        add(i4,"East");

        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==submit)
            {
                String smeterno = meter_Num_Cho.getSelectedItem();
                String sunit = unitText.getText();
                String smonth = month_Cho.getSelectedItem();

                int totalBill = 0;
                int unit = Integer.parseInt(sunit);
                String query_tax = "Select * from tax";
                try{
                    database c = new database();
                    ResultSet rs = c.statement.executeQuery(query_tax);
                    while (rs.next())
                    {
                        totalBill += unit*Integer.parseInt(rs.getString("cost_per_unit"));
                        totalBill += Integer.parseInt(rs.getString("meter_rent"));
                        totalBill += Integer.parseInt(rs.getString("service_charge"));
                        totalBill += Integer.parseInt(rs.getString("swacch_bharat"));
                        totalBill += Integer.parseInt(rs.getString("fixed_tax"));

                    }


                }catch(Exception E)
                {
                    E.printStackTrace();
                }

                String query_total_bill = "insert into bill values('"+smeterno+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";

                try{
                    database c = new database();
                    c.statement.executeUpdate(query_total_bill);
                    JOptionPane.showMessageDialog(null,"Customer bill updated successfully");
                    setVisible(false);
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }else{
                setVisible(false);
            }
    }

    public static void main(String [] args)
    {
        new Calculate_Bill();
    }

}
