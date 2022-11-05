package Model;

/**
 * Classe destinada 
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Armazem {
    private int idArmazem;
    private Funcionario[] funcionarios = new Funcionario[100];

    Armazem(int idArmazem){
        this.idArmazem = idArmazem;
    }
}
