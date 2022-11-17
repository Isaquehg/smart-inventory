package Control;

import Model.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false;

    //INSERT
    public boolean createFuncionario(Funcionario funcionario) {

        connectToDB();

        String sql = "INSERT INTO Funcionario (idFuncionario, nome, cpf, Armazem_idArmazem) values(?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, funcionario.getIdFuncionario());
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getCpf());
            pst.setInt(4, funcionario.getIDArmazem());
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
    public boolean updateFuncionario(Funcionario funcionario) {
        connectToDB();
        String sql1 = "UPDATE Funcionario SET nome=?, cpf=?, Armazem_idArmazem=? where id=?";
        //alterar estoque
        try {
            pst = con.prepareStatement(sql1);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getCpf());
            pst.setInt(3, funcionario.getIDArmazem());
            pst.setInt(4, funcionario.getIdFuncionario());
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
    public boolean deleteFuncionario(int id) {
        connectToDB();
        String sql = "DELETE FROM Funcionario where id=?";
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
    public ArrayList<Funcionario> selectFuncionario() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Funcionario";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Funcionarios: ");

            while (rs.next()) {

                Funcionario funcionarioAux = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), rs.getString("cpf"), rs.getInt("Armazem_idArmazem"));

                //Passar print para UI
                System.out.println("ID = " + funcionarioAux.getIdFuncionario());
                System.out.println("Nome = " + funcionarioAux.getNome());
                System.out.println("CPF = " + funcionarioAux.getCpf());
                System.out.println("ID Armazem = " + funcionarioAux.getIDArmazem());

                System.out.println("--------------------------------");

                funcionarios.add(funcionarioAux);
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
        return funcionarios;
    }
}
