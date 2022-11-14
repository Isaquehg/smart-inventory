package View;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Control.ArmazemHasProdutoDAO;
import Control.ProdutoDAO;
import Model.Armazem;
import Model.Funcionario;
import Model.Produto;

/**
 * Classe destinada à parte visual do sistema para interação com usuário
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class UI {
    //Interface principal com usuário
    public void inicio(){
        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema Smart Inventory");
        String op = JOptionPane.showInputDialog("Qual operação você deseja realizar? 
        1 - Cadastrar 2 - Editar 3 - Excluir 4 - Vizualizar");
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
    private void visualizarDadosArmazem(ArrayList<Armazem> armazens, ArrayList<Funcionario> funcionarios, ArmazemHasProdutoDAO armazemHasProdutoDAO){
        //Buscar os armazens a serem mostrados
        Armazem armazemAux = null;
        String[] choices = { "ArmazemA", "ArmazemB", "C", "D", "E", "F" };
        for (int i = 0; i < armazens.size(); i++) {
            choices[i] = String.valueOf(armazens.get(i).getIdArmazem());
        }
        String idArmazemString = (String) JOptionPane.showInputDialog(null, "Escolha o armazém",
            "Visualização", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
        int idArmazemEscolhido = Integer.parseInt(idArmazemString);
        for (int i = 0; i < armazens.size(); i++) {
            if(idArmazemEscolhido == armazens.get(i).getIdArmazem()){
                armazemAux = armazens.get(i);
            }
        }

        //Obter numero de funcionarios
        int nFuncionariosArmazem = 0;
        for (int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getIDArmazem() == armazemAux.getIdArmazem()){
                nFuncionariosArmazem ++;
            }
        }

        //Output em JTable
        Object[][] rows = {
            {armazemAux.getIdArmazem(),armazemAux.getEndereco(),armazemAux.getIdProprietario(), nFuncionariosArmazem}
        };
        Object[] cols = {
            "ID","Endereço","Proprietario","Numero de Funcionarios"
        };
        JTable table = new JTable(rows, cols);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
        visualizarProdutosArmazem(armazemAux, armazemHasProdutoDAO.selectAhasP());
    }
    //Aqui serão mostrados somente os PRODUTOS do armazem escohido
    private void visualizarProdutosArmazem(Armazem armazemEscolhido, HashMap<Integer, Integer> armazemHasProduto){
        //Encontrar PK == FK
        ArrayList<Integer> pkProdutos = new ArrayList<>();
        for (int i : armazemHasProduto.keySet()) {
            if(i == armazemEscolhido.getIdArmazem()){
                pkProdutos.add(armazemHasProduto.get(i));
            }
        }
        //selecionando todos produtos do armazem escolhido
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtosArmazem = produtoDAO.selectProduto(armazemEscolhido.getIdArmazem());
        
        //Mostrar dados desses produtos do armazem utilizando JTable
        JTable tabelaProdutos = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
       
       //Header
       String header[] = new String[] { "ID Produto", "Nome", "Categoria",
                   "Peso", "Quantidade"};
       
       //Adicionar header no Table Model
        dtm.setColumnIdentifiers(header);
            //set model into the table object
            tabelaProdutos.setModel(dtm);
       
        //Adicionar dados dinamicamente à tabela 
       for (int i = 0; i < produtosArmazem.size(); i ++) {
               dtm.addRow(new Object[] { "data", "data", "data",
                       "data", "data"});
        }
    }
}
