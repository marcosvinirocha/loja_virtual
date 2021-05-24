import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDAO {

    private Connection conn;

    public CategoriaDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<Categoria>();
        System.out.println("Executando a query de listar Categoria");
        String sql = "SELECT * FROM CATEGORIA";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Categoria c = new Categoria(rs.getInt(1), rs.getString(2));
                    categorias.add(c);
                }
            }
        }
        return categorias;
    }

    public List<Categoria> listarComProdutos() throws SQLException {
        Categoria ultima = null;
        List<Categoria> categorias = new ArrayList<Categoria>();
        System.out.println("Executando a query de listar Categoria");
        String sql = "SELECT  * FROM CATEGORIA c INNER JOIN PRODUTO p ON c.ID = p.CATEGORIA_ID";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    if (ultima == null || !ultima.getNome().equals(rs.getString(2))) {
                        Categoria c = new Categoria(rs.getInt(1), rs.getString(2));
                        ultima = c;
                        categorias.add(c);
                    }
                    Produto produto = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));
                    ultima.adicionar(produto);

                }
            }
        }
        return categorias;
    }

}
