package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}