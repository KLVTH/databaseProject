/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conection.Conexao;
import entity.Funcionario;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionario(matricula, nome, idade) VALUES(?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, funcionario.getMatricula());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, String.valueOf(funcionario.getIdade()));
            
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }
}
