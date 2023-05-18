package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Pedido_has_Livro;

public class Pedido_has_LivroDAO {
    
    private final Connection conexao;
    
    public Pedido_has_LivroDAO(){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Pedido_has_Livro> listar(){

        final String SQL = "SELECT * FROM Pedido_has_Livro";
        List<Pedido_has_Livro> lista = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                Pedido_has_Livro pl = new Pedido_has_Livro();
                pl.setPedido_idPedido(rs.getInt("Pedido_idPedido"));
                pl.setLivro_idLivro(rs.getInt("Livro_idLivro"));
                
                lista.add(pl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Pedido_has_Livro pesquisar(int Pedido_idPedido, int Livro_idLivro){
        
        final String SQL = "SELECT * FROM Pedido_has_Livro WHERE Pedido_idPedido = ? and Livro_idLivro = ?";
        Pedido_has_Livro pl = new Pedido_has_Livro();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, Pedido_idPedido);
            ps.setInt(2, Livro_idLivro);
            ResultSet rs = ps.executeQuery();
            rs.next();
            pl.setPedido_idPedido(rs.getInt("Pedido_idPedido"));
            pl.setLivro_idLivro(rs.getInt("Livro_idLivro"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pl;
    }

    public void incluir(Pedido_has_Livro pl){
        
        final String SQL = "INSERT INTO Pedido_has_Livro (Pedido_idPedido, Livro_idLivro) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, pl.getPedido_idPedido());
            ps.setInt(2, pl.getLivro_idLivro());
            ps.execute();
            
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Pedido_has_Livro pl, int idPedido, int idLivro){
        final String SQL = "UPDATE Pedido_has_Livro SET Pedido_idPedido = ?, Livro_idLivro = ? WHERE Pedido_idPedido = ?, Livro_idLivro = ?";

        try{
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idPedido);
            ps.setInt(2, idLivro);
            ps.setInt(3, pl.getPedido_idPedido());
            ps.setInt(4, pl.getLivro_idLivro());
            ps.execute();

            ps.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deletar(Pedido_has_Livro pl){
        
        final String SQL = "DELETE FROM Pedido_has_Livro WHERE Pedido_idPedido = ? AND Livro_idLivro = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, pl.getPedido_idPedido());
            ps.setInt(2, pl.getLivro_idLivro());
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
