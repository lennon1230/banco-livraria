package Model;

public class Editora {
    
    private int idEditora;
    private String nome;
    private int Endereco_idEndereco;


    public Editora() {}


    public Editora(int idEditora, String nome, int Endereco_idEndereco) {
        this.idEditora = idEditora;
        this.nome = nome;
        this.Endereco_idEndereco = Endereco_idEndereco;
    }

    public Editora(String nome, int Endereco_idEndereco) {
        this.nome = nome;
        this.Endereco_idEndereco = Endereco_idEndereco;
    }


    public int getIdEditora() {
        return this.idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEndereco_idEndereco() {
        return this.Endereco_idEndereco;
    }

    public void setEndereco_idEndereco(int Endereco_idEndereco) {
        this.Endereco_idEndereco = Endereco_idEndereco;
    }
    
}
