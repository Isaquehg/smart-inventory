package Control;

import Model.EstoqueHasProduto;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Class for DAO operations on Estoque_has_Produto table
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class EstoqueHasProdutoDAO extends ConnectionDAO{
    boolean sucesso = false;

    //updating Estoque_has_Produto after modifying Produto or Estoque
    /**
     * Function for inserting values into table Estoque_has_Produto
     * @param EstoqueHasProduto receives a EstoqueHasProduto object
     */
    public void createAhasP(EstoqueHasProduto EstoqueHasProduto) {
        connectToDB();

        String sqlAhasP = "INSERT INTO Estoque_has_Produto (Estoque_idEstoque, Produto_idProduto) VALUES (?, ?)";
        try {
            //Tabela Produto
            pst = con.prepareStatement(sqlAhasP);
            pst.setInt(1, EstoqueHasProduto.getIdEstoque());
            pst.setInt(2, EstoqueHasProduto.getIdProduto());
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

    /**
    * Function for selecting all values from table Estoque_has_Produto
    * @return a HashMap which elements cointain a Key-Value pair representing idEstoque and idProduto respectively
    */
    public HashMap<Integer, Integer> selectAhasP(){
        HashMap<Integer, Integer> aHasProdutos = new HashMap<>();
        connectToDB();
        String sql = "SELECT * FROM Estoque_has_Produto";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de relações Produtos X Armazens: ");

            while (rs.next()) {
                EstoqueHasProduto aHasProdutoAux = new EstoqueHasProduto();
                aHasProdutoAux.setIdEstoque(rs.getInt("Estoque_idEstoque"));
                aHasProdutoAux.setIdProduto(rs.getInt("Produto_idProduto"));

                System.out.println("ID Estoque = " + aHasProdutoAux.getIdEstoque());
                System.out.println("ID Produto = " + aHasProdutoAux.getIdProduto());

                System.out.println("--------------------------------");

                aHasProdutos.put(aHasProdutoAux.getIdEstoque(), aHasProdutoAux.getIdProduto());
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return aHasProdutos;
    }

    //UPDATE
    //Updating storage where the product is
    /**
     * Function for updating the relationship between tables Estoque and Produto
     * @param idProduto is the ID from the product which is in some storage
     * @param idEstoque is the ID in which the product is in
     * @return a boolean value representing the operation status
     */
    public boolean updateAhasP(int idProduto, int idEstoque) {
        connectToDB();
        String sql1 = "UPDATE Estoque_has_Produto SET Estoque_idEstoque=? where Produto_idProduto=?";
        //Changing inventory values
        try {
            pst = con.prepareStatement(sql1);
            pst.setInt(1, idEstoque);
            pst.setInt(2, idProduto);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}
