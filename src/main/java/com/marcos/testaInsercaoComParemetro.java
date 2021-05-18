import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testaInsercaoComParemetro {
    public static void main(String[] args) {

        try {
            String nome = "mouse'";
            String descricao = "mouse sem fio); delete from PRODUTO ";
            ConnectionFactory criaConexao = new ConnectionFactory();
            Connection conexao = criaConexao.recuperarConnection();

            PreparedStatement stm = conexao.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, nome);
            stm.setString(2, descricao);

            stm.execute();

            ResultSet rs = stm.getGeneratedKeys();

            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.print("O id foi criado: " + id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
