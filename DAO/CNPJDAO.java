package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CNPJ;

public class CNPJDAO {
    
    private final Connection conexao;
    
    public CNPJDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<CNPJ> listar(){

        final String SQL = "SELECT * FROM CNPJ";
        List<CNPJ> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                CNPJ cnpj = new CNPJ();
                cnpj.setCNPJ(rs.getString("cnpj"));
                cnpj.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
                
                lista.add(cnpj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public CNPJ pesquisar(String numero){
        
        final String SQL = "SELECT * FROM CNPJ WHERE cnpj = ?";
        CNPJ cnpj = new CNPJ();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cnpj.setCNPJ(rs.getString("cnpj"));
            cnpj.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnpj;
    }

    public void incluir(CNPJ cnpj){
        
        final String SQL = "INSERT INTO CNPJ (cnpj, Cliente_idCliente) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cnpj.getCNPJ());
            ps.setInt(2, cnpj.getCliente_idCliente());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(CNPJ cnpj){
        final String SQL = "UPDATE CNPJ SET cnpj = ?, Cliente_idCliente = ? WHERE CNPJ = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cnpj.getCNPJ());
            ps.setInt(2, cnpj.getCliente_idCliente());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(String cnpj){
        
        final String SQL = "DELETE FROM CNPJ WHERE cnpj = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, cnpj);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
