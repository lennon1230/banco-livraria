package Model;

public class Cidade {
    
    private int idCidade;
    private String nome;
    private int Estado_idEstado;
    private int ibge;


    public Cidade() {}

    public Cidade(int idCidade, String nome, int Estado_idEstado, int ibge) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.Estado_idEstado = Estado_idEstado;
        this.ibge = ibge;
    }

    public Cidade(String nome, int Estado_idEstado, int ibge) {
        this.nome = nome;
        this.Estado_idEstado = Estado_idEstado;
        this.ibge = ibge;
    }


    public int getIdCidade() {
        return this.idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstado_idEstado() {
        return this.Estado_idEstado;
    }

    public void setEstado_idEstado(int Estado_idEstado) {
        this.Estado_idEstado = Estado_idEstado;
    }

    public int getIbge() {
        return this.ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

}
