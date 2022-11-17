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
    private int idArmazem;

    /**
     * Constructor and Getters & Setters
    */
    public Funcionario(int idFuncionario, String nome, String cpf, int idArmazem){
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.idArmazem = idArmazem;
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

    public int getIDArmazem(){
        return idArmazem;
    }
}
