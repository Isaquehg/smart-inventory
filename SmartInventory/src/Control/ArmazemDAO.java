package Control;

import Model.Armazem;
import Model.ArmazemHasProduto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArmazemDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean createArmazem(Armazem armazem, ArmazemHasProduto armazemHasProduto) {
        connectToDB();

        String sql = "INSERT INTO Armazem (idArmazem, endereco, Proprietario_idProprietario) values(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, armazem.getIdArmazem());
            pst.setString(2, armazem.getEndereco());
            pst.setInt(3, armazem.getIdProprietario());
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
        //Passando idProduto para atualização da tabela ArmazemHasProduto
        armazemHasProduto.setIdArmazem(armazem.getIdArmazem());
        return sucesso;
    }

    //UPDATE
    public boolean updateArmazem(Armazem armazem) {
        connectToDB();
        String sql1 = "UPDATE Armazem SET endereco=?, Proprietario_idProprietario=? where idArmazem=?";
        //alterar estoque
        try {
            pst = con.prepareStatement(sql1);
            pst.setString(1, armazem.getEndereco());
            pst.setInt(2, armazem.getIdProprietario());
            pst.setInt(3, armazem.getIdArmazem());
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
        String sql = "DELETE FROM Armazem where idArmazem=?";
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
    //Retorna id, endereco e proprietario do armazem
    public ArrayList<Armazem> selectArmazem() {
        ArrayList<Armazem> armazens = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Armazem";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Armazens: ");

            while (rs.next()) {
                Armazem armazemAux = new Armazem(rs.getInt("idArmazem"), rs.getString("endereco"), rs.getInt("Proprietario_idProprietario"));

                //Retirar print e enviar dados para UI
                System.out.println("ID = " + armazemAux.getIdArmazem());
                System.out.println("Endereco = " + armazemAux.getEndereco());
                System.out.println("Proprietario = " + armazemAux.getIdProprietario());

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
