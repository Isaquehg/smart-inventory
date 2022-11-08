package Control;

import Model.Armazem;
import Model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArmazemDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean createArmazem(Armazem armazem) {

        connectToDB();

        String sql = "INSERT INTO Armazem (endereco, idProprietario, idProduto) values(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, armazem.getendereco());
            pst.setInt(2, armazem.getIDProprietario());
            pst.setInt(3, armazem.getIDProdutos());
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
    public boolean updateArmazem(int id, Armazem armazem) {
        connectToDB();
        String sql1 = "UPDATE Armazem SET endereco=?, idProprietario=? where id=?";
        //alterar estoque
        try {
            pst = con.prepareStatement(sql1);
            pst.setString(1, armazem.getendereco());
            pst.setInt(2, armazem.getIDProprietario());
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
    public boolean deleteArmazem(int id) {
        connectToDB();
        String sql = "DELETE FROM Armazem where id=?";
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
    //Retorna apenas endereco e proprietario do armazem
    public ArrayList<Armazem> selectArmazem(int id) {
        ArrayList<Armazem> armazens = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Armazem";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Armazens: ");

            while (rs.next()) {

                Armazem armazemAux = new Armazem(rs.getInt("idArmazem"), rs.getString("endereco"), rs.getInt("idProprietario"), rs.getInt("idProduto"));

                System.out.println("Endereco = " + armazemAux.getEndereco());
                System.out.println("Proprietario = " + armazemAux.getIDProprietario());

                System.out.println("--------------------------------");

                armazens.add(armazemAux);
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
