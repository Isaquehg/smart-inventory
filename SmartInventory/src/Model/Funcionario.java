package Model;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String cpf;
    private int idArmazem;

    public Funcionario(int idFuncionario, String nome, String cpf, int idArmazem){
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.idArmazem = idArmazem;
    }
    
}
