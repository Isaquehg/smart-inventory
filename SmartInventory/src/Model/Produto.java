package Model;

/**
 * Class for Product Model
 * @author Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Produto {
    /**
     * Produto table attributes
     */
    private int idProduto;
    private String nome;
    private int peso;
    private String categoria;
    private int quantidade;

    /**
     * Produto constructor and Getters
     */
    public Produto(int idProduto, String nome, String categoria, int peso, int quantidade){
        this.idProduto = idProduto;
        this.nome = nome;
        this.peso = peso;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public int getIdProduto(){
        return idProduto;
    }
    public String getNome(){
        return nome;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getPeso(){
        return peso;
    }
    public int getQuantidade(){
        return quantidade;
    }

}