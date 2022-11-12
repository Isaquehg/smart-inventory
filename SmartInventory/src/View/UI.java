package View;

import javax.swing.*;

/**
 * Classe destinada à parte visual do sistema, com interação com usuário
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class UI {
    //Interface principal com usuário
    public void inicio(){
        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema Smart Inventory");
    }

    //Cadastro de novos produtos
    private void cadastroProduto(){
        String nomeProduto = JOptionPane.showInputDialog("Insira o nome do produto: ");

        String IDProdutoString = JOptionPane.showInputDialog("Insira o ID do produto: ");
        int IDProduto = Integer.parseInt(IDProdutoString);

        String pesoString = JOptionPane.showInputDialog("Insira o peso do produto: ");
        int pesoProduto = Integer.parseInt(pesoString);

        String categoriaProduto = JOptionPane.showInputDialog("Insira a categoria do produto: ");
    }

    //Inserção de estoque junto com localizacao
    private void inserirEstoque(){
        String produtoInserirIDString = JOptionPane.showInputDialog("Escolha o produto a inserir estoque: ");
        int produtoInserirID = Integer.parseInt(produtoInserirIDString);

        String localInserirProdutoString = JOptionPane.showInputDialog("Local a inserir o produto: ");
        int localInserirProduto = Integer.parseInt(localInserirProdutoString);

        String quantidadeInserirProdutoString = JOptionPane.showInputDialog("Quantidade a inserir desse produto: ");
        int quantidadeInserirProduto = Integer.parseInt(quantidadeInserirProdutoString);
    }
    private void removerEstoque(){
        String produtoIDExcluirString = JOptionPane.showInputDialog("ID do produto a excluir: ");
        int produtoIDExcluir = Integer.parseInt(produtoIDExcluirString);
    }
    private void cadastrarArmazem(){

    }
    private void editarArmazem(){

    }
    private void excluirArmazem(){

    }
    private void criarProprietario(){
        
    }
}
