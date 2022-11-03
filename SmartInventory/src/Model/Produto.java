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
    private int localizacao;

    Produto(int idProduto, String nome, int peso, String categoria, int quantidade){
        this.idProduto = idProduto;
        this.nome = nome;
        this.peso = peso;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
}
