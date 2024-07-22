package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class new_customer extends JFrame implements ActionListener {

    JLabel heading,customer_name,meterNum,address,city,state,email,phoneno,meternumText;

    TextField nameText, addressText,cityText,stateText,emailText,phonenoText;

    JButton next , cancle;
    new_customer()
    {
        super("New Customer");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,183,3));
        add(panel);


        heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        panel.add(heading);

        customer_name = new JLabel("New Customer :");
        customer_name.setBounds(50,80,100,20);
        panel.add(customer_name);

        nameText = new TextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNum = new JLabel("Meter Number :");
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meternumText = new JLabel();
        meternumText.setBounds(180,120,150,20);
        panel.add(meternumText);

        Random ran = new Random();
        long number = ran.nextLong()%1000000;
        meternumText.setText(""+Math.abs(number));

        address = new JLabel("Address :");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new TextField();
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        city = new JLabel("City :");
        city.setBounds(50, 200,100,20);
        panel.add(city);

        cityText = new TextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state = new JLabel("State :");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText = new TextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email = new JLabel("Email :");
        email.setBounds(50,280,100,20);
        panel.add(email);

        emailText = new TextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        phoneno = new JLabel("Phone No :");
        phoneno.setBounds(50,320,100,20);
        panel.add(phoneno);

        phonenoText = new TextField();
        phonenoText.setBounds(180,320,150,20);
        panel.add(phonenoText);

        next = new JButton("Next ");
        next.setBounds(100,360,80,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        panel.add(next);

        cancle = new JButton("Cancle ");
        cancle.setBounds(190,360,80,25);
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        panel.add(cancle);

        setSize(700,500);
        setLocation(400,200);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        add(i4,"West");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
            String sname = nameText.getText();
            String smeterno = meternumText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphoneno = phonenoText.getText();

            String query_customer = "insert into new_customer values('"+sname+"','"+smeterno+"','"+saddress+"','"+scity+"','"+sstate+"','"+semail+"','"+sphoneno+"')";

            String signup_query = "insert into signup values('"+smeterno+"','','"+sname+"','','')";

            try{
                database c =new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(signup_query);

                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);
                new meterInfo(smeterno);


            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new new_customer();
    }
}
