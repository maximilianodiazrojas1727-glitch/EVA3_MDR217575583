package db;

public class TestConexion {
    public static void main(String[] args) {
        if (Conexion.getConexion() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error de conexion");
        }
    }
}
