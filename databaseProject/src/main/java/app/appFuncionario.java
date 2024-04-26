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
public class appFuncionario {
    public static void main(String[] args) throws Exception {
        
        Funcionario funcionario = new Funcionario("04348", "Kaua", 19);
        new FuncionarioDAO().cadastrarFuncionario(funcionario);
        
    }
}
