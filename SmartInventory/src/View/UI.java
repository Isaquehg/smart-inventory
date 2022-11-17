package View;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Control.ArmazemDAO;
import Control.ArmazemHasProdutoDAO;
import Control.FuncionarioDAO;
import Control.ProdutoDAO;
import Control.ProprietarioDAO;
import Model.Armazem;
import Model.ArmazemHasProduto;
import Model.Funcionario;
import Model.Produto;
import Model.Proprietario;

/**
 * Classe destinada à parte visual do sistema para interação com usuário
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class UI {
    //Interface principal com usuário
    public void inicio(){
        JOptionPane.showMessageDialog(null, "Bem vindo!", "Smart Inventory", JOptionPane.INFORMATION_MESSAGE);

        int continuar = 1;
        while(continuar == 1){
            String opString = JOptionPane.showInputDialog("Qual operação você deseja realizar? 1 - Cadastrar 2 - Editar 3 - Excluir 4 - Vizualizar");
            int op1 = Integer.parseInt(opString);
            if(op1 == 1){
                String op2String = JOptionPane.showInputDialog("Qual cadastro você deseja realizar?? 1 - Proprietario 2 - Armazem 3 - Produto 4 - Funcionario");
                int op2 = Integer.parseInt(op2String);
                if(op2 == 1)
                    cadastrarProprietario();
                else if(op2 == 2)
                    cadastrarArmazem();
                else if(op2 == 3)
                    cadastrarProduto();
                else if(op2 == 4)
                    cadastrarFuncionario();
                else
                    JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            else if(op1 == 2){
                String op2String = JOptionPane.showInputDialog("Qual Edição você deseja realizar?? 1 - Proprietario 2 - Armazem 3 - Produto 4 - Funcionario");
                int op2 = Integer.parseInt(op2String);
                if(op2 == 1)
                    editarProprietario();
                else if(op2 == 2)
                    editarArmazem();
                else if(op2 == 3)
                    editarProduto();
                else if(op2 == 4)
                    editarFuncionario();
                else
                    JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            else if(op1 == 3){
                String op2String = JOptionPane.showInputDialog("Qual Exclusão você deseja realizar?? 1 - Proprietario 2 - Armazem 3 - Produto 4 - Funcionario");
                int op2 = Integer.parseInt(op2String);
                if(op2 == 1)
                    deletarProprietario();
                else if(op2 == 2)
                    deletarArmazem();
                else if(op2 == 3)
                    deletarProduto();
                else if(op2 == 4)
                    deletarFuncionario();
                else
                    JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            else if(op1 == 4){
                visualizarDadosArmazem();
            }
            else{
                JOptionPane.showMessageDialog(null, "Não é uma operação válida","Aviso!", JOptionPane.WARNING_MESSAGE);
            }
            String continuarString = JOptionPane.showInputDialog("Deseja realizar outra operação? 1-SIM 2-NAO");
            continuar = Integer.parseInt(continuarString);
        }
    }

    private void cadastrarArmazem(){
        //User input
        String idArmazemString = JOptionPane.showInputDialog("Entre com o ID do armazém");
        int idArmazem = Integer.parseInt(idArmazemString);
        String enderecoArmazem = JOptionPane.showInputDialog("Entre com o Endereco do armazém");
        String idProprietarioArmazemString = JOptionPane.showInputDialog("Entre com o ID do proprietario do armazém");
        int idProprietarioArmazem = Integer.parseInt(idProprietarioArmazemString);

        //Passing data to DAO
        Armazem armazem = new Armazem(idArmazem, enderecoArmazem, idProprietarioArmazem);
        ArmazemDAO armazemDAO = new ArmazemDAO();
        ArmazemHasProduto armazemHasProduto = new ArmazemHasProduto();
        armazemHasProduto.setIdArmazem(idArmazem);
        boolean success = armazemDAO.createArmazem(armazem, armazemHasProduto);
        if(success)
            JOptionPane.showMessageDialog(null, "Armazém cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Cadastro não concluído","Aviso!", JOptionPane.WARNING_MESSAGE);
    }
    private void editarArmazem(){
        //User input
        String idArmazemString = JOptionPane.showInputDialog("Entre com o ID do armazém a editar");
        int idArmazem = Integer.parseInt(idArmazemString);
        String enderecoArmazem = JOptionPane.showInputDialog("Entre com o novo Endereco do armazém");
        String idProprietarioArmazemString = JOptionPane.showInputDialog("Entre com o novo ID do proprietario do armazém");
        int idProprietarioArmazem = Integer.parseInt(idProprietarioArmazemString);

        //Passing data through DAO
        Armazem armazem = new Armazem(idArmazem, enderecoArmazem, idProprietarioArmazem);
        ArmazemDAO armazemDAO = new ArmazemDAO();
        boolean success = armazemDAO.updateArmazem(armazem);
        if(success)
        JOptionPane.showMessageDialog(null, "Armazém editado com sucesso!");
        else
        JOptionPane.showMessageDialog(null, "Edição não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }
    private void deletarArmazem(){
        //User input
        String idArmazemString = JOptionPane.showInputDialog("Entre com o ID do armazém a excluir");
        int idArmazem = Integer.parseInt(idArmazemString);

        //Passing data through DAO
        ArmazemDAO armazemDAO = new ArmazemDAO();
        boolean success = armazemDAO.deleteArmazem(idArmazem);
        if(success)
        JOptionPane.showMessageDialog(null, "Armazém excluído com sucesso!");
        else
        JOptionPane.showMessageDialog(null, "Exclusão não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }
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
    private void cadastrarFuncionario(){
        //User input
        String idFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do Funcionario");
        int idFuncionario = Integer.parseInt(idFuncionarioString);
        String nomeFuncionario = JOptionPane.showInputDialog("Entre com o nome do Funcionário");
        String cpfFuncionario = JOptionPane.showInputDialog("Entre com o CPF do Funcionário");
        String idArmazemFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do Armazém");
        int idArmazemFuncionario = Integer.parseInt(idArmazemFuncionarioString);

        //Passing data to DAO
        Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, idArmazemFuncionario);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        boolean success = funcionarioDAO.createFuncionario(funcionario);
        if(success)
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Cadastro não concluído","Aviso!", JOptionPane.WARNING_MESSAGE);
    }
    private void editarFuncionario(){
        //User input
        String idFuncionarioString = JOptionPane.showInputDialog("Entre com o ID do Funcionario");
        int idFuncionario = Integer.parseInt(idFuncionarioString);
        String nomeFuncionario = JOptionPane.showInputDialog("Entre com o novo nome do Funcionário");
        String cpfFuncionario = JOptionPane.showInputDialog("Entre com o novo CPF do Funcionário");
        String idArmazemFuncionarioString = JOptionPane.showInputDialog("Entre com o novo ID do Armazém");
        int idArmazemFuncionario = Integer.parseInt(idArmazemFuncionarioString);

        //Passing data to DAO
        Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, idArmazemFuncionario);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        boolean success = funcionarioDAO.updateFuncionario(funcionario);
        if(success)
            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Edição não concluída","Aviso!", JOptionPane.WARNING_MESSAGE);
    }
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

    private void cadastrarProduto(){
        //User input
        String nomeProduto = JOptionPane.showInputDialog("Insira o nome do produto: ");
        String IdProdutoString = JOptionPane.showInputDialog("Insira o ID do produto: ");
        int IdProduto = Integer.parseInt(IdProdutoString);
        String pesoString = JOptionPane.showInputDialog("Insira o peso do produto: ");
        int pesoProduto = Integer.parseInt(pesoString);
        String categoriaProduto = JOptionPane.showInputDialog("Insira a categoria do produto: ");

        //Send data to DAO
        Produto produto = new Produto(IdProduto, nomeProduto, categoriaProduto, pesoProduto, 0);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        //Passing ID to intermediate table Armazem_has_Produtos
        ArmazemHasProduto armazemHasProduto = new ArmazemHasProduto();
        armazemHasProduto.setIdProduto(IdProduto);

        produtoDAO.createProduto(produto, armazemHasProduto);
    }

    //Inserting inventory to a product in that storage
    private void editarProduto(){
        //User input
        String IdProdutoString = JOptionPane.showInputDialog("Insira o ID do produto a editar");
        String nomeProduto = JOptionPane.showInputDialog("Insira o novo nome do produto");
        int IdProduto = Integer.parseInt(IdProdutoString);
        String pesoString = JOptionPane.showInputDialog("Insira o novo peso do produto");
        int pesoProduto = Integer.parseInt(pesoString);
        String categoriaProduto = JOptionPane.showInputDialog("Insira a nova categoria do produto");
        String idArmazemProdutoString = JOptionPane.showInputDialog("Insira o novo ID do armazém do produto");
        int idArmazemProduto = Integer.parseInt(idArmazemProdutoString);

        //Send data to DAO
        Produto produto = new Produto(IdProduto, nomeProduto, categoriaProduto, pesoProduto, 0);
        ProdutoDAO produtoDAO = new ProdutoDAO();

        //Passing ID to intermediate table Armazem_has_Produtos
        ArmazemHasProduto armazemHasProduto = new ArmazemHasProduto();
        armazemHasProduto.setIdArmazem(idArmazemProduto);

        produtoDAO.updateProduto(produto, idArmazemProduto);
    }

    private void deletarProduto(){
        //User input
        String IdProdutoString = JOptionPane.showInputDialog("Insira o ID do produto a excluir");
        int IdProduto = Integer.parseInt(IdProdutoString);

        //Send data to DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.deleteProduto(IdProduto);
    }

    //Storages drop-down list
    private void visualizarDadosArmazem(){
        //Creating Auxliar instances
        ArmazemDAO armazemDAO = new ArmazemDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        //Getting SELECT from DAO
        ArrayList<Armazem> armazens = armazemDAO.selectArmazem();
        ArrayList<Funcionario> funcionarios = funcionarioDAO.selectFuncionario();

        //Searching for storages
        Armazem armazemAux = null;
        String[] choices = new String[100];
        for (int i = 0; i < armazens.size(); i++) {
            choices[i] = String.valueOf(armazens.get(i).getIdArmazem());
        }

        //Displaying storages
        String idArmazemString = (String) JOptionPane.showInputDialog(null, "Escolha o armazém",
            "Visualização", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        int idArmazemEscolhido = Integer.parseInt(idArmazemString);
        for (int i = 0; i < armazens.size(); i++) {
            if(idArmazemEscolhido == armazens.get(i).getIdArmazem()){
                armazemAux = armazens.get(i);
            }
        }

        //Getting employees number from that storage
        int nFuncionariosArmazem = 0;
        for (int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).getIDArmazem() == armazemAux.getIdArmazem()){
                nFuncionariosArmazem ++;
            }
        }

        //Output using JTable
        Object[][] rows = {
            {armazemAux.getIdArmazem(),armazemAux.getEndereco(),armazemAux.getIdProprietario(), nFuncionariosArmazem}
        };
        Object[] cols = {
            "ID", "Endereço", "ID Proprietario", "Numero de Funcionarios"
        };
        JTable table = new JTable(rows, cols);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));

        //Displaying Products in this storage
        visualizarProdutosArmazem(armazemAux);
    }

    //Here's gonna be shown only products from that storage
    private void visualizarProdutosArmazem(Armazem armazemEscolhido){
        //Generating auxliar DAO instances for SELECT
        ArmazemHasProdutoDAO armazemHasProdutoDAO = new ArmazemHasProdutoDAO();
        HashMap<Integer, Integer> armazemHasProduto = armazemHasProdutoDAO.selectAhasP();

        //Finding PK == FK
        ArrayList<Integer> pkProdutos = new ArrayList<>();
        for (int i : armazemHasProduto.keySet()) {
            if(i == armazemEscolhido.getIdArmazem()){
                pkProdutos.add(armazemHasProduto.get(i));
            }
        }

        //Selecting products from this specific storage
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.selectProduto();
        ArrayList<Produto> produtosArmazem = new ArrayList<>();
        //Picking the products up from this storage
        for (int i = 0; i < pkProdutos.size(); i++) {
            if(produtos.get(i).getIdProduto() == pkProdutos.get(i)){
                produtosArmazem.add(produtos.get(i));
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
       for (int i = 0; i < produtosArmazem.size(); i ++) {
               dtm.addRow(new Object[] { 
                    produtosArmazem.get(i).getIdProduto(), produtosArmazem.get(i).getNome(), produtosArmazem.get(i).getCategoria(), produtosArmazem.get(i).getPeso(), produtosArmazem.get(i).getQuantidade()
                });
        }
        JOptionPane.showMessageDialog(null, new JScrollPane(tabelaProdutos));
    }
}
