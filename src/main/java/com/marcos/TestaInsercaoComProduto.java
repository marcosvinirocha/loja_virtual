import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.Produto;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("comoda", "comoda vertical");

        try (Connection conn = new ConnectionFactory().recuperarConnection()) {
            ProdutoDAO persistenciaProduto = new ProdutoDAO(conn);
            persistenciaProduto.salvarProduto(comoda);
            List<Produto> listarProdutos = persistenciaProduto.listar();
            listarProdutos.stream().forEach(ls -> System.out.println(ls));

            //Lsita = persistenciaProduto.listar();
        }

    }

}
