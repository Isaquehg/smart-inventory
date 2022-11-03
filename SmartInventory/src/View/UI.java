package View;

import javax.swing.*;

/**
 * Classe destinada à parte visual do sistema, com interação com usuário
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class UI {
    public void inicio(){
        JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema Smart Inventory");
    }
    private void cadastroProduto(){
        String teste = JOptionPane.showInputDialog("Teste");
        int teste_int = Integer.parseInt(teste);
    }
    private void inserirEstoque(){

    }
    private void removerEstoque(){

    }
}
