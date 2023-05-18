package Model;

public class CNPJ {
    
    private String cnpj;
    private int Cliente_idCliente;

    public CNPJ (){}

    public CNPJ(String cnpj, int Cliente_idCliente){
        this.cnpj = cnpj;
        this.Cliente_idCliente = Cliente_idCliente;
    }
    
    public String getCNPJ() {
        return this.cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getCliente_idCliente() {
        return this.Cliente_idCliente;
    }

    public void setCliente_idCliente(int Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

}
