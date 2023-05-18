package Model;

public class Autor_has_Livro {
    
    private int Autor_idAutor;
    private int Livro_idLivro;

    public Autor_has_Livro(){}

    public Autor_has_Livro(int Autor_idAutor, int Livro_idLivro){
        this.Autor_idAutor = Autor_idAutor;
        this.Livro_idLivro = Livro_idLivro;
    }

    
    public int getAutor_idAutor() {
        return this.Autor_idAutor;
    }

    public void setAutor_idAutor(int Autor_idAutor) {
        this.Autor_idAutor = Autor_idAutor;
    }

    public int getLivro_idLivro() {
        return this.Livro_idLivro;
    }

    public void setLivro_idLivro(int Livro_idLivro) {
        this.Livro_idLivro = Livro_idLivro;
    }
    
}
