package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField userText,userPassword;
    Choice loginchoice;

    JButton loginButton,cancelButton,signupButton;
    Login()
    {
        super("LogIn");

        JLabel username = new JLabel("UserName:");
        username.setBounds(300,60,100,20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);

        JLabel password = new JLabel("Password:");
        password.setBounds(300,100,100,20);
        add(password);

        userPassword = new JTextField();
        userPassword.setBounds(400,100,150,20);
        add(userPassword);

        JLabel login = new JLabel("Log In As:");
        login.setBounds(300,140,100,20);
        add(login);



        loginchoice = new Choice();
        loginchoice.add("Admin");
        loginchoice.add("Customer");
        loginchoice.setBounds(400,140,150,20);
        add(loginchoice);

        loginButton = new JButton("Log In");
        loginButton.setBounds(350,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(480,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(415,220,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icon/boy.png"));
        Image profileTow = img.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(profileTow);
        JLabel img3 = new JLabel(img2);
        img3.setBounds(0,0,250,250);
        add(img3);



        setSize(648,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loginButton)
        {
            String susername = userText.getText();
            String spassword = userPassword.getText();
            String suser = loginchoice.getSelectedItem();

            try{
                database c = new database();
                String query = "SELECT * FROM signup WHERE username = '"+susername+"' and password = '"+spassword+"' and usertype = '"+suser+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next())
                {
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);

                    new main_class(suser,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }catch (Exception e1)
            {
                e1.printStackTrace();
            }
        } else if (e.getSource()==cancelButton) {
            setVisible(false);
        } else if (e.getSource()==signupButton) {
            setVisible(false);
            new SignUp();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
