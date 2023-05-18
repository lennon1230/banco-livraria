package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Pedido;

public class PedidoDAO {
    
    private Connection conexao;

    public PedidoDAO (){
        this.conexao = FabricaConexao.getConexao();
    }

    public List<Pedido> listar(){
        final String SQL = "SELECT * FROM Pedido";
        List<Pedido> lista = new ArrayList<>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setData_pedido(rs.getString("data_pedido"));
                pedido.setEditora_idEditora(rs.getInt("Editora_idEditora"));
                pedido.setCliente_idCliente(rs.getInt("Cliente_idCliente"));

                lista.add(pedido);
            }
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Pedido pesquisar(int idPedido){
        final String SQL = "SELECT * FROM Pedido WHERE idPedido = ?";
        Pedido pedido = new Pedido();

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pedido.setIdPedido(idPedido);
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setData_pedido(rs.getString("data_pedido"));
                pedido.setEditora_idEditora(rs.getInt("Editora_idEditora"));
                pedido.setCliente_idCliente(rs.getInt("Cliente_idCliente"));
            }else{
                return null;
            }

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    public void incluir(Pedido pedido){
        final String SQL = "INSERT INTO Pedido (quantidade, valor, data_pedido, Editora_idEditora, Cliente_idCliente) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, pedido.getQuantidade());
            ps.setDouble(2, pedido.getValor());
            ps.setString(3, pedido.getData_pedido());
            ps.setInt(4, pedido.getEditora_idEditora());
            ps.setInt(5, pedido.getCliente_idCliente());
            ps.execute();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Pedido pedido){
        final String SQL = "UPDATE Pedido SET quantidade = ?, valor = ?, data_pedido = ?, Editora_idEditora = ?, Cliente_idCliente = ? WHERE idPedido = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, pedido.getQuantidade());
            ps.setDouble(2, pedido.getValor());
            ps.setString(3, pedido.getData_pedido());
            ps.setInt(4, pedido.getEditora_idEditora());
            ps.setInt(5, pedido.getCliente_idCliente());
            ps.setInt(6, pedido.getIdPedido());
            ps.execute();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int idPedido){
        final String SQL = "DELETE FROM Pedido WHERE idPedido = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setInt(1, idPedido);
            ps.executeQuery();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
