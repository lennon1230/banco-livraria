package Model;

public class Endereco {
    
    private int idEndereco;
    private String endereco;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;
    private int Cidade_idCidade;

    public Endereco(){} 

    public Endereco(int idEndereco, String endereco, String rua, String bairro, String numero, String cep, int Cidade_idCidade) {
        this.idEndereco = idEndereco;
        this.endereco = endereco;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.Cidade_idCidade = Cidade_idCidade;
    }

    public Endereco(String endereco, String rua, String bairro, String numero, String cep, int Cidade_idCidade) {
        this.endereco = endereco;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.Cidade_idCidade = Cidade_idCidade;
    }


    public int getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getCidade_idCidade() {
        return this.Cidade_idCidade;
    }

    public void setCidade_idCidade(int Cidade_idCidade) {
        this.Cidade_idCidade = Cidade_idCidade;
    }

}
