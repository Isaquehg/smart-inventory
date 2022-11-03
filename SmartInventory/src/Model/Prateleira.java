package Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe destinada 
 * @author IZ & Isaque
 * @version 1.0
 * @since 11/03/2022
 */
public class Prateleira {
    private int idPrateleira;
    private List<Produto> produtos = new ArrayList<>();

    Prateleira(int idPrateleira){
        this.idPrateleira = idPrateleira;
    }
}
