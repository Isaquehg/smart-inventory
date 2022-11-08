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
    private Funcionario[] funcionarios = new Funcionario[100];
    private Produto[] produtos = new Produto[1000];

    Armazem(int idArmazem, String endereco, Funcionario[] funcionarios, Produto[] produtos){
        this.idArmazem = idArmazem;
        this.endereco = endereco;
        this.funcionarios = funcionarios;
        this.produtos = produtos;
    }
}
