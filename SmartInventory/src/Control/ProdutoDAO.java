package Control;

import Model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for DAO operations on Produto table
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class ProdutoDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false;//Successfully operation

    //INSERT
    /** Function for inserting elements into Produto table
     * @param produto is a Produto object
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean createProduto(Produto produto) {
        connectToDB();

        String sqlP = "INSERT INTO Produto (idProduto, nome, categoria, peso) VALUES(?, ?, ?, ?)";
        try {
            //Tabela Produto
            pst = con.prepareStatement(sqlP);
            pst.setInt(1, produto.getIdProduto());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getCategoria());
            pst.setInt(4, produto.getPeso());
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

    //UPDATE
    /**
     * Function for updating Product registration data from table values
     * This one is not used for changing product inventory amount
     * @param produto Produto object containing new values
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean updateProduto(Produto produto) {
        connectToDB();
        String sql2 = "UPDATE Produto SET nome=?, peso=?, categoria=? where id=?";

        //changing registration data
        try {
            pst = con.prepareStatement(sql2);
            pst.setString(1, produto.getNome());
            pst.setInt(2, produto.getPeso());
            pst.setString(3, produto.getCategoria());
            pst.setInt(4, produto.getIdProduto());
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

    //DELETE
    /**
     * Function for deleting Product itens
     * @param id represents product ID to be deleted
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean deleteProduto(int id) {
        connectToDB();
        String sql = "DELETE FROM Produto where idProduto=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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

    //SELECT
    /**
     * Funtion for selecting all Product elements from Produto table
     * @return a ArraList containing Product object references
     */
    public ArrayList<Produto> selectProduto() {
        ArrayList<Produto> produtos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Produto";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de produtos: ");

            while (rs.next()) {

                Produto produtoAux = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("categoria"), rs.getInt("peso"));
                
                //Retirar print e enviar dados para UI
                System.out.println("ID = " + produtoAux.getIdProduto());
                System.out.println("Nome = " + produtoAux.getNome());
                System.out.println("Categoria = " + produtoAux.getCategoria());
                System.out.println("Peso = " + produtoAux.getPeso() + "g");

                System.out.println("--------------------------------");

                produtos.add(produtoAux);
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
        return produtos;
    }
}
