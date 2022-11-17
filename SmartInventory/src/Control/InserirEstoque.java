package Control;

import Model.Produto;

public class InserirEstoque {
    int quantidade;
    Produto produto;
    ProdutoDAO produtoDAO = new ProdutoDAO();
    EstoqueHasProdutoDAO armazemHasProdutoDAO;

    public void InserirEstoque(int quantidade, Produto produto, int idArmazem){
        this.quantidade = quantidade;
        this.produto = produto;
    }
    public void inserir(){
        for (int i = 0; i < quantidade; i++) {
            produtoDAO.createProduto(produto);
        }
    }
}
