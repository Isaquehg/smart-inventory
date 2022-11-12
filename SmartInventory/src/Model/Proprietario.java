package Model;

public class Proprietario {
    private int idProprietario;
    private String nome;
    private int armazemID;

    public Proprietario(int idProprietario, String nome, int armazemID){
        this.idProprietario = idProprietario;
        this.nome = nome;
        this.armazemID = armazemID;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getArmazemID() {
        return armazemID;
    }

    public void setArmazemID(int armazemID) {
        this.armazemID = armazemID;
    }
}
