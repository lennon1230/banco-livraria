package Model;

public class Pedido {
    
    private int idPedido;
    private int quantidade;
    private double valor;
    private String data_pedido;
    private int Editora_idEditora;
    private int Cliente_idCliente;

    public Pedido(){}

    public Pedido(int idPedido, int quantidade, double valor, String data_pedido, int Editora_idEditora, int Cliente_idCliente) {
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data_pedido = data_pedido;
        this.Editora_idEditora = Editora_idEditora;
        this.Cliente_idCliente = Cliente_idCliente;
    }

    public Pedido(int quantidade, double valor, String data_pedido, int Editora_idEditora, int Cliente_idCliente) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.data_pedido = data_pedido;
        this.Editora_idEditora = Editora_idEditora;
        this.Cliente_idCliente = Cliente_idCliente;
    }
    

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_pedido() {
        return this.data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public int getEditora_idEditora() {
        return this.Editora_idEditora;
    }

    public void setEditora_idEditora(int Editora_idEditora) {
        this.Editora_idEditora = Editora_idEditora;
    }

    public int getCliente_idCliente() {
        return this.Cliente_idCliente;
    }

    public void setCliente_idCliente(int Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }    
    
}
