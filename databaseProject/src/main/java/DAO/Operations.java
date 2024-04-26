package DAO;

import java.sql.*;
import conection.Conexao;
import entity.*;

/**
 *
 * @author Aluno
 */
public class Operations {
    public static void cadastrarFuncionario(Funcionario funcionario){
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
                String coluna1 = rs.getString("id");
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
            sql = "DELETE FROM funcionario WHERE id = ?";
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

    public static void cadastrarGerente(Gerente gerente){
        String sql = "INSERT INTO gerente(matricula, nome, idade, departamento) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, gerente.getMatricula());
            ps.setString(2, gerente.getNome());
            ps.setString(3, String.valueOf(gerente.getIdade()));
            ps.setString(4, gerente.getDepartamento());
            
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }
    
    public static void listarGerentes() {
        try {
            /*Cria um objeto Statement a partir do método "Conexao.getConexao", este objeto Statement não possui atributos porém tem vários métodos para executar instruções sql: https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html */
            Statement stmt = Conexao.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gerente");

            while (rs.next()) {
                String coluna1 = rs.getString("idGerente");
                String coluna2 = rs.getString("matricula");
                String coluna3 = rs.getString("nome");
                String coluna4 = String.valueOf(rs.getString("idade"));
                String coluna5 = rs.getString("departamento");
                System.out.println(
                        "ID: " + coluna1 + ", matricula: " + coluna2 + " nome: " + coluna3 + " idade: " + coluna4 + " departamento: " + coluna5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void removerGerentes(String maneira, String variavel) {
        String sql = "";
        if (maneira.equals("id")) {
            sql = "DELETE FROM gerente WHERE idGerente = ?";
        } else if(maneira.equals("matricula")) {
            sql = "DELETE FROM gerente WHERE matricula = ?";
        } else if (maneira.equals("nome")) {
            sql = "DELETE FROM gerente WHERE nome = ?";
        } else if(maneira.equals("departamento")){
            sql = "DELETE FROM gerente WHERE departamento = ?";
        }

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            
            ps.setString(1, variavel);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Gerente removido com sucesso.");
            } else {
                System.out.println("Nenhum gerente encontrado com o ID fornecido.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarOperador(Operador operador){
        String sql = "INSERT INTO operador(matricula, nome, idade, funcao) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, operador.getMatricula());
            ps.setString(2, operador.getNome());
            ps.setString(3, String.valueOf(operador.getIdade()));
            ps.setString(4, operador.getFuncao());
            
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }
    
    public static void listarOperador() {
        try {
            /*Cria um objeto Statement a partir do método "Conexao.getConexao", este objeto Statement não possui atributos porém tem vários métodos para executar instruções sql: https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html */
            Statement stmt = Conexao.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM operador");

            while (rs.next()) {
                String coluna1 = rs.getString("idOperador");
                String coluna2 = rs.getString("matricula");
                String coluna3 = rs.getString("nome");
                String coluna4 = String.valueOf(rs.getString("idade"));
                String coluna5 = rs.getString("funcao");
                System.out.println(
                        "ID: " + coluna1 + ", matricula: " + coluna2 + " nome: " + coluna3 + " idade: " + coluna4 + " função: " + coluna5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void removerOperador(String maneira, String variavel) {
        String sql = "";
        if (maneira.equals("id")) {
            sql = "DELETE FROM operador WHERE idOperador = ?";
        } else if(maneira.equals("matricula")) {
            sql = "DELETE FROM operador WHERE matricula = ?";
        } else if (maneira.equals("nome")) {
            sql = "DELETE FROM operador WHERE nome = ?";
        } else if(maneira.equals("funcao")){
            sql = "DELETE FROM operador WHERE funcao = ?";
        }

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            
            ps.setString(1, variavel);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Operador removido com sucesso.");
            } else {
                System.out.println("Nenhum operador encontrado com o ID fornecido.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
    

