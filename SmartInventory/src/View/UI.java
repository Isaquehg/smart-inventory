package View;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Control.EstoqueDAO;
import Control.EstoqueHasProdutoDAO;
import Control.FuncionarioDAO;
import Control.ProdutoDAO;
import Control.ProprietarioDAO;
import Model.Estoque;
import Model.EstoqueHasProduto;
import Model.Funcionario;
import Model.Produto;
import Model.Proprietario;

/**
 * Class for User interactivity
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class UI {
    //Main activity
    /**
     * Class for starting user interaction
     * Operations are divided into 4 sections:
     * 1 - Registration
     * 2 - Update
     * 3 - Delete
     * 4 - Visualization
     * Inside of them, the user can choose among the tables to do the selected operation
     */
    public void inicio(){
        JOptionPane.showMessageDialog(null, "Bem vindo!", "Smart Inventory", JOptionPane.INFORMATION_MESSAGE);

        int continuar = 1;
        while(continuar == 1){
            String opString = JOptionPane.showInputDialog("Qual operação você deseja realizar? 1 - Cadastrar 2 - Editar 3 - Excluir 4 - Vizualizar");
            int op1 = Integer.parseInt(opString);
            if(op1 == 1){
                String op2String = JOptionPane.showInputDialog("Qual cadastro você deseja realizar?? 1 - Proprietario 2 - Estoque 3 - Produto 4 - Funcionario");
                int op2 = Integer.parseInt(op2String);
                if(op2 == 1)
                    cadastrarProprietario();
                else if(op2 == 2)
                    cadastrarEstoque();
                else if(op2 == 3)
                    cadastrarProduto();
                else if(op2 == 4)
                    cadastrarFuncionario();
                else
                    JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            else if(op1 == 2){
                String op2String = JOptionPane.showInputDialog("Qual Edição você deseja realizar?? 1 - Proprietario 2 - Estoque 3 - Produto 4 - Funcionario");
                int op2 = Integer.parseInt(op2String);
                if(op2 == 1){
                    editarProprietario();
                }
                else if(op2 == 2){
                    editarEstoque();
                }
                else if(op2 == 3){
                    String op3String = JOptionPane.showInputDialog("Você deseja cadastrar um novo produto ou inserir estoque? 1 - Editar dados de cadastro  2 - Alterar estoque");
                    int op3 = Integer.parseInt(op3String);    
                    if(op3 == 1){
                        editarProduto();
                    }
                    else if(op3 == 2){
                        editarEstoqueProduto();
                    }
                }
                else if(op2 == 4){
                    editarFuncionario();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(op1 == 3){
                String op2String = JOptionPane.showInputDialog("Qual Exclusão você deseja realizar?? 1 - Proprietario 2 - Estoque 3 - Produto 4 - Funcionario");
                int op2 = Integer.parseInt(op2String);
                if(op2 == 1)
                    deletarProprietario();
                else if(op2 == 2)
                    deletarEstoque();
                else if(op2 == 3)
                    deletarProduto();
                else if(op2 == 4)
                    deletarFuncionario();
                else
                    JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            else if(op1 == 4){
                String op3String = JOptionPane.showInputDialog("o que você deseja visualizar? 1 - Produtos por Estoque  2 - Todos produtos");
                int op3 = Integer.parseInt(op3String);
                if(op3 == 1)
                    visualizarDadosEstoque();
                else if(op3 == 2)
                    vizualizarTodosProdutos();
            }
            else{
                JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            String continuarString = JOptionPane.showInputDialog("Deseja realizar outra operação? 1-SIM 2-NAO");
            continuar = Integer.parseInt(continuarString);
        }
    }

    /**
     * Funtion for storage registration UI
     */
    private void cadastrarEstoque(){
        //User input
        String idEstoqueString = JOptionPane.showInputDialog("Entre com o ID do estoque");
        int idEstoque = Integer.parseInt(idEstoqueString);
        String enderecoEstoque = JOptionPane.showInputDialog("Entre com o Endereco do estoque");
        String idProprietarioEstoqueString = JOptionPane.showInputDialog("Entre com o ID do proprietario do estoque");
        int idProprietarioEstoque = Integer.parseInt(idProprietarioEstoqueString);

        //Passing data to DAO
        Estoque estoque = new Estoque(idEstoque, enderecoEstoque, idProprietarioEstoque);
        EstoqueDAO estoqueDAO = new EstoqueDAO();

        boolean success = estoqueDAO.createEstoque(estoque);
        if(success)
            JOptionPane.showMessageDialog(null, "Estoque cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Cadastro não concluído","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for storage registration update UI
     */
    private void editarEstoque(){
        //User input
        String idEstoqueString = JOptionPane.showInputDialog("Entre com o ID do estoque a editar");
        int idEstoque = Integer.parseInt(idEstoqueString);
        String enderecoEstoque = JOptionPane.showInputDialog("Entre com o novo endereco do estoque");
        String idProprietarioEstoqueString = JOptionPane.showInputDialog("Entre com o novo ID do proprietario do estoque");
        int idProprietarioEstoque = Integer.parseInt(idProprietarioEstoqueString);

        //Passing data through DAO
        Estoque estoque = new Estoque(idEstoque, enderecoEstoque, idProprietarioEstoque);
        EstoqueDAO EstoqueDAO = new EstoqueDAO();
        boolean success = EstoqueDAO.updateEstoque(estoque);
        if(success)
        JOptionPane.showMessageDialog(null, "Estoque editado com sucesso!");
        else
        JOptionPane.showMessageDialog(null, "Edição não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for storage delete UI
     */
    private void deletarEstoque(){
        //User input
        String idEstoqueString = JOptionPane.showInputDialog("Entre com o ID do estoque a excluir");
        int idEstoque = Integer.parseInt(idEstoqueString);

        //Passing data through DAO
        EstoqueDAO EstoqueDAO = new EstoqueDAO();
        boolean success = EstoqueDAO.deleteEstoque(idEstoque);
        if(success)
        JOptionPane.showMessageDialog(null, "Estoque excluído com sucesso!");
        else
        JOptionPane.showMessageDialog(null, "Exclusão não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for owner registration UI
     */
    private void cadastrarProprietario(){
        //User input
        String idProprietarioString = JOptionPane.showInputDialog("Entre com o ID do Proprietário");
        int idProprietario = Integer.parseInt(idProprietarioString);
        String nomeProprietario = JOptionPane.showInputDialog("Entre com o nome do proprietário");

        //Passing data to DAO
        Proprietario proprietario = new Proprietario(idProprietario, nomeProprietario);
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        boolean success = proprietarioDAO.createProprietario(proprietario);
        if(success)
            JOptionPane.showMessageDialog(null, "Proprietario cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Cadastro não concluído","Aviso!", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * Funtion for owner update UI
     */
    private void editarProprietario(){
        //User input
        String idProprietarioString = JOptionPane.showInputDialog("Entre com o ID do Proprietário");
        int idProprietario = Integer.parseInt(idProprietarioString);
        String nomeProprietario = JOptionPane.showInputDialog("Entre com o novo nome do proprietário");

        //Passing data to DAO
        Proprietario proprietario = new Proprietario(idProprietario, nomeProprietario);
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        boolean success = proprietarioDAO.updateProprietario(proprietario);
        if(success)
            JOptionPane.showMessageDialog(null, "Proprietario editado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Edição não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for owner delete UI
     */
    private void deletarProprietario(){
        //User input
        String idProprietarioString = JOptionPane.showInputDialog("Entre com o ID do Proprietário a Excluir");
        int idProprietario = Integer.parseInt(idProprietarioString);

        //Passing data to DAO
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        boolean success = proprietarioDAO.deleteProprietario(idProprietario);
        if(success)
            JOptionPane.showMessageDialog(null, "Proprietário excluído com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Exclusão não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for employee registration UI
     */
    private void cadastrarFuncionario(){
        //User input
        String idFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do Funcionario");
        int idFuncionario = Integer.parseInt(idFuncionarioString);
        String nomeFuncionario = JOptionPane.showInputDialog("Entre com o nome do Funcionário");
        String cpfFuncionario = JOptionPane.showInputDialog("Entre com o CPF do Funcionário");
        String idEstoqueFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do estoque");
        int idEstoqueFuncionario = Integer.parseInt(idEstoqueFuncionarioString);

        //Passing data to DAO
        Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, idEstoqueFuncionario);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        boolean success = funcionarioDAO.createFuncionario(funcionario);
        if(success)
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Cadastro não concluído","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for employee update UI
     */
    private void editarFuncionario(){
        //User input
        String idFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do Funcionario");
        int idFuncionario = Integer.parseInt(idFuncionarioString);
        String nomeFuncionario = JOptionPane.showInputDialog("Entre com o novo nome do Funcionário");
        String cpfFuncionario = JOptionPane.showInputDialog("Entre com o novo CPF do Funcionário");
        String idEstoqueFuncionarioString = JOptionPane.showInputDialog("Entre com o novo ID do estoque");
        int idEstoqueFuncionario = Integer.parseInt(idEstoqueFuncionarioString);

        //Passing data to DAO
        Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, idEstoqueFuncionario);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        boolean success = funcionarioDAO.updateFuncionario(funcionario);
        if(success)
            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Edição não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for employee delete UI
     */
    private void deletarFuncionario(){
        //User input
        String idFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do Funcionario a excluir");
        int idFuncionario = Integer.parseInt(idFuncionarioString);

        //Passing data to DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        boolean success = funcionarioDAO.deleteFuncionario(idFuncionario);
        if(success)
            JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Exclusão não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for product registration UI
     */
    private void cadastrarProduto(){
        //User input
        String IdProdutoString = JOptionPane.showInputDialog("Insira o ID do produto: ");
        int IdProduto = Integer.parseInt(IdProdutoString);
        String nomeProduto = JOptionPane.showInputDialog("Insira o nome do produto: ");
        String pesoString = JOptionPane.showInputDialog("Insira o peso do produto: ");
        int pesoProduto = Integer.parseInt(pesoString);
        String categoriaProduto = JOptionPane.showInputDialog("Insira a categoria do produto: ");

        //Send data to DAO
        Produto produto = new Produto(IdProduto, nomeProduto, categoriaProduto, pesoProduto);
        ProdutoDAO produtoDAO = new ProdutoDAO();

        boolean success = produtoDAO.createProduto(produto);
        if(success)
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Cadastro não concluído","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    //Inserting inventory to a product in that storage
    /**
     * Funtion for product amount insertion UI
     */
    private void editarProduto(){
        //User input
        String IdProdutoString = JOptionPane.showInputDialog("Insira o ID do produto a editar");
        String nomeProduto = JOptionPane.showInputDialog("Insira o novo nome do produto");
        int IdProduto = Integer.parseInt(IdProdutoString);
        String pesoString = JOptionPane.showInputDialog("Insira o novo peso do produto");
        int pesoProduto = Integer.parseInt(pesoString);
        String categoriaProduto = JOptionPane.showInputDialog("Insira a nova categoria do produto");

        //Send data to DAO
        Produto produto = new Produto(IdProduto, nomeProduto, categoriaProduto, pesoProduto);
        ProdutoDAO produtoDAO = new ProdutoDAO();

        boolean success = produtoDAO.updateProduto(produto);
        if(success)
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Edição não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * UI for editing product amount from some storage
     */
    private void editarEstoqueProduto(){
        //User input
        String idProdutoString = JOptionPane.showInputDialog("Insira o ID do produto a inserir estoque");
        int idProduto = Integer.parseInt(idProdutoString);
        String idEstoqueProdutoString = JOptionPane.showInputDialog("Insira o ID do local que será inserido a quantidade");
        int idEstoqueProduto = Integer.parseInt(idEstoqueProdutoString);
        String quantidadeString = JOptionPane.showInputDialog("Insira a quantidade desse produto");
        int quantidade = Integer.parseInt(quantidadeString);

        //Send data to DAO
        EstoqueHasProduto estoqueHasProduto = new EstoqueHasProduto(idEstoqueProduto, idProduto, quantidade);
        EstoqueHasProdutoDAO estoqueHasProdutoDAO = new EstoqueHasProdutoDAO();
        boolean success = estoqueHasProdutoDAO.createAhasP(estoqueHasProduto);
        if(success)
            JOptionPane.showMessageDialog(null, "Estoque adicionado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Inserção não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Funtion for product delete UI
     */
    private void deletarProduto(){
        //User input
        String IdProdutoString = JOptionPane.showInputDialog("Insira o ID do produto a excluir");
        int IdProduto = Integer.parseInt(IdProdutoString);

        //Send data to DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean success = produtoDAO.deleteProduto(IdProduto);
        if(success)
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Exclusão não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }

    //Storages drop-down list
    /**
     * Function for storage registration details UI
     */
    private void visualizarDadosEstoque(){
        //Creating Auxliar instances
        EstoqueDAO EstoqueDAO = new EstoqueDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        //Getting SELECT from DAO
        ArrayList<Estoque> estoques = EstoqueDAO.selectEstoque();
        ArrayList<Funcionario> funcionarios = funcionarioDAO.selectFuncionario();

        //Searching for storages
        Estoque EstoqueAux = null;
        String[] choices = new String[100];
        for (int i = 0; i < estoques.size(); i++) {
            choices[i] = String.valueOf(estoques.get(i).getIdEstoque());
        }

        //Displaying storages
        String idEstoqueString = (String) JOptionPane.showInputDialog(null, "Escolha o estoque",
            "Visualização", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        int idEstoqueEscolhido = Integer.parseInt(idEstoqueString);
        for (int i = 0; i < estoques.size(); i++) {
            if(idEstoqueEscolhido == estoques.get(i).getIdEstoque()){
                EstoqueAux = estoques.get(i);
            }
        }

        //Getting employees number from that storage
        int nFuncionariosEstoque = 0;
        for (int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getIdEstoque() == EstoqueAux.getIdEstoque()){
                nFuncionariosEstoque ++;
            }
        }

        //Output using JTable
        Object[][] rows = {
            {EstoqueAux.getIdEstoque(),EstoqueAux.getEndereco(),EstoqueAux.getIdProprietario(), nFuncionariosEstoque}
        };
        Object[] cols = {
            "ID", "Endereço", "ID Proprietario", "Numero de Funcionarios"
        };
        JTable table = new JTable(rows, cols);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));

        //Displaying Products in this storage
        visualizarProdutosEstoque(EstoqueAux);
    }

    //Here's gonna be shown only products from that storage
    /**
     * UI for displaying products from some storage
     */
    private void visualizarProdutosEstoque(Estoque estoqueEscolhido){
        //Generating auxliar DAO instances for SELECT
        EstoqueHasProdutoDAO estoqueHasProdutoDAO = new EstoqueHasProdutoDAO();
        ArrayList<EstoqueHasProduto> estoqueHasProduto = estoqueHasProdutoDAO.selectAhasP();

        //Finding PK == FK
        //ArrayList containing ID and product amount from selected storage
        ArrayList<Integer> pkProdutos = new ArrayList<>();
        ArrayList<Integer> quantidadeProdutos = new ArrayList<>();

        for (int i = 0; i < estoqueHasProduto.size(); i ++) {
            if(estoqueHasProduto.get(i).getIdEstoque() == estoqueEscolhido.getIdEstoque()){
                pkProdutos.add(estoqueHasProduto.get(i).getIdProduto());
                quantidadeProdutos.add(estoqueHasProduto.get(i).getQuantidade());
            }
        }

        //Selecting products from this specific storage
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.selectProduto();

        //ArrayLists for storing data from intermediate table
        ArrayList<Produto> produtosEstoque = new ArrayList<>();
        ArrayList<Integer> quantidadeProdutoEstoque = new ArrayList<>();

        //Picking the products up from this storage
        for (int i = 0; i < produtos.size(); i++) {
            for(int j = 0; j < pkProdutos.size(); j ++){
                try {
                    if(produtos.get(i).getIdProduto() == pkProdutos.get(j)){
                        produtosEstoque.add(produtos.get(i));
                        quantidadeProdutoEstoque.add(quantidadeProdutos.get(j));
                    }
                }
                catch(IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
        }
        
        //Displaying data from this storage using JTable
        JTable tabelaProdutos = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
       
       //Header
       String header[] = new String[] { 
        "ID Produto", "Nome", "Categoria", "Peso", "Quantidade"
        };
       
       //Adding header on Table Model
        dtm.setColumnIdentifiers(header);
            //set model into the table object
            tabelaProdutos.setModel(dtm);
       
       //Adding data dinamically to table
       for (int i = 0; i < produtosEstoque.size(); i ++) {
            dtm.addRow(new Object[] { 
                produtosEstoque.get(i).getIdProduto(), produtosEstoque.get(i).getNome(), produtosEstoque.get(i).getCategoria(), produtosEstoque.get(i).getPeso(), quantidadeProdutoEstoque.get(i)
            });
        }
        JOptionPane.showMessageDialog(null, new JScrollPane(tabelaProdutos));
    }

    
    /**
     * Displaying all products and its total amount
     */
    private void vizualizarTodosProdutos(){
        ArrayList<Produto> produtos = new ArrayList<>();

        //Selecting all products
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.selectProduto();

        //Catching amount from that product from all storages
        //ArrayList with inventory amount from each product ID
        ArrayList<Integer> estoqueTotal = new ArrayList<>();
        EstoqueHasProdutoDAO estoqueHasProdutoDAO = new EstoqueHasProdutoDAO();
        ArrayList<EstoqueHasProduto> estoqueHasProduto = estoqueHasProdutoDAO.selectAhasP();

        //Iterating through Intermediate table and Products table
        for (int i = 0; i < estoqueHasProduto.size(); i++) {
            for (int k = 0; k < produtos.size(); k++) {
                try{
                    if(estoqueHasProduto.get(i).getIdProduto() == produtos.get(k).getIdProduto()){
                        estoqueTotal.add(k, estoqueHasProduto.get(i).getQuantidade());
                    }
                }
                catch(IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
        }

        //Displaying data from this storage using JTable
        JTable tabelaProdutos = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
       
       //Header
       String header[] = new String[] { 
        "ID Produto", "Nome", "Categoria", "Peso(g)", "Quantidade Total"
        };
       
       //Adding header on Table Model
        dtm.setColumnIdentifiers(header);
            //set model into the table object
            tabelaProdutos.setModel(dtm);
       
       //Adding data dinamically to table
       try{
            for (int i = 0; i < produtos.size(); i ++) {
                dtm.addRow(new Object[] { 
                    produtos.get(i).getIdProduto(), produtos.get(i).getNome(), produtos.get(i).getCategoria(), produtos.get(i).getPeso(), estoqueTotal.get(i)
                });
            }
       }
       catch(IndexOutOfBoundsException e){
            e.printStackTrace();
       }
            
        JOptionPane.showMessageDialog(null, new JScrollPane(tabelaProdutos));
    }
}
