package mintic.edu.poo.modelo;

import java.io.Serializable;


public class Estudiante implements Serializable{
    
    private String nombres;
    private String apellidos;
    private String fNacimiento;
    private String correoInst;
    private String correoPers;
    private long celular;
    private long fijo;
    private String programa;

    public Estudiante(String nombres, String apellidos, String fNacimiento, String correoInst, String correoPers, long celular, long fijo, String programa) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fNacimiento = fNacimiento;
        this.correoInst = correoInst;
        this.correoPers = correoPers;
        this.celular = celular;
        this.fijo = fijo;
        this.programa = programa;
    }
    
        public Estudiante() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getCorreoInst() {
        return correoInst;
    }

    public void setCorreoInst(String correoInst) {
        this.correoInst = correoInst;
    }

    public String getCorreoPers() {
        return correoPers;
    }

    public void setCorreoPers(String correoPers) {
        this.correoPers = correoPers;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getFijo() {
        return fijo;
    }

    public void setFijo(long fijo) {
        this.fijo = fijo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "\nNombres: " + nombres 
             + "\nApellidos: " + apellidos 
             + "\nFecha nacimiento: " + fNacimiento 
             + "\nCorreo institucional: " + correoInst 
             + "\nCorreo personal: " + correoPers 
             + "\nNúmero de teléfono celular: " + celular 
             + "\nNúmero de teléfono fijo: " + fijo 
             + "\nPrograma académico: " + programa 
             ;
    }  
}