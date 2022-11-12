package Model;

/**
 * Classe destinada 
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Armazem {
    private int idArmazem;
    private String endereco;
    private int idProprietario;
    private Funcionario[] funcionarios = new Funcionario[100];

    public Armazem(int idArmazem, String endereco, int idProprietario){
        this.idArmazem = idArmazem;
        this.endereco = endereco;
        this.idProprietario = idProprietario;
    }
}
