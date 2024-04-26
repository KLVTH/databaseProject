package app;

import DAO.OperadorDAO;
import entity.Operador;

public class appOperador {
    public static void main(String[] args) {
        Operador operador = new Operador("877373", "levi", 21, "peao");
        new OperadorDAO().cadastrarOperador(operador);
    }
}