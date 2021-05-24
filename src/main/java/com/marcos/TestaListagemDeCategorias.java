import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = new ConnectionFactory().recuperarConnection()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
            List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
            listaDeCategorias.stream().forEach(ct -> {
                System.out.println(ct.getNome());
                for (Produto produto : ct.getProdutos()) {
                    System.out.println(ct.getNome() + " - " + produto.getNome());
                }
            });
        }

    }

}
