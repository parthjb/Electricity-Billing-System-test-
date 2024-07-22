package electricity_bill;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SignUp extends JFrame implements ActionListener {

    Choice loginAscho;
    TextField meter_text,employee_text,username_text,name_text,password_text;

    JButton createB,back;
    SignUp()
    {
        super("SignUp Page");

        getContentPane().setBackground(new Color(168,203,255));


        JLabel createAs = new JLabel("Create Account As :");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAscho = new Choice();
        loginAscho.setBounds(170,50,120,20);
        loginAscho.add("Admin");
        loginAscho.add("Customer");
        add(loginAscho);

        JLabel meterNo = new JLabel("Meter Number :");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meter_text = new TextField();
        meter_text.setBounds(170,100,120,20);
        meter_text.setVisible(false);
        add(meter_text);

        JLabel employee_id = new JLabel("Employee ID :");
        employee_id.setBounds(30,100,125,20);
        employee_id.setVisible(true);
        add(employee_id);

        employee_text = new TextField();
        employee_text.setBounds(170,100,125,20);
        employee_text.setVisible(true);
        add(employee_text);

        JLabel username = new JLabel("Username :");
        username.setBounds(30,140,125,20);
        add(username);

        username_text = new TextField();
        username_text.setBounds(170,140,125,20);
        add(username_text);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,180,125,20);
        add(name);

        name_text = new TextField("");
        name_text.setBounds(170,180,125,20);
        add(name_text);

        meter_text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                    try{
                        database c = new database();
                        ResultSet rs = c.statement.executeQuery("select * from signup where meter_no ='"+ meter_text.getText()+"' ");
                        while (rs.next())
                        {
                            name_text.setText(rs.getString("name"));
                        }
                    }catch (Exception E)
                    {
                        E.printStackTrace();
                    }
            }
        });

        JLabel password = new JLabel("Password :");
        password.setBounds(30,220,125,20);
        add(password);

        password_text = new TextField();
        password_text.setBounds(170,220,125,20);
        add(password_text);

        loginAscho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAscho.getSelectedItem();
                if(user.equals("Customer"))
                {
                    employee_id.setVisible(false);
                    employee_text.setVisible(false);
                    name_text.setEditable(false);
                    meterNo.setVisible(true);
                    meter_text.setVisible(true);
                }
                else{
                    employee_id.setVisible(true);
                    employee_text.setVisible(true);
                    meterNo.setVisible(false);
                    meter_text.setVisible(false);
                }
            }
        });

         createB = new JButton("Create");
         createB.setBounds(50,285,100,25);
         createB.setBackground(new Color(66,127, 219));
         createB.addActionListener(this);
         add(createB);

         back = new JButton("Back");
         back.setBounds(180,285,100,25);
         back.setBackground(new Color(66,127,219));
         back.addActionListener(this);
         add(back);

         ImageIcon boy_icon = new ImageIcon(ClassLoader.getSystemResource("Icon/boy.png"));
         Image boyimag = boy_icon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
         ImageIcon boy_icon2 = new ImageIcon(boyimag);
         JLabel img = new JLabel(boy_icon2);
         img.setBounds(320,30,250,250);
         add(img);


        setSize(600,380);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==createB)
        {
            String sloginAs = loginAscho.getSelectedItem();
            String susername = username_text.getText();
            String sname = name_text.getText();
            String spassword = password_text.getText();
            String smeter = meter_text.getText();

            try{
                database c = new database();
                String query = null;
                if(loginAscho.equals("Admin")) {
                    query = "insert into signup value('" + smeter + "','" + susername + "','" + sname + "','" + spassword + "','" + sloginAs + "')";

                }else{
                    query = "update signup set username ='"+susername+"',password ='"+spassword+"',usertype ='"+sloginAs+"' where meter_no = '"+smeter+"'";
                }c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new Login();

            }catch (Exception E)
            {
                E.printStackTrace();
            }


        } else if (e.getSource()==back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[]args)
    {
        new SignUp();
    }

}
