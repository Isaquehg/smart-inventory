package Model;
public abstract class Produto {
    private String nome;
    private int peso;
    private String categoria;
    private int quantidade;

    Produto(String nome, int peso, String categoria, int quantidade){
        this.nome = nome;
        this.peso = peso;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
}
