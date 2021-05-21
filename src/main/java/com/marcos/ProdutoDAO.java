import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDAO {

    private Connection conn;
    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void  salvarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1,produto.getNome());
            pstmt.setString(2,produto.getDescricao());
            pstmt.execute();

            try(ResultSet rs = pstmt.getGeneratedKeys()){
                while(rs.next()){
                    produto.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException{
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM PRODUTO";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.execute();

            try(ResultSet rs = pstm.getResultSet()){
                while(rs.next()){ 
                    Produto produto= new Produto(rs.getInt(1),rs.getString(2),rs.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
    
}
