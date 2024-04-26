package DAO;


import java.sql.*;
import conection.Conexao;
import entity.Gerente;

public class GerenteDAO {
    public void cadastrarGerente(Gerente gerente){
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
}