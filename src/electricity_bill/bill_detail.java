package electricity_bill;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class bill_detail extends JFrame implements ActionListener {
    String meter;
    bill_detail(String meter){
        this.meter = meter;
        setSize(700,650);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JTable table = new JTable();
        try {
            database c = new database();
            String query = "select * from bill where meter_no='"+meter+"'";
            ResultSet rs = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);


        setVisible(true);
    }

    public static void main(String []args)
    {

        new bill_detail("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
