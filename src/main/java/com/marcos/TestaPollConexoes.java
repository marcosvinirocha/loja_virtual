import java.sql.SQLException;

public class TestaPollConexoes {
    public static void main(String[] args)throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConnection();
            System.out.println("Conexao de numero"+ i);
        }
    }
    
}
