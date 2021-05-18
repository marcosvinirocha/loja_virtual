import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testaInsercaoComParemetro {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory criaConexao = new ConnectionFactory();

        try (Connection conexao = criaConexao.recuperarConnection()) {
            conexao.setAutoCommit(false);

            try (PreparedStatement stm = conexao.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {

                addVariavel("Smart tv", "45 polegadas", stm);
                addVariavel("Radio", "Radio de bateria", stm);

                conexao.commit();

                stm.close();

            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                conexao.rollback();
            }

        }
    }

    private static void addVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if (nome.equals("Radio")) {
            throw new RuntimeException("Não foi possivel add esse produto.");
        }

        stm.execute();

        ;

        try (ResultSet rs = stm.getGeneratedKeys()) {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.print("O id foi criado: " + id);
            }
        }
    }

}
