package Model;

/**
 * Class for Funcionario model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Funcionario {
    /**
     * Funcionario table attributes
     */
    private int idFuncionario;
    private String nome;
    private String cpf;
    private int idEstoque;

    /**
     * Constructor and Getters
    */
    public Funcionario(int idFuncionario, String nome, String cpf, int idEstoque){
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.idEstoque = idEstoque;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdEstoque(){
        return idEstoque;
    }
}
