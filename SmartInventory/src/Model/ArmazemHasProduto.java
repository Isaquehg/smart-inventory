package Model;

/**
 * Class for Armazem_has_Produto model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class ArmazemHasProduto {
    /**
     * ArmazemHasProduto table attributes
     */
    private int idArmazem;
    private int idProduto;

    /**
     * Constructor and Getters & Setters
     */
    public ArmazemHasProduto(){
    }

    public int getIdArmazem(){
        return idArmazem;
    }
    public int getIdProduto(){
        return idProduto;
    }
    public void setIdArmazem(int id){
        idArmazem = id;
    }
    public void setIdProduto(int id){
        idProduto = id;
    }
}
