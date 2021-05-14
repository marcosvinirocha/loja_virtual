import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args)  {
        ConnectionFactory criaConexao = new ConnectionFactory();
        Connection conexao;
        try {
            conexao = criaConexao.recuperarConnection();
            Statement stm = conexao.createStatement();

            stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
            Integer linhasModificadas = stm.getUpdateCount();
            System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      

        
        
    }

}
