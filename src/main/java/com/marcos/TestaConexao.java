

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
        try {

            ConnectionFactory criaConexao = new ConnectionFactory();
            Connection conexao = criaConexao.recuperarConnection();
            System.out.println("fechando a conexao");
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
