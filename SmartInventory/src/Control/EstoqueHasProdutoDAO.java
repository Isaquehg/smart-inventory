package Control;

import Model.EstoqueHasProduto;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public boolean createAhasP(EstoqueHasProduto estoqueHasProduto) {
        connectToDB();

        String sqlAhasP = "INSERT INTO Estoque_has_Produto (Estoque_idEstoque, Produto_idProduto, quantidade) VALUES (?, ?, ?)";
        try {
            //Tabela Produto
            pst = con.prepareStatement(sqlAhasP);
            pst.setInt(1, estoqueHasProduto.getIdEstoque());
            pst.setInt(2, estoqueHasProduto.getIdProduto());
            pst.setInt(3, estoqueHasProduto.getQuantidade());
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
        return sucesso;
    }

    /**
    * Function for selecting all values from table Estoque_has_Produto
    * @return a ArrayList representing idEstoque, idProduto and inventory amount from intermediate table
    */
    public ArrayList<EstoqueHasProduto> selectAhasP(){
        connectToDB();

        ArrayList<EstoqueHasProduto> estoqueHasProduto = new ArrayList<>();

        String sql = "SELECT * FROM Estoque_has_Produto";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de quantidades Produtos X Estoque: ");

            while (rs.next()) {
                EstoqueHasProduto eHasProdutoAux = new EstoqueHasProduto(rs.getInt("Estoque_idEstoque"), rs.getInt("Produto_idProduto"), rs.getInt("quantidade"));

                System.out.println("ID Estoque = " + eHasProdutoAux.getIdEstoque());
                System.out.println("ID Produto = " + eHasProdutoAux.getIdProduto());
                System.out.println("Quantidade = " + eHasProdutoAux.getIdProduto());

                System.out.println("--------------------------------");

                estoqueHasProduto.add(eHasProdutoAux);
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
        return estoqueHasProduto;
    }

    //UPDATE
    //Updating storage where the product is
    /**
     * Function for updating the relationship between tables Estoque and Produto
     * @param idProduto is the ID from the product which is in some storage
     * @param idEstoque is the ID in which the product is in
     * @return a boolean value representing the operation status
     */
    public boolean updateAhasP(EstoqueHasProduto estoqueHasProduto) {
        connectToDB();
        String sql1 = "UPDATE Estoque_has_Produto SET quantidade=? where Produto_idProduto=? AND Estoque_idEstoque=?";
        //Changing inventory values
        try {
            pst = con.prepareStatement(sql1);
            pst.setInt(1, estoqueHasProduto.getQuantidade());
            pst.setInt(2, estoqueHasProduto.getIdProduto());
            pst.setInt(3, estoqueHasProduto.getIdEstoque());
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
