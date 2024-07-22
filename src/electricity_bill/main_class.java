package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {

    String acctype;
    String meter_pass;
    main_class(String acctype,String meter_pass)
    {
        this.acctype = acctype;
        this.meter_pass = meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Icon/ebs.png"));
        Image img2 = img1.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        add(img4);



        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon customerImage = new ImageIcon(ClassLoader.getSystemResource("Icon/newcustomer.png"));
        Image customerImage1 = customerImage.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImage1));
        newCustomer.addActionListener(this);
        menu.add(newCustomer);

        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon customerImage2 = new ImageIcon(ClassLoader.getSystemResource("Icon/customerDetails.png"));
        Image customerImage3 = customerImage2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerImage3));
        customerDetails.addActionListener(this);
        menu.add(customerDetails);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon depositDetails1 = new ImageIcon(ClassLoader.getSystemResource("Icon/depositdetails.png"));
        Image depositDetails2 = depositDetails1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositDetails2));
        depositDetails.addActionListener(this);
        menu.add(depositDetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon calculateBill1 = new ImageIcon(ClassLoader.getSystemResource("Icon/calculatorbills.png"));
        Image calculateBill2 = calculateBill1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBill2));
        calculateBill.addActionListener(this);
        menu.add(calculateBill);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem upinfo = new JMenuItem("Update Information");
        upinfo.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon upinfo1 = new ImageIcon(ClassLoader.getSystemResource("Icon/refresh.png"));
        Image upinfo2 = upinfo1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfo2));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon viewinfo1 = new ImageIcon(ClassLoader.getSystemResource("Icon/information.png"));
        Image viewinfo2 = viewinfo1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfo2));
        viewinfo.addActionListener(this);
        info.add(viewinfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem payBill = new JMenuItem("Pay Bills");
        payBill.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon payBill1 = new ImageIcon(ClassLoader.getSystemResource("Icon/pay.png"));
        Image payBill2 = payBill1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(payBill2));
        payBill.addActionListener(this);
        user.add(payBill);

        JMenuItem billDetail = new JMenuItem("Bill Details");
        billDetail.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon billDetail1 = new ImageIcon(ClassLoader.getSystemResource("Icon/detail.png"));
        Image billDetail2 = billDetail1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billDetail.setIcon(new ImageIcon(billDetail2));
        billDetail.addActionListener(this);
        user.add(billDetail);

        JMenu bill = new JMenu("Bills");
        bill.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon genBill1 = new ImageIcon(ClassLoader.getSystemResource("Icon/bill.png"));
        Image genBill2 = genBill1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBill2));
        genBill.addActionListener(this);
        bill.add(genBill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem notePad = new JMenuItem("Notepad");
        notePad.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon notePad1 = new ImageIcon(ClassLoader.getSystemResource("Icon/notepad.png"));
        Image notePad2 = notePad1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notePad.setIcon(new ImageIcon(notePad2));
        notePad.addActionListener(this);
        utility.add(notePad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("serif",Font.PLAIN,14));
        ImageIcon calculator1 = new ImageIcon(ClassLoader.getSystemResource("Icon/calculator.png"));
        Image calculator2 = calculator1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculator2));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu eexit = new JMenu("Exit");
        eexit.setFont(new Font("serif",Font.PLAIN,15));


        JMenuItem exitt = new JMenuItem("Exit");
        exitt.setFont(new Font("monoplain",Font.PLAIN,14));
        ImageIcon exitt1 = new ImageIcon(ClassLoader.getSystemResource("Icon/exit.png"));
        Image exitt2 = exitt1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exitt.setIcon(new ImageIcon(exitt2));
        exitt.addActionListener(this);
        eexit.add(exitt);

        if(acctype.equals("Admin"))
        {
            menuBar.add(menu);
        }
        else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }

        menuBar.add(utility);
        menuBar.add(eexit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new main_class("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        
        if(msg.equals("New Customer"))
        {
            new new_customer();
        } else if (msg.equals("Customer Details")) {
            new customer_details();
        } else if (msg.equals("Deposit Details")) {
            new deposite_details();
        } else if (msg.equals("Calculate Bill")) {
            new Calculate_Bill();
        } else if (msg.equals("View Information")) {
            new view_information(meter_pass);
        } else if (msg.equals("Update Information")) {
            new update_information(meter_pass);
        } else if (msg.equals("Bill Details")) {
            new bill_detail(meter_pass);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bills")) {
            new pay_bill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill(meter_pass);
        }
    }
}
