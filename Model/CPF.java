package Model;

public class CPF {
    
    private String cpf;
    private int Cliente_idCliente;

    public CPF(){}

    public CPF(String cpf, int Cliente_idCliente){
        this.cpf = cpf;
        this.Cliente_idCliente = Cliente_idCliente;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public int getCliente_idCliente(){
        return this.Cliente_idCliente;
    }

    public void setCliente_idCliente(int Cliente_idCliente){
        this.Cliente_idCliente = Cliente_idCliente;
    }
}
