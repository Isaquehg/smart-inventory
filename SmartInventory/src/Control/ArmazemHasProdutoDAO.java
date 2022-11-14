package Control;

import Model.ArmazemHasProduto;
import java.sql.SQLException;
import java.util.HashMap;

public class ArmazemHasProdutoDAO extends ConnectionDAO{
    boolean sucesso = false;

    //Realizar a atualização da tabela ArmazemhasProduto após a inserção de um novo produto
    public void updateAhasP(ArmazemHasProduto armazemHasProduto) {
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
    public HashMap<Integer, Integer> selectAhasP(){
        HashMap<Integer, Integer> aHasProdutos = new HashMap<>();
        connectToDB();
        String sql = "SELECT * FROM Armazem_has_Produto";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de relações Produtos X Armazens: ");

            while (rs.next()) {
                ArmazemHasProduto aHasProdutoAux = new ArmazemHasProduto(rs.getInt("Armazem_idArmazem"), rs.getInt("Produto_idProduto"));

                //Retirar print e enviar dados para UI
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
}
