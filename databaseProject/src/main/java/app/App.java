package app;

import DAO.FuncionarioDAO;
import entity.Funcionario;

/**
 *
 * @author Aluno
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula("312312141");
        funcionario.setNome("Thiago");
        funcionario.setIdade(20);
        
        FuncionarioDAO.cadastrarFuncionario(funcionario);
    

        /* Método para listar os funcionários 
        FuncionarioDAO.listarFuncionarios(); */

        FuncionarioDAO.removerFuncionario("id","5");
    }
}
