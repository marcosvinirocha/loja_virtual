import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
    public static void main(String[] args) {
        ConnectionFactory criaConexao = new ConnectionFactory();
        Connection conexao;
        try {
            conexao = criaConexao.recuperarConnection();

            PreparedStatement stm = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
            stm.setInt(1, 2);

            stm.execute();
            Integer linhasModificadas = stm.getUpdateCount();
            System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
