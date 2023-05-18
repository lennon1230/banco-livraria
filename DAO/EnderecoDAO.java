package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Endereco;

public class EnderecoDAO {
    
    private final Connection conexao;

    public EnderecoDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Endereco> listar(){
        final String SQL = "SELECT * FROM Endereco";
        List<Endereco> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                Endereco endereco = new Endereco();
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setEndereco(rs.getString("endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setCep(rs.getString("cep"));
                endereco.setCidade_idCidade(rs.getInt("Cidade_idCidade"));

                lista.add(endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Endereco pesquisar(int idEndereco){
        final String SQL = "SELECT * FROM Endereco WHERE idEndereco = ?";
        Endereco endereco = new Endereco();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idEndereco);
            ResultSet rs = ps.executeQuery();
            rs.next();
            endereco.setIdEndereco(rs.getInt("idEndereco"));
            endereco.setEndereco(rs.getString("endereco"));
            endereco.setRua(rs.getString("rua"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setCep(rs.getString("cep"));
            endereco.setCidade_idCidade(rs.getInt("Cidade_idCidade"));
            
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    public void incluir(Endereco endereco){
        final String SQL = "INSERT INTO Endereco (endereco, rua, bairro, numero, cep, Cidade_idCidade) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, endereco.getEndereco());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getCep());
            ps.setInt(6, endereco.getCidade_idCidade());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Endereco endereco){

        final String SQL = "UPDATE Endereco SET endereco = ?, rua = ?, bairro = ?, numero = ?, cep = ?, Cidade_idCidade = ? WHERE idEndereco = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, endereco.getEndereco());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getCep());
            ps.setInt(6, endereco.getCidade_idCidade());
            ps.setInt(7, endereco.getIdEndereco());
            ps.execute();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int idEndereco){

        final String SQL = "DELETE FROM Endereco WHERE idEndereco = ?";

        try {
            PreparedStatement ps = this.conexao.prepareStatement(SQL);
            ps.setInt(1, idEndereco);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int ultimoID(){
        
        final String SQL = "SELECT max(idEndereco) AS idEndereco FROM Endereco";

        try {
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery(SQL);
            if(rs.next())
                return rs.getInt("idEndereco");

            ps.close();
            rs.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
