package Control;

import java.sql.SQLException;

public class ArmazemHasProduto extends ConnectionDAO{
    boolean sucesso = false;

    //Realizar a atualização da tabela ArmazemhasProduto após a inserção de um novo produto
    public void updateAhasP(int idUltimoArmazem, int idUltimoProduto) {
        connectToDB();

        String sqlAhasP = "INSERT INTO Armazem_has_Produto (Armazem_idArmazem, Produto_idProduto) VALUES (?, ?)";
        try {
            //Tabela Produto
            pst = con.prepareStatement(sqlAhasP);
            pst.setInt(1, idUltimoArmazem);
            pst.setInt(2, idUltimoProduto);
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
