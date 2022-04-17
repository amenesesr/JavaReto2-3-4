package mintic.edu.poo.persistencia;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mintic.edu.poo.modelo.Conexion;
import mintic.edu.poo.modelo.Estudiante;

public class EstudianteDAO extends Conexion{
    
    public String verEstudiantes() {
        PreparedStatement ps = null;    
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM Estudiantes", PRINT = "";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {     
                PRINT += "\nNombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getString("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getString("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n";
            }
         } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
        return PRINT;
    }
        
    public Estudiante buscarEstudiante (String correo){
        Estudiante est = new Estudiante();
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        Connection con = getConexion();
        String sql = "SELECT * FROM Estudiantes WHERE Co_inst=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if(rs.next()){
                est.setNombres(rs.getString("Nombres"));
                est.setApellidos(rs.getString("Apellidos"));
                est.setFNacimiento(rs.getString("Nacimiento"));
                est.setCorreoInst(rs.getString("Co_inst"));
                est.setCorreoPers(rs.getString("Co_per"));
                est.setCelular(Long.parseLong(rs.getString("Num_cel")));
                est.setFijo(Long.parseLong(rs.getString("Num_fijo")));
                est.setPrograma(rs.getString("programa"));
            }
 
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return est;
    }
    
    public boolean agregarEstudiante(String nombres, String apellidos, String fNacimiento, String correoInst, String correoPers, 
            long celular, long fijo, String programa) {
        Estudiante est = new Estudiante(nombres, apellidos, fNacimiento, correoInst, correoPers, celular, fijo, programa);
        PreparedStatement ps = null; 
        Connection con = getConexion();
        String sql = "INSERT INTO Estudiantes (Nombres, Apellidos, Nacimiento, Co_inst, Co_Per, Num_cel, Num_fijo, programa)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getNombres());
            ps.setString(2, est.getApellidos());
            ps.setString(3, est.getFNacimiento());
            ps.setString(4, est.getCorreoInst());
            ps.setString(5, est.getCorreoPers());
            ps.setLong(6, est.getCelular());
            ps.setLong(7, est.getFijo());
            ps.setString(8, est.getPrograma());
            ps.execute();
            return true;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    }
    
    public boolean eliminarEstudiante(String correoInst) {
        PreparedStatement ps = null; 
        Connection con = getConexion();
        String sql = "DELETE FROM Estudiantes WHERE Co_inst=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, correoInst);
            ps.execute();
            return true;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }   
    } 
    
    public boolean modificar(String correoInst, String correoPers, long celular, long fijo, String programa){
        PreparedStatement ps = null; 
        Connection con = getConexion();
        String sql = "UPDATE Estudiantes SET Co_per=?, Num_cel=?, Num_fijo=?, programa=? WHERE Co_inst=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, correoPers);
            ps.setLong(2, celular);
            ps.setLong(3, fijo);
            ps.setString(4, programa);
            ps.setString(5, correoInst);
            ps.execute();
            return true;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }  
    }
     
     public String buscarEstudianteApellido (String apellidos){
        String PRINT = "";
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        Connection con = getConexion();
        String sql = "SELECT * FROM Estudiantes WHERE Apellidos=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, apellidos);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += "\nNombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getString("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getString("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n";
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
     
    public String buscarEstudiantePrograma(String programa){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        Connection con = getConexion();
        String sql = "SELECT * FROM Estudiantes WHERE Programa=?";
     
        String PRINT = "";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, programa);
            rs = ps.executeQuery();
            while (rs.next()) {     
                PRINT += "\n" + rs.getString("Nombres") + " " + rs.getString("Apellidos");
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
    public String buscarEstudianteNacimiento(String fNacimiento){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        Connection con = getConexion();
        String sql = "SELECT * FROM Estudiantes WHERE Nacimiento=?";
        String PRINT = "";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, fNacimiento);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += "\nNombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getString("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getString("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n";
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
    public String buscarEstudianteCelular(long celular){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        Connection con = getConexion();
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Num_cel=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setLong(1, celular);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += "\n" + rs.getString("Nombres") + " " + rs.getString("Apellidos") + rs.getString("programa") + "\n";
            }
 
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }  
    
    public String calcularPrograma(String programa){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        Connection con = getConexion();
        String PRINT = "";
        String sql = "SELECT count (*) as cantidad FROM Estudiantes WHERE Programa=?";
         try{
            ps = con.prepareStatement(sql);
            ps.setString(1, programa);
            rs = ps.executeQuery();
            rs.next();
            PRINT = rs.getString("cantidad");
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
        return PRINT;
    }
}
