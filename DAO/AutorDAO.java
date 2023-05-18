package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Autor;

public class AutorDAO {
    
    private final Connection conexao;
    
    public AutorDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Autor> listar(){

        final String SQL = "SELECT * FROM Autor";
        List<Autor> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setIdAutor(rs.getInt("idAutor"));
                autor.setNome(rs.getString("nome"));
                
                lista.add(autor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Autor pesquisar(int idAutor){
        
        final String SQL = "SELECT * FROM Autor WHERE idAutor = ?";
        Autor autor = new Autor();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();
            rs.next();
            autor.setIdAutor(rs.getInt("idAutor"));
            autor.setNome(rs.getString("nome"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autor;
    }

    public void incluir(Autor autor){
        
        final String SQL = "INSERT INTO Autor (nome) VALUES (?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, autor.getNome());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Autor autor){
        final String SQL = "UPDATE Autor SET nome = ? WHERE idAutor = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, autor.getNome());
            ps.setInt(2, autor.getIdAutor());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idAutor){
        
        final String SQL = "DELETE FROM Autor WHERE idAutor = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idAutor);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
