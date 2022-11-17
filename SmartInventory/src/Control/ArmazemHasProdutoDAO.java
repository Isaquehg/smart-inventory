package Control;

import Model.ArmazemHasProduto;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Class for DAO operations on Armazem_has_Produto table
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class ArmazemHasProdutoDAO extends ConnectionDAO{
    boolean sucesso = false;

    //updating Armazem_has_Produto after modifying Produto or Armazem
    /**
     * Function for inserting values into table Armazem_has_Produto
     * @param armazemHasProduto receives a ArmazemHasProduto object
     */
    public void createAhasP(ArmazemHasProduto armazemHasProduto) {
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

    /**
    * Function for selecting all values from table Armazem_has_Produto
    * @return a HashMap which elements cointain a Key-Value pair representing idArmazem and idProduto respectively
    */
    public HashMap<Integer, Integer> selectAhasP(){
        HashMap<Integer, Integer> aHasProdutos = new HashMap<>();
        connectToDB();
        String sql = "SELECT * FROM Armazem_has_Produto";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de relações Produtos X Armazens: ");

            while (rs.next()) {
                ArmazemHasProduto aHasProdutoAux = new ArmazemHasProduto();
                aHasProdutoAux.setIdArmazem(rs.getInt("Armazem_idArmazem"));
                aHasProdutoAux.setIdProduto(rs.getInt("Produto_idProduto"));

                System.out.println("ID Armazem = " + aHasProdutoAux.getIdArmazem());
                System.out.println("ID Produto = " + aHasProdutoAux.getIdProduto());

                System.out.println("--------------------------------");

                aHasProdutos.put(aHasProdutoAux.getIdArmazem(), aHasProdutoAux.getIdProduto());
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
     * Function for updating the relationship between tables Armazem and Produto
     * @param idProduto is the ID from the product which is in some storage
     * @param idArmazem is the ID in which the product is in
     * @return a boolean value representing the operation status
     */
    public boolean updateAhasP(int idProduto, int idArmazem) {
        connectToDB();
        String sql1 = "UPDATE Armazem_has_Produto SET Armazem_idArmazem=? where Produto_idProduto=?";
        //Changing inventory values
        try {
            pst = con.prepareStatement(sql1);
            pst.setInt(1, idArmazem);
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
