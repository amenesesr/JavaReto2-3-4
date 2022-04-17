package mintic.edu.poo.vista;

import java.util.Scanner;

public class VistaConsola {
    
    private Scanner leer;
    
    public VistaConsola(){
        leer = new Scanner(System.in);
    }
    
    public String leerDatosString (String mensaje){
        System.out.println(mensaje);
        String dato = leer.nextLine();
        String dato2 = dato.toLowerCase();
        return dato2;
    }
     
    public long leerDatoLong(String mensaje){
        long dato = 0;
        try{
            System.out.println(mensaje);
            dato = leer.nextLong();
            leer.nextLine();
        }catch(Exception e){
            leer.nextLine();
            dato = 0;
        }
        return dato;
    }
    
    public double leerDatoDouble(String mensaje){
        double dato = 0;
        try{
            System.out.println(mensaje);
            dato = leer.nextDouble();
            leer.nextLine();
        }catch(Exception e){
            leer.nextLine();
            dato = 0;
        }
        return dato;
    }
    
    public int leerDatoEntero(String mensaje){
        int dato = 0;
        try{
            System.out.println(mensaje);
            dato = leer.nextInt();
            leer.nextLine();
        }catch(Exception e){
            leer.nextLine();
            dato = 0;
        }
        return dato;
    }
    
    public void mostrarInformacion(String mensaje){
            System.out.println(mensaje); 
    }
            
}
