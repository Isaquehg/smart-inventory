package Control;

import Model.Produto;
import Model.Armazem;
import Model.ArmazemHasProduto;
import Model.Funcionario;
import Control.ArmazemHasProdutoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe destinada 
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class ProdutoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean createProduto(Produto produto, Armazem armazem, ArmazemHasProduto armazemHasProduto) {
        connectToDB();

        String sqlP = "INSERT INTO Produto (idProduto, nome, categoria, peso, quantidade) VALUES(?, ?, ?, ?, ?)";
        try {
            //Tabela Produto
            pst = con.prepareStatement(sqlP);
            pst.setInt(1, produto.getIdProduto());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getCategoria());
            pst.setInt(4, produto.getPeso());
            pst.setInt(5, 0);//Zerar o estoque quando cadastrar
            pst.execute();

            //Passando idProduto para atualização da tabela ArmazemHasProduto
            armazemHasProduto.setIdProduto(produto.getIdProduto());

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
    //Alterar estoque de um produto OU alterar seus dados de cadastro
    public boolean updateProduto(int id, Produto produto, int op) {
        connectToDB();
        String sql1 = "UPDATE Produto SET quantidade=? where id=?";
        String sql2 = "UPDATE Produto SET nome=?, peso=?, categoria=?, idArmazem=? where id=?";
        //alterar estoque
        if(op == 0){
            try {
                pst = con.prepareStatement(sql1);
                pst.setInt(1, produto.getQuantidade());
                pst.setInt(2, produto.getIdProduto());
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
        }
        //alterar dados cadastrais
        else if(op == 1){
            try {
                pst = con.prepareStatement(sql2);
                pst.setString(1, produto.getNome());
                pst.setString(2, produto.getCategoria());
                pst.setInt(2, produto.getPeso());
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
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteProduto(int id) {
        connectToDB();
        String sql = "DELETE FROM Produto where id=?";
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
    public ArrayList<Produto> selectProduto(int id) {
        ArrayList<Produto> produtos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Produto";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de produtos: ");

            while (rs.next()) {

                Produto produtoAux = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("categoria"), rs.getInt("peso"), rs.getInt("quantidade"));
                
                //Retirar print e enviar dados para UI
                System.out.println("Nome = " + produtoAux.getIdProduto());
                System.out.println("Nome = " + produtoAux.getNome());
                System.out.println("Categoria = " + produtoAux.getCategoria());
                System.out.println("Peso = " + produtoAux.getPeso() + "kg");
                System.out.println("Quantidade = " + produtoAux.getQuantidade());

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
