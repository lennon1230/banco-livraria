package Model;

public class Telefone {
    
    private int idTelefone;
    private String telefone1;
    private String telefone2;

    public Telefone(){}

    public Telefone(int idTelefone, String telefone1, String telefone2){
        this.idTelefone = idTelefone;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }

    public Telefone(String telefone1, String telefone2){
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
    }

    public Telefone(String telefone1){
        this.telefone1 = telefone1;
    }


    public int getIdTelefone() {
        return this.idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone1() {
        return this.telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return this.telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

}
