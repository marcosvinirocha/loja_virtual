

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://172.18.0.2:3306/loja_virtual", "root",
                    "92318491");
    }
}
