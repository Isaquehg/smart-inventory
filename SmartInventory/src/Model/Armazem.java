package Model;

/**
 * Classe destinada 
 * @author Isaque
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

    public int getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(int idArmazem) {
        this.idArmazem = idArmazem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }
}
