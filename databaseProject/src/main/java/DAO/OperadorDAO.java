package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
