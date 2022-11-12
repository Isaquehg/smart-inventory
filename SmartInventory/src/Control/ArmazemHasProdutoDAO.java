package Control;

import Model.ArmazemHasProduto;
import java.sql.SQLException;

public class ArmazemHasProdutoDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Realizar a atualização da tabela ArmazemhasProduto após a inserção de um novo produto
    public void updateAhasP(ArmazemHasProduto armazemHasProduto) {
        connectToDB();

        String sqlAhasP = "INSERT INTO Armazem_has_Produto (Armazem_idArmazem, Produto_idProduto) VALUES (?, ?)";
        try {
            //Tabela Produto
            pst = con.prepareStatement(sqlAhasP);
            pst.setInt(1, armazemHasProduto.getIdArmazem());
            pst.setInt(2, armazemHasProduto.getIdProduto());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
}
