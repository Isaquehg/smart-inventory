package Model;

public class ArmazemHasProduto {
    private int idArmazem;
    private int idProduto;

    public ArmazemHasProduto(){
    }

    public int getIdArmazem(){
        return idArmazem;
    }
    public int getIdProduto(){
        return idProduto;
    }
    public void setIdArmazem(int id){
        idArmazem = id;
    }
    public void setIdProduto(int id){
        idProduto = id;
    }
}
