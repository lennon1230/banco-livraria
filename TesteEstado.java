import java.util.List;

import DAO.EstadoDAO;
import Model.Estado;

public class TesteEstado {
    
    public static void main(String[] args) {
        
        pesquisar();
        //incluir();
        //atualizar();
        //deletar();
        //listar();
    }

    public static void pesquisar(){
        EstadoDAO eDAO = new EstadoDAO();
        Estado estado = eDAO.pesquisar(25);

        System.out.println("ID: " + estado.getIdEstado() + "\nNome: " + estado.getNome() + "\nSigla: " + estado.getSigla());

    }

    public static void incluir(){
        EstadoDAO eDAO = new EstadoDAO();
        Estado estado = new Estado("Estado do Leste", "EL");
        eDAO.incluir(estado);

        System.out.println("Registro criado com sucesso!");

    }

    public static void atualizar(){
        EstadoDAO eDAO = new EstadoDAO();
        Estado estado = eDAO.pesquisar(28);

        if(estado.getSigla() != null){
            
            estado.setNome("Estado do Oeste");
            estado.setSigla("EO");
            eDAO.atualizar(estado);
        }

        System.out.println("Feito a alteração do registro!");

    }

    public static void deletar(){
        EstadoDAO eDAO = new EstadoDAO();
        eDAO.deletar(28);;

        System.out.println("Feito a exclusão do registro!");

    }

    public static void listar(){
        EstadoDAO eDAO = new EstadoDAO();
        List<Estado> lista = eDAO.listar();

        for (Estado estado : lista) {
            System.out.println("ID: " + estado.getIdEstado() + "\nNome: " + estado.getNome() + 
                                "\nSigla: " + estado.getSigla() + "\n");
            
        }

    }
}
