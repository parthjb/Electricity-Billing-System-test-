package electricity_bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {

    Connection connection;
    Statement statement;
    database()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill_system","root","W7301@jqir#");
            statement = connection.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
