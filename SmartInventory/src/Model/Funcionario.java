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

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(int idArmazem) {
        this.idArmazem = idArmazem;
    }
}
