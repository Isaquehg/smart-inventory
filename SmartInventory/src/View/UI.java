package View;

import java.util.ArrayList;

import javax.swing.*;

import Model.Armazem;
import Model.Funcionario;

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
    private void deletarArmazem(){

    }
    private void cadastrarProprietario(){

    }
    private void editarProprietario(){

    }
    private void deletarProprietario(){

    }
    private void cadastrarFuncionario(){

    }
    private void editarFuncionario(){

    }
    private void deletarFuncionario(){

    }

    //Aqui serão mostradas informações base do armazem
    private void visualizarDadosArmazem(ArrayList<Armazem> armazens, ArrayList<Funcionario> funcionarios){
        //Buscar os armazens a serem mostrados
        String[] choices = { "ArmazemA", "ArmazemB", "C", "D", "E", "F" };
        for (int i = 0; i < armazens.size(); i++) {
            choices[i] = String.valueOf(armazens.get(i).getIdArmazem());
        }
        String idArmazemString = (String) JOptionPane.showInputDialog(null, "Escolha o armazém",
            "Visualização", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
        int idArmazemEscolhido = Integer.parseInt(idArmazemString);

        //Obter numero de funcionarios
        int nFuncionariosArmazem = 0;
        for (int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getIDArmazem() == armazens.get(idArmazemEscolhido).getIdArmazem()){
                nFuncionariosArmazem ++;
            }
        }

        //Mostrar seus dados
        Object[][] rows = {
            {armazens.get(idArmazemEscolhido).getIdArmazem(),armazens.get(idArmazemEscolhido).getEndereco(),armazens.get(idArmazemEscolhido).getIdProprietario(), nFuncionariosArmazem}
        };
        Object[] cols = {
            "ID","Endereço","Proprietario","Numero de Funcionarios"
        };
        JTable table = new JTable(rows, cols);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }
    //Aqui serão mostrados somente os produtos do armazem escohido
    private void visualizarProdutosArmazem(){

    }
}
