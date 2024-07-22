package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_information extends JFrame implements ActionListener {
    String meter;

    JLabel nameText;
//    JLabel nameText,meterText;
    JTextField addressText, emailText, phoneText, cityText, stateText;

    JButton update, cancle;
    update_information(String meter){
        this.meter = meter;
        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,225,227));
        setLayout(null);

        JLabel heading = new JLabel("Update customer information");
        heading.setBounds(50,10,400,50);
        heading.setFont(new Font("serif", Font.BOLD,20));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,70,100,20);
        add(name);

         nameText = new JLabel("");
        nameText.setBounds(150,70,200,20);
        add(nameText);

        JLabel meterNo = new JLabel("Meter No :");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        JLabel meterText = new JLabel(meter);
        meterText.setBounds(150,110,100,20);
        add(meterText);

        JLabel address = new JLabel("Address :");
        address.setBounds(30,150,100,20);
        add(address);

        addressText = new JTextField();
        addressText.setBounds(150,150,200,20);
        add(addressText);

        JLabel city = new JLabel("City :");
        city.setBounds(30,190,100,20);
        add(city);

        cityText = new JTextField();
        cityText.setBounds(150,190,200,20);
        add(cityText);

        JLabel state = new JLabel("State :");
        state.setBounds(30,230,100,20);
        add(state);

        stateText = new JTextField();
        stateText.setBounds(150,230,200,20);
        add(stateText);

        JLabel email = new JLabel("Email :");
        email.setBounds(30,270,100,20);
        add(email);

        emailText = new JTextField();
        emailText.setBounds(150,270,200,20);
        add(emailText);

        JLabel phone = new JLabel("Phone No :");
        phone.setBounds(30,310,100,20);
        add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(150,310,200,20);
        add(phoneText);

        try{
            database c = new database();
            ResultSet rs = c.statement.executeQuery("select * from new_customer where meter_no = '"+meter+"'");

            if(rs.next())
            {
                nameText.setText(rs.getString("name"));
                addressText.setText(rs.getString("address"));
                cityText.setText(rs.getString("city"));
                stateText.setText(rs.getString("state"));
                emailText.setText(rs.getString("email"));
                phoneText.setText(rs.getString("phone_no"));
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(new Color(33,106,142));
        update.setForeground(Color.white);
        update.setBounds(50,360,120,25);
        update.addActionListener(this);
        add(update);

        cancle = new JButton("Cancle");
        cancle.setBackground(new Color(33,106,142));
        cancle.setForeground(Color.white);
        cancle.setBounds(200,360,120,25);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(360,0,400,410);
        add(i4);
        setVisible(true);


    }
    public static void main(String[]args)
    {
        new update_information("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update)
        {
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            try{
                database c = new database();
                c.statement.executeUpdate("update new_customer set address='"+saddress+"',city='"+scity+"',state='"+sstate+"',email='"+semail+"',phone_no='"+sphone+"'where meter_no='"+meter+"'");
                JOptionPane.showMessageDialog(null,"Information updated successfully");
                setVisible(false);
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
