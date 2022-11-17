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

    /**
     * Constructor and Getters & Setters
     */
    public EstoqueHasProduto(){
    }

    public int getIdEstoque(){
        return idEstoque;
    }
    public int getIdProduto(){
        return idProduto;
    }
}
