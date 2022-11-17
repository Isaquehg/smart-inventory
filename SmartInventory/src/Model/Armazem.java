package Model;

/**
 * Class for Armazem model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Armazem {
    /**
     * Armazem table attributes
     */
    private int idArmazem;
    private String endereco;
    private int idProprietario;

    /**
     * Constructor for Armazem
     * @param idArmazem
     * @param endereco
     * @param idProprietario
     */
    public Armazem(int idArmazem, String endereco, int idProprietario){
        this.idArmazem = idArmazem;
        this.endereco = endereco;
        this.idProprietario = idProprietario;
    }

    public int getIdArmazem() {
        return idArmazem;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdProprietario() {
        return idProprietario;
    }
}
