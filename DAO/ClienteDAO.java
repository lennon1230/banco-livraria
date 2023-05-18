package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ClienteDAO {
    
    private final Connection conexao;
    
    public ClienteDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Cliente> listar(){

        final String SQL = "SELECT * FROM Cliente";
        List<Cliente> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone_idTelefone(rs.getInt("Telefone_idTelefone"));
                cliente.setEndereco_idEndereco(rs.getInt("Endereco_idEndereco"));
                
                lista.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cliente pesquisar(int idCliente){
        
        final String SQL = "SELECT * FROM Cliente WHERE idCliente = ?";
        Cliente cliente = new Cliente();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone_idTelefone(rs.getInt("Telefone_idTelefone"));
                cliente.setEndereco_idEndereco(rs.getInt("Endereco_idEndereco"));
            }else{
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public Cliente pesquisarPorEmail(String email){
        
        final String SQL = "SELECT * FROM Cliente WHERE email = ?";
        Cliente cliente = new Cliente();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone_idTelefone(rs.getInt("Telefone_idTelefone"));
                cliente.setEndereco_idEndereco(rs.getInt("Endereco_idEndereco"));
            }else{
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void incluir(Cliente cliente){
        
        final String SQL = "INSERT INTO Cliente (nome, email, Telefone_idTelefone, Endereco_idEndereco) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getTelefone_idTelefone());
            ps.setInt(4, cliente.getEndereco_idEndereco());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cliente cliente){
        final String SQL = "UPDATE Cliente SET nome = ?, email = ?, Telefone_idTelefone = ?, Endereco_idEndereco = ? WHERE idCliente = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getTelefone_idTelefone());
            ps.setInt(4, cliente.getEndereco_idEndereco());
            ps.setInt(5, cliente.getIdCliente());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(int idCliente){
        
        final String SQL = "DELETE FROM Cliente WHERE idCliente = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idCliente);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int ultimoID(){
        
        final String SQL = "SELECT max(idCliente) AS idCliente FROM Cliente";

        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery(SQL);
            if(rs.next())
                return rs.getInt("idCliente");

            ps.close();
            rs.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
