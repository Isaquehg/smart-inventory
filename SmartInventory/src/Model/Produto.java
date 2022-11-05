package Model;

/**
 * Classe destinada 
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public abstract class Produto {
    private int idProduto;
    private String nome;
    private int peso;
    private String categoria;
    private int quantidade;
    private Armazem armazem;
    private Prateleira[] prateleira = new Prateleira[25];

    Produto(int idProduto, String nome, int peso, String categoria, int quantidade, Armazem armazem, Prateleira[] prateleira){
        this.idProduto = idProduto;
        this.nome = nome;
        this.peso = peso;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.armazem = armazem;
        this.prateleira = prateleira;
    }
}
