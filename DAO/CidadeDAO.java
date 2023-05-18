package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cidade;

public class CidadeDAO {
    
    private final Connection conexao;
    
    public CidadeDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Cidade> listar(){

        final String SQL = "SELECT * FROM Cidade";
        List<Cidade> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstado_idEstado(rs.getInt("Estado_idEstado"));
                cidade.setIbge(rs.getInt("ibge"));
                
                lista.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Cidade> listarPorEstado(int Estado_idEstado){

        final String SQL = "SELECT * FROM Cidade WHERE Estado_idEstado = ?";
        List<Cidade> lista = new ArrayList<>();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, Estado_idEstado);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstado_idEstado(rs.getInt("Estado_idEstado"));
                cidade.setIbge(rs.getInt("ibge"));
                
                lista.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Cidade pesquisar(int idCidade){
        
        final String SQL = "SELECT * FROM Cidade WHERE idCidade = ?";
        Cidade cidade = new Cidade();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idCidade);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cidade.setIdCidade(rs.getInt("idCidade"));
            cidade.setNome(rs.getString("nome"));
            cidade.setEstado_idEstado(rs.getInt("Estado_idEstado"));
            cidade.setIbge(rs.getInt("ibge"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidade;
    }

    public Cidade pesquisarPorNome(String nome){
        
        final String SQL = "SELECT * FROM Cidade WHERE nome = ?";
        Cidade cidade = new Cidade();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cidade.setIdCidade(rs.getInt("idCidade"));
            cidade.setNome(rs.getString("nome"));
            cidade.setEstado_idEstado(rs.getInt("Estado_idEstado"));
            cidade.setIbge(rs.getInt("ibge"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidade;
    }

    public void incluir(Cidade cidade){
        
        final String SQL = "INSERT INTO Cidade (nome, Estado_idEstado, ibge) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cidade.getNome());
            ps.setInt(2, cidade.getEstado_idEstado());
            ps.setInt(3, cidade.getIbge());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cidade cidade){
        final String SQL = "UPDATE Cidade SET nome = ?, Estado_idEstado = ?, ibge = ? WHERE idCidade = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cidade.getNome());
            ps.setInt(2, cidade.getEstado_idEstado());
            ps.setInt(3, cidade.getIbge());
            ps.setInt(4, cidade.getIdCidade());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idCidade){
        
        final String SQL = "DELETE FROM Cidade WHERE idCidade = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idCidade);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
