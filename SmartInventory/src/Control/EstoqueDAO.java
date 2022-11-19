package Control;

import Model.Estoque;
import Model.EstoqueHasProduto;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for DAO operations on Estoque table
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class EstoqueDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false;//Successfully operation

    //INSERT
    /**
     * Function for inserting itens in Estoque table
     * @param Estoque receives a Estoque object
     * @param EstoqueHasProduto receives a EstoqueHasProduto object, which is a intermediate table
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean createEstoque(Estoque estoque) {
        connectToDB();

        String sql = "INSERT INTO Estoque (idEstoque, endereco, Proprietario_idProprietario) values(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, estoque.getIdEstoque());
            pst.setString(2, estoque.getEndereco());
            pst.setInt(3, estoque.getIdProprietario());
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
     * Function for updating itens in Estoque table
     * @param Estoque receives a Estoque object
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean updateEstoque(Estoque estoque) {
        connectToDB();
        String sql1 = "UPDATE Estoque SET endereco=?, Proprietario_idProprietario=? where idEstoque=?";
        //alterar estoque
        try {
            pst = con.prepareStatement(sql1);
            pst.setString(1, estoque.getEndereco());
            pst.setInt(2, estoque.getIdProprietario());
            pst.setInt(3, estoque.getIdEstoque());
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
     * Function for deleting itens in Estoque table
     * @param id receives a storage ID indicating which one must be removed
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean deleteEstoque(int id) {
        connectToDB();
        String sql = "DELETE FROM Estoque where idEstoque=?";
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
     * Function for selecting all itens in Estoque table
     * @return a ArraList containing Estoque objects references
     */
    public ArrayList<Estoque> selectEstoque() {
        ArrayList<Estoque> armazens = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Estoque";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Armazens: ");

            while (rs.next()) {
                Estoque EstoqueAux = new Estoque(rs.getInt("idEstoque"), rs.getString("endereco"), rs.getInt("Proprietario_idProprietario"));

                //Retirar print e enviar dados para UI
                System.out.println("ID = " + EstoqueAux.getIdEstoque());
                System.out.println("Endereco = " + EstoqueAux.getEndereco());
                System.out.println("Proprietario = " + EstoqueAux.getIdProprietario());

                System.out.println("--------------------------------");

                armazens.add(EstoqueAux);
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
        return armazens;
    }
}
