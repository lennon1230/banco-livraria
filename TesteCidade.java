import java.util.List;

import javax.swing.JOptionPane;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
import Model.Cidade;
import Model.Estado;

public class TesteCidade {
    
    public static void main(String[] args) {
        
        //pesquisar();
        //incluir();
        //atualizar();
        //deletar();
        //listar();
        teste();
    }

    public static void teste() {
        EstadoDAO eDAO = new EstadoDAO();
        List<Estado> listaEstado = eDAO.listar();
        String estado[] = new String[listaEstado.size()];
        int i = 0;
        for(Estado est : listaEstado){
            estado[i] = est.getSigla();
            i++;
        }

        String selectedValue = String.valueOf(JOptionPane.showInputDialog(null,
             "Escolha uma opção", "Título",
             JOptionPane.PLAIN_MESSAGE, null,
             estado, estado[0]));
        
        System.out.println(selectedValue);

        
    }

    public static void incluir2(){
        CidadeDAO cDAO = new CidadeDAO();
        Cidade cidade = new Cidade("Cidade do Leste", 1, 1);
        cDAO.incluir(cidade);

        System.out.println("Registro criado com sucesso!");

    }

    public static void pesquisar(){
        CidadeDAO cDAO = new CidadeDAO();
        Cidade cidade = cDAO.pesquisar(Integer.parseInt(JOptionPane.showInputDialog("Digita o ID para pesquisa: ")));

        JOptionPane.showMessageDialog(null, "ID: " + cidade.getIdCidade() + 
                            "\nNome: " + cidade.getNome() + 
                            "\nID Estado: " + cidade.getEstado_idEstado() +
                            "\nIBGE: " + cidade.getIbge());

    }

    public static void incluir(){
        CidadeDAO cDAO = new CidadeDAO();
        Cidade cidade = new Cidade("Cidade do Leste", 1, 1);
        cDAO.incluir(cidade);

        System.out.println("Registro criado com sucesso!");

    }

    public static void atualizar(){
        CidadeDAO cDAO = new CidadeDAO();
        Cidade cidade = cDAO.pesquisar(5611);

        if(cidade.getNome() != null){
            cidade.setNome("Cidade Macabra");
            cidade.setEstado_idEstado(15);
            cidade.setIbge(268426);
            cDAO.atualizar(cidade);
        }

        System.out.println("Feito a alteração do registro!");

    }

    public static void deletar(){
        CidadeDAO cDAO = new CidadeDAO();
        cDAO.deletar(5611);;

        System.out.println("Feito a exclusão do registro!");

    }

    public static void listar(){
        CidadeDAO cDAO = new CidadeDAO();
        List<Cidade> lista = cDAO.listar();

        for (Cidade cidade : lista) {
            System.out.println("ID: " + cidade.getIdCidade() + 
                            "\nNome: " + cidade.getNome() + 
                            "\nID Estado: " + cidade.getEstado_idEstado() +
                            "\nIBGE: " + cidade.getIbge() + "\n");
            if(cidade.getIdCidade() == 10){
                break;
            }
        }

    }
}
