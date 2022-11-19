package Model;

/**
 * Class for Estoque_has_Produto model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class EstoqueHasProduto {
    /**
     * EstoqueHasProduto table attributes
     */
    private int idEstoque;
    private int idProduto;
    private int quantidade;

    /**
     * Constructor
     */
    public EstoqueHasProduto(int idEstoque, int idProduto, int quantidade){
        this.idEstoque = idEstoque;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    //Getters
    /**
     * Getters
     * @return attributes from EstoqueHasProduto
     */
    public int getIdEstoque(){
        return idEstoque;
    }
    public int getIdProduto(){
        return idProduto;
    }
    public int getQuantidade(){
        return quantidade;
    }
}
