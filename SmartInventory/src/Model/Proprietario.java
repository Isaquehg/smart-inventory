package Model;

/**
 * Class for Proprietario model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Proprietario {
    /** 
     * Proprietario table attributes
    */
    private int idProprietario;
    private String nome;

    /**
     * Proprietario constructor and Getters
     */
    public Proprietario(int idProprietario, String nome){
        this.idProprietario = idProprietario;
        this.nome = nome;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public String getNome() {
        return nome;
    }
}
