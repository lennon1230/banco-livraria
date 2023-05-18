package Model;

public class Cliente {
    
    
    private int idCliente;
    private String nome;
    private String email;
    private int Telefone_idTelefone;
    private int Endereco_idEndereco;
    
    public Cliente(){}

    public Cliente(int idCliente, String nome, String email, int Telefone_idTelefone, int Endereco_idEndereco){
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.Telefone_idTelefone = Telefone_idTelefone;
        this.Endereco_idEndereco = Endereco_idEndereco;
    }

    public Cliente(String nome, String email, int Telefone_idTelefone, int Endereco_idEndereco){
        this.nome = nome;
        this.email = email;
        this.Telefone_idTelefone = Telefone_idTelefone;
        this.Endereco_idEndereco = Endereco_idEndereco;
    }


    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone_idTelefone() {
        return this.Telefone_idTelefone;
    }

    public void setTelefone_idTelefone(int Telefone_idTelefone) {
        this.Telefone_idTelefone = Telefone_idTelefone;
    }

    public int getEndereco_idEndereco() {
        return this.Endereco_idEndereco;
    }

    public void setEndereco_idEndereco(int Endereco_idEndereco) {
        this.Endereco_idEndereco = Endereco_idEndereco;
    } 

}
