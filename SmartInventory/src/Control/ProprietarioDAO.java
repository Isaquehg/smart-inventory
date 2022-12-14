package Control;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Proprietario;

/**
 * Class for DAO operations on Proprietario table
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class ProprietarioDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false;

    //INSERT
    /**
     * FUnction for inserting new elements into Proprietario table
     * @param proprietario represents a Proprietario object
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean createProprietario(Proprietario proprietario) {
        connectToDB();

        String sql = "INSERT INTO Proprietario (idProprietario, nome) values(?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, proprietario.getIdProprietario());
            pst.setString(2, proprietario.getNome());
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
     * Function for updating Proprietario table
     * @param proprietario represents a Proprietario object
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean updateProprietario(Proprietario proprietario) {
        connectToDB();
        String sql1 = "UPDATE Proprietario SET nome=? where idProprietario=?";
        try {
            pst = con.prepareStatement(sql1);
            pst.setString(1, proprietario.getNome());
            pst.setInt(2, proprietario.getIdProprietario());
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
     * Function for deleting elements on Proprietario table
     * @param id represents the element ID to be deleted
     * @return a boolean value, indicating if the operation was successful
     */
    public boolean deleteProprietario(int id) {
        connectToDB();
        String sql = "DELETE FROM Proprietario where idProprietario=?";
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
     * Function for selecting all elements from Proprietario table
     * @return a ArraList cointaining Proprietario obejcts references
     */
    public ArrayList<Proprietario> selectProprietario() {
        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Proprietario";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Proprietarios: ");

            while (rs.next()) {

                Proprietario proprietarioAux = new Proprietario(rs.getInt("idProprietario"), rs.getString("nome"));

                //Passar print para UI
                System.out.println("ID = " + proprietarioAux.getIdProprietario());
                System.out.println("Nome = " + proprietarioAux.getNome());

                System.out.println("--------------------------------");

                proprietarios.add(proprietarioAux);
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
        return proprietarios;
    }
}
