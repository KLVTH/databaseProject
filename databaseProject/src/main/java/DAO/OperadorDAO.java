package DAO;

import java.sql.*;
import conection.Conexao;
import entity.Operador;

public class OperadorDAO {
    public void cadastrarOperador(Operador operador){
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
