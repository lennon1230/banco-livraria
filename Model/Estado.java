package Model;

public class Estado {
    
    private int idEstado;
    private String nome;
    private String sigla;


    public Estado() {}


    public Estado(int idEstado, String nome, String sigla) {
        this.idEstado = idEstado;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }


    public int getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
