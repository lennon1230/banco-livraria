package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Livro;

public class LivroDAO {
    
    private final Connection conexao;
    
    public LivroDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Livro> listar(){

        final String SQL = "SELECT * FROM Livro";
        List<Livro> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setSubtitulo(rs.getString("subtitulo"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setAno(rs.getString("ano"));
                livro.setQuantidade(rs.getInt("quantidade"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setEditora_idEditora(rs.getInt("Editora_idEditora"));
                
                lista.add(livro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Livro pesquisar(int idLivro){
        
        final String SQL = "SELECT * FROM Livro WHERE idLivro = ?";
        Livro livro = new Livro();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idLivro);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setSubtitulo(rs.getString("subtitulo"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setAno(rs.getString("ano"));
                livro.setQuantidade(rs.getInt("quantidade"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setEditora_idEditora(rs.getInt("Editora_idEditora"));
            }else{
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return livro;
    }

    public void incluir(Livro livro){
        
        final String SQL = "INSERT INTO Livro (isbn, titulo, subtitulo, categoria, ano, quantidade, preco, Editora_idEditora) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setString(3, livro.getSubtitulo());
            ps.setString(4, livro.getCategoria());
            ps.setString(5, livro.getAno());
            ps.setInt(6, livro.getQuantidade());
            ps.setDouble(7, livro.getPreco());
            ps.setInt(8, livro.getEditora_idEditora());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Livro livro){
        final String SQL = "UPDATE Livro SET isbn = ?, titulo = ?, subtitulo = ?, categoria = ?, ano = ?, quantidade = ?, preco = ?, Editora_idEditora = ? WHERE idLivro = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setString(3, livro.getSubtitulo());
            ps.setString(4, livro.getCategoria());
            ps.setString(5, livro.getAno());
            ps.setInt(6, livro.getQuantidade());
            ps.setDouble(7, livro.getPreco());
            ps.setInt(8, livro.getEditora_idEditora());
            ps.setInt(3, livro.getIdLivro());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idLivro){
        
        final String SQL = "DELETE FROM Livro WHERE idLivro = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idLivro);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
