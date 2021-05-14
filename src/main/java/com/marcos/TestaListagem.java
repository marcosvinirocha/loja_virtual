

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
    public static void main(String[] args) throws Exception {
        // Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
        try {

            ConnectionFactory criaConexao = new ConnectionFactory();
            Connection conexao = criaConexao.recuperarConnection();

            Statement st = conexao.createStatement();

            st.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

            ResultSet rst = st.getResultSet();

            while (rst.next()) {
                Integer id = rst.getInt("ID");
                System.out.println(id);
                String nome = rst.getString("NOME");
                System.out.println(nome);
                String descricao = rst.getString("DESCRICAO");
                System.out.println(descricao);
            }

            System.out.println();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
