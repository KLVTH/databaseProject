package com.klvth.databaseproject;


import java.sql.*;
import conection.Conexao;


/**
 *
 * @author Aluno
 */
public class DatabaseProject {
    public static void main(String[] args) {
        String id = "4";
        String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            
            ps.setString(1, id);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Funcionário removido com sucesso.");
            } else {
                System.out.println("Nenhum funcionário encontrado com o ID fornecido.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
