package Model;

public class Pedido_has_Livro {
    
    private int Pedido_idPedido;
    private int Livro_idLivro;

    public Pedido_has_Livro(){}

    public Pedido_has_Livro(int Pedido_idPedido, int Livro_idLivro){
        this.Pedido_idPedido = Pedido_idPedido;
        this.Livro_idLivro = Livro_idLivro;
    }

    
    public int getPedido_idPedido() {
        return this.Pedido_idPedido;
    }

    public void setPedido_idPedido(int Pedido_idPedido) {
        this.Pedido_idPedido = Pedido_idPedido;
    }

    public int getLivro_idLivro() {
        return this.Livro_idLivro;
    }

    public void setLivro_idLivro(int Livro_idLivro) {
        this.Livro_idLivro = Livro_idLivro;
    }
}
