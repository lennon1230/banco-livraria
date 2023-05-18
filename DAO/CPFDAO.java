package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CPF;

public class CPFDAO {
    private final Connection conexao;
    
    public CPFDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<CPF> listar(){

        final String SQL = "SELECT * FROM CPF";
        List<CPF> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                CPF cpf = new CPF();
                cpf.setCPF(rs.getString("cpf"));
                cpf.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
                
                lista.add(cpf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public CPF pesquisar(String numero){
        
        final String SQL = "SELECT * FROM CPF WHERE cpf = ?";
        CPF cpf = new CPF();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cpf.setCPF(rs.getString("cpf"));
            cpf.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpf;
    }

    public void incluir(CPF cpf){
        
        final String SQL = "INSERT INTO CPF (cpf, Cliente_idCliente) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cpf.getCPF());
            ps.setInt(2, cpf.getCliente_idCliente());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(CPF cpf){
        final String SQL = "UPDATE CPF SET cpf = ?, Cliente_idCliente = ? WHERE cpf = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cpf.getCPF());
            ps.setInt(2, cpf.getCliente_idCliente());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(String cpf){
        
        final String SQL = "DELETE FROM CPF WHERE cpf = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cpf);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
