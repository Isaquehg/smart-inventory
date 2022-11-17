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
    public int idProduto;
    private String nome;
    private int peso;
    private String categoria;

    /**
     * Produto constructor and Getters
     */
    public Produto(int idProduto, String nome, String categoria, int peso){
        this.idProduto = idProduto;
        this.nome = nome;
        this.peso = peso;
        this.categoria = categoria;
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
}