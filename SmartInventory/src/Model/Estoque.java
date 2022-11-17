package Model;

/**
 * Class for Estoque model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Estoque {
    /**
     * Estoque table attributes
     */
    private int idEstoque;
    private String endereco;
    private int idProprietario;

    /**
     * Constructor for Estoque
     * @param idEstoque
     * @param endereco
     * @param idProprietario
     */
    public Estoque(int idEstoque, String endereco, int idProprietario){
        this.idEstoque = idEstoque;
        this.endereco = endereco;
        this.idProprietario = idProprietario;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdProprietario() {
        return idProprietario;
    }
}
