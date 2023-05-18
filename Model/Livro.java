package Model;

public class Livro {
    
    private int idLivro;
    private String isbn;
    private String titulo;
    private String subtitulo;
    private String categoria;
    private String ano;
    private int quantidade;
    private double preco;
    private int Editora_idEditora;


    public Livro() {}


    public Livro(int idLivro, String isbn, String titulo, String subtitulo, String categoria, String ano, int quantidade, double preco, int Editora_idEditora) {
        this.idLivro = idLivro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.categoria = categoria;
        this.ano = ano;
        this.quantidade = quantidade;
        this.preco = preco;
        this.Editora_idEditora = Editora_idEditora;
    }
    
    public Livro(String isbn, String titulo, String subtitulo, String categoria, String ano, int quantidade, double preco, int Editora_idEditora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.categoria = categoria;
        this.ano = ano;
        this.quantidade = quantidade;
        this.preco = preco;
        this.Editora_idEditora = Editora_idEditora;
    }


    public int getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEditora_idEditora() {
        return this.Editora_idEditora;
    }

    public void setEditora_idEditora(int Editora_idEditora) {
        this.Editora_idEditora = Editora_idEditora;
    }

}
