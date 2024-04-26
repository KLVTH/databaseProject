package app;

import DAO.Operations;
import entity.*;

/**
 *
 * @author Aluno
 */
public class App {
    public static void main(String[] args) throws Exception {

        //Operations.cadastrarFuncionario(new Funcionario("04348", "Kaua", 19));
        
        Operations.listarFuncionarios(); 

        Operations.removerFuncionario("id","7");

        /*! retorna uma exceção por que a tabela não foi criada
        Operations.cadastrarGerente(new Gerente("04348", "Kaua", 19, "TI"));
        */
    }
}
