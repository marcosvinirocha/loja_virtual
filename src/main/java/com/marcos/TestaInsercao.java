

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) {
        ConnectionFactory criaConexao = new ConnectionFactory();
        try {
            Connection conexao = criaConexao.recuperarConnection();

            Statement stm = conexao.createStatement();
            stm.execute("INSERT INTO PRODUTO (nome,descricao) VALUES('Mouse','Mouse sem fio')",
                    Statement.RETURN_GENERATED_KEYS);

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
