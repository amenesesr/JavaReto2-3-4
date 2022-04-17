package mintic.edu.poo.modelo;

import java.sql.Connection ;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager ;
import java.sql.SQLException;

public class Conexion {
    
    private final String url = "jdbc:sqlite:D:/Documents/NetBeansProjects/bd_estudiantes.db";
    private Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            con = (Connection)DriverManager.getConnection(this.url);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}
