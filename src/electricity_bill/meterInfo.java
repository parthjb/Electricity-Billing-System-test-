package electricity_bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class meterInfo extends JFrame implements ActionListener{

    Choice meterLocCho,meterTypeCho,phaseCodeCho,billTypeCho;

    JButton submit;
    String smeterno1;
    meterInfo(String smeterno1){

        this.smeterno1 = smeterno1;
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(250,10,200,20);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(heading);

        JLabel meterInfo = new JLabel("Meter Number :");
        meterInfo.setBounds(50,80,100,20);
        panel.add(meterInfo);

        JLabel meterNumberText = new JLabel(smeterno1);
        meterNumberText.setBounds(180,80,180,20);
        panel.add(meterNumberText);

        JLabel meterLoc = new JLabel("Meter Location :");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,100,20);
        panel.add(meterLocCho);

        JLabel meterType = new JLabel("Meter Type :");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeCho = new Choice();
        meterTypeCho.add("Electric meter");
        meterTypeCho.add("Solar meter");
        meterTypeCho.add("Smart meter");
        meterTypeCho.setBounds(180,160,100,20);
        panel.add(meterTypeCho);

        JLabel phaseCode = new JLabel("Phase Code :");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");
        phaseCodeCho.setBounds(180,200,100,20);
        panel.add(phaseCodeCho);

        JLabel billType = new JLabel("Bill type :");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeCho = new Choice();
        billTypeCho.add("Normal");
        billTypeCho.add("Industry");
        billTypeCho.setBounds(180,240,100,20);
        panel.add(billTypeCho);

        JLabel day = new JLabel("30 Days Billing Time...");
        day.setBounds(50,280,100,20);
        panel.add(day);

        JLabel note =  new JLabel("Note :-");
        note.setBounds(50,320,300,20);
        panel.add(note);

        JLabel note1 =  new JLabel("By default bill is calculated for 30 days only");
        note1.setBounds(50,360,300,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        setSize(700,500);
        setLocation(400,200);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        add(i4,"East");


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submit){

            String smeterno = smeterno1;
            String smeterLoc = meterLocCho.getSelectedItem();
            String smeterType = meterTypeCho.getSelectedItem();
            String sphaseCode = phaseCodeCho.getSelectedItem();
            String sbillType = billTypeCho.getSelectedItem();
            String day = "30";

            String query_meterinfo1 = "insert into bill_system.meter_info values('"+smeterno+"','"+smeterLoc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+day+"')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_meterinfo1);
                JOptionPane.showMessageDialog(null,"Meter information submitted successfully");
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[]args)
    {
        new meterInfo("");
    }

}
