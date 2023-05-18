package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Autor_has_Livro;

public class Autor_has_LivroDAO {
    
    private final Connection conexao;
    
    public Autor_has_LivroDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Autor_has_Livro> listar(){

        final String SQL = "SELECT * FROM Autor_has_Livro";
        List<Autor_has_Livro> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Autor_has_Livro al = new Autor_has_Livro();
                al.setAutor_idAutor(rs.getInt("Autor_idAutor"));
                al.setLivro_idLivro(rs.getInt("Livro_idLivro"));
                
                lista.add(al);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Autor_has_Livro pesquisar(int Autor_idAutor, int Livro_idLivro){
        
        final String SQL = "SELECT * FROM Autor_has_Livro WHERE Autor_idAutor = ? and Livro_idLivro = ?";
        Autor_has_Livro al = new Autor_has_Livro();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, Autor_idAutor);
            ps.setInt(2, Livro_idLivro);
            ResultSet rs = ps.executeQuery();
            rs.next();
            al.setAutor_idAutor(rs.getInt("Autor_idAutor"));
            al.setLivro_idLivro(rs.getInt("Livro_idLivro"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }

    public void incluir(Autor_has_Livro al){
        
        final String SQL = "INSERT INTO Autor_has_Livro (Autor_idAutor, Livro_idLivro) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, al.getAutor_idAutor());
            ps.setInt(2, al.getLivro_idLivro());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Autor_has_Livro al, int idAutor, int idLivro){
        final String SQL = "UPDATE Autor_has_Livro SET Autor_idAutor = ?, Livro_idLivro = ? WHERE Autor_idAutor = ?, Livro_idLivro = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idAutor);
            ps.setInt(2, idLivro);
            ps.setInt(3, al.getAutor_idAutor());
            ps.setInt(4, al.getLivro_idLivro());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(Autor_has_Livro al){
        
        final String SQL = "DELETE FROM Autor_has_Livro WHERE Autor_idAutor = ? AND Livro_idLivro = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, al.getAutor_idAutor());
            ps.setInt(2, al.getLivro_idLivro());
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
