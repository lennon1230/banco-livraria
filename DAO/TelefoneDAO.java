package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Telefone;

public class TelefoneDAO {
    
    private final Connection conexao;
    
    public TelefoneDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Telefone> listar(){

        final String SQL = "SELECT * FROM Telefone";
        List<Telefone> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setIdTelefone(rs.getInt("idTelefone"));
                telefone.setTelefone1(rs.getString("telefone1"));
                telefone.setTelefone2(rs.getString("telefone2"));
                
                lista.add(telefone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Telefone pesquisar(int idTelefone){
        
        final String SQL = "SELECT * FROM Telefone WHERE idTelefone = ?";
        Telefone telefone = new Telefone();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idTelefone);
            ResultSet rs = ps.executeQuery();
            rs.next();
            telefone.setIdTelefone(rs.getInt("idTelefone"));
            telefone.setTelefone1(rs.getString("telefone1"));
            telefone.setTelefone2(rs.getString("telefone2"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return telefone;
    }

    public void incluir(Telefone telefone){
        
        final String SQL = "INSERT INTO Telefone (telefone1, telefone2) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, telefone.getTelefone1());
            ps.setString(2, telefone.getTelefone2());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Telefone telefone){
        final String SQL = "UPDATE Telefone SET telefone1 = ?, telefone2 = ? WHERE idTelefone = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, telefone.getTelefone1());
            ps.setString(2, telefone.getTelefone2());
            ps.setInt(3, telefone.getIdTelefone());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idTelefone){
        
        final String SQL = "DELETE FROM Telefone WHERE idTelefone = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idTelefone);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int ultimoID(){
        
        final String SQL = "SELECT max(idTelefone) AS idTelefone FROM Telefone";

        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery(SQL);
            if(rs.next())
                return rs.getInt("idTelefone");

            ps.close();
            rs.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
