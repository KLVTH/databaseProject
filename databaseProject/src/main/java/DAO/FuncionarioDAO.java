/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
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
    
    public static void listarFuncionarios() {
        try {
            /*Cria um objeto Statement a partir do método "Conexao.getConexao", este objeto Statement não possui atributos porém tem vários métodos para executar instruções sql: https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html */
            Statement stmt = Conexao.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM funcionario");

            while (rs.next()) {
                String coluna1 = rs.getString("idFuncionario");
                String coluna2 = rs.getString("matricula");
                String coluna3 = rs.getString("nome");
                String coluna4 = String.valueOf(rs.getString("idade"));
                System.out.println(
                        "ID: " + coluna1 + ", matricula: " + coluna2 + " nome: " + coluna3 + " idade: " + coluna4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void removerFuncionario(String maneira, String variavel) {
        String sql = "";
        if (maneira.equals("id")) {
            sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
        } else if(maneira.equals("matricula")) {
            sql = "DELETE FROM funcionario WHERE matricula = ?";
        } else if (maneira.equals("nome")) {
            sql = "DELETE FROM funcionario WHERE nome = ?";
        }

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            
            ps.setString(1, variavel);
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


