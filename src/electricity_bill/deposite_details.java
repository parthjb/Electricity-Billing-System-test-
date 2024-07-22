package electricity_bill;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class deposite_details extends JFrame implements ActionListener {

        Choice searchMeterCho,searchMonthCho;

        JButton search,print,close;
        JTable table;
        deposite_details(){
            super("Deposite Details");
            getContentPane().setBackground(new Color(253, 160, 160));
            setSize(700,500);
            setLocation(400,200);
            setLayout(null);

            JLabel searchMeter = new JLabel("Search by meter number :");
            searchMeter.setBounds(20,20,150,25);
            add(searchMeter);

            searchMeterCho = new Choice();
            searchMeterCho.setBounds(180,20,150,25);
            add(searchMeterCho);

            try{
                database c = new database();
                ResultSet rs = c.statement.executeQuery("select * from bill");
                while(rs.next())
                {
                    searchMeterCho.add(rs.getString("meter_no"));
                }
            }catch(Exception E)
            {
                E.printStackTrace();
            }

            JLabel searchMonth = new JLabel("Search by month :");
            searchMonth.setBounds(400,20,100,25);
            add(searchMonth);

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
            searchMonthCho.setBounds(510,20,150,25);
            add(searchMonthCho);



            table = new JTable();

            try{
                database c = new database();
                ResultSet rs = c.statement.executeQuery("select * from bill");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception E){
                E.printStackTrace();
            }
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0,100,700,500);
            scrollPane.setBackground(Color.white);
            add(scrollPane);

            search = new JButton("Search");
            search.setBackground(Color.white);
            search.setBounds(20,70,80,20);
            search.addActionListener(this);
            add(search);

            print = new JButton("Print");
            print.setBounds(120,70,80,20);
            print.setBackground(Color.white);
            print.addActionListener(this);
            add(print);

            close = new JButton("Close");
            close.setBounds(580,70,80,20);
            close.setBackground(Color.white);
            close.addActionListener(this);
            add(close);
            setVisible(true);

        }

    public static void main(String[]args){
        new deposite_details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search)
        {
            String query_search = "select * from bill where meter_no='"+searchMeterCho.getSelectedItem()+"' and month='"+searchMonthCho.getSelectedItem()+"'";
            try{
                database c = new database();
                ResultSet rs = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception E)
            {
                E.printStackTrace();
            }
        }else if(e.getSource()==print)
        {
            try{
                table.print();
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }
    }

