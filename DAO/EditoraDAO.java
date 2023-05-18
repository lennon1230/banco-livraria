package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Editora;

public class EditoraDAO {
    
    private final Connection conexao;
    
    public EditoraDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Editora> listar(){

        final String SQL = "SELECT * FROM Editora";
        List<Editora> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Editora editora = new Editora();
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setNome(rs.getString("nome"));
                editora.setEndereco_idEndereco(rs.getInt("Endereco_idEndereco"));
                
                lista.add(editora);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Editora pesquisar(int idEditora){
        
        final String SQL = "SELECT * FROM Editora WHERE idEditora = ?";
        Editora editora = new Editora();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idEditora);
            ResultSet rs = ps.executeQuery();
            rs.next();
            editora.setIdEditora(rs.getInt("idEditora"));
            editora.setNome(rs.getString("nome"));
            editora.setEndereco_idEndereco(rs.getInt("Endereco_idEndereco"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return editora;
    }

    public void incluir(Editora editora){
        
        final String SQL = "INSERT INTO Editora (nome, Endereco_idEndereco) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, editora.getNome());
            ps.setInt(2, editora.getEndereco_idEndereco());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Editora editora){
        final String SQL = "UPDATE Editora SET nome = ?, Endereco_idEndereco = ? WHERE idEditora = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, editora.getNome());
            ps.setInt(2, editora.getEndereco_idEndereco());
            ps.setInt(3, editora.getIdEditora());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idEditora){
        
        final String SQL = "DELETE FROM Editora WHERE idEditora = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idEditora);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
