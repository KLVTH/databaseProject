package app;

import DAO.GerenteDAO;
import entity.Gerente;

public class appGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("28347", "vinicius", 18, "CEO");
        new GerenteDAO().cadastrarGerente(gerente);
    }
}
