package Model;

/**
 * Classe destinada 
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Produto {
    private int idProduto;
    private String nome;
    private int peso;
    private String categoria;
    private int quantidade;
    private int idArmazem;
    private Armazem[] armazens = new Armazem[25];

    public Produto(int idProduto, String nome, String categoria, int peso, int quantidade, int idArmazem){
        this.idProduto = idProduto;
        this.nome = nome;
        this.peso = peso;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.idArmazem = idArmazem;
    }
}
