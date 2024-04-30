package app;

import DAO.Operations;
import entity.*;

/**
 *
 * @author Aluno
 */
public class App {
    public static void main(String[] args) throws Exception {

        // Operations.removerFuncionario("id","11");

        // Operations.cadastrarFuncionario(new Funcionario("043", "Kaua", 19));

        // Operations.cadastrarGerente(new Gerente("312", "Wesley", 24, "TI"));

        //Operations.listarGerentes();
        //Operations.cadastrarGerente(new Gerente("231", "Kaua", 19, "TI"));
        Operations.listarGerentes();
        Operations.listarOperador();
        
    }
}
