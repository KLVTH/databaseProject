/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        funcionario.setMatricula("021638");
        funcionario.setNome("Thiago");
        funcionario.setIdade(20);
        
        new FuncionarioDAO().cadastrarFuncionario(funcionario);
        
    }
}
