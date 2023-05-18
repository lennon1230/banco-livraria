package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Estado;

public class EstadoDAO {
    
    private final Connection conexao;
    
    public EstadoDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Estado> listar(){

        final String SQL = "SELECT * FROM Estado";
        List<Estado> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                
                lista.add(estado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Estado pesquisar(int idEstado){
        
        final String SQL = "SELECT * FROM Estado WHERE idEstado = ?";
        Estado estado = new Estado();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idEstado);
            ResultSet rs = ps.executeQuery();
            rs.next();
            estado.setIdEstado(rs.getInt("idEstado"));
            estado.setNome(rs.getString("nome"));
            estado.setSigla(rs.getString("sigla"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public Estado pesquisarPorSigla(String sigla){
        
        final String SQL = "SELECT * FROM Estado WHERE sigla = ?";
        Estado estado = new Estado();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            rs.next();
            estado.setIdEstado(rs.getInt("idEstado"));
            estado.setNome(rs.getString("nome"));
            estado.setSigla(rs.getString("sigla"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public void incluir(Estado estado){
        
        final String SQL = "INSERT INTO Estado (nome, sigla) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, estado.getNome());
            ps.setString(2, estado.getSigla());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Estado estado){
        final String SQL = "UPDATE Estado SET nome = ?, sigla = ? WHERE idEstado = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, estado.getNome());
            ps.setString(2, estado.getSigla());
            ps.setInt(3, estado.getIdEstado());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idEstado){
        
        final String SQL = "DELETE FROM Estado WHERE idEstado = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idEstado);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
