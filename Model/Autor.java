package Model;

public class Autor {
    
    private int idAutor;
    private String nome;

    public Autor(){}

    public Autor(int idAutor, String nome){
        this.idAutor = idAutor;
        this.nome = nome;
    }

    public Autor(String nome){
        this.nome = nome;
    }


    public int getIdAutor() {
        return this.idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
