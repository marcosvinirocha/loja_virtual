
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("92318491");

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;

    }

    public Connection recuperarConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
