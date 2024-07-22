package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_information extends JFrame implements ActionListener   {

    String view;

    JButton cancle;
    view_information(String view)
    {
        this.view = view;

        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading = new JLabel("View Customer Details");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("serif", Font.BOLD,20));
        add(heading);

        JLabel namelabel = new JLabel("Name :");
        namelabel.setBounds(70,80,100,20);
        add(namelabel);

        JLabel namelabelText = new JLabel();
        namelabelText.setBounds(200,80,150,20);
        add(namelabelText);

        JLabel meterno = new JLabel("Meter Number :");
        meterno.setBounds(70,140,100,20);
        add(meterno);

        JLabel meternoText = new JLabel();
        meternoText.setBounds(200,140,150,20);
        add(meternoText);

        JLabel address = new JLabel("User Address :");
        address.setBounds(70,200,100,20);
        add(address);

        JLabel addressText = new JLabel();
        addressText.setBounds(200,200,150,20);
        add(addressText);

        JLabel city = new JLabel("User City :");
        city.setBounds(70,260,100,20);
        add(city);

        JLabel cityText = new JLabel();
        cityText.setBounds(200,260,150,20);
        add(cityText);

        JLabel state = new JLabel("User State :");
        state.setBounds(500,80,100,20);
        add(state);

        JLabel stateText = new JLabel();
        stateText.setBounds(600,80,150,20);
        add(stateText);

        JLabel email = new JLabel("User Email :");
        email.setBounds(500,140,100,20);
        add(email);

        JLabel emailText = new JLabel();
        emailText.setBounds(600,140,150,20);
        add(emailText);

        JLabel phone = new JLabel("User Phone No :");
        phone.setBounds(500,200,100,20);
        add(phone);

        JLabel phoneText = new JLabel();
        phoneText.setBounds(600,200,150,20);
        add(phoneText);

        try{
            database c = new database();
           ResultSet rs =  c.statement.executeQuery("select * from new_customer where meter_no='"+view+"' ");
           while(rs.next())
           {
               namelabelText.setText(rs.getString("name"));
               meternoText.setText(rs.getString("meter_no"));
               addressText.setText(rs.getString("address"));
               cityText.setText(rs.getString("city"));
               stateText.setText(rs.getString("state"));
               emailText.setText(rs.getString("email"));
               phoneText.setText(rs.getString("phone_no"));

           }

        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        cancle = new JButton("Cancle");
        cancle.setBounds(220,350,120,25);
        cancle.setBackground(new Color(28,118,248));
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/viewInfo.png"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(100,320,600,300);
        add(i4);

        setVisible(true);
    }

    public static void main(String[]args)
    {
        new view_information("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancle)
        {
            setVisible(false);
        }
    }
}
