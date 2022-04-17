package mintic.edu.poo.controlador;

import mintic.edu.poo.modelo.Estudiante;
import mintic.edu.poo.modelo.EstudianteDTO;
import mintic.edu.poo.vista.VistaConsola;

/**
 *
 * @author Alejandro
 */
public class Controller {
    
    private VistaConsola vista;
    private EstudianteDTO dto;
    
    public Controller() {
        vista = new VistaConsola();
        dto = new EstudianteDTO();
        menuPrincipal();
    }
    
    private void menuPrincipal() {
        int opcion = 0;
        String menu = "INSTITUTO LA FLORESTA"+ "\n" +
                      "Seleccione tarea a realizar: " + "\n" +
                      "1. Ingresar estudiante" + "\n"+
                      "2. Consultas" + "\n"+
                      "3. Modificar estudiante" + "\n"+
                      "4. Eliminar Estudiante" + "\n"+
                      "5. Ver directorio de estudiantes" + "\n"+
                      "6. Salir" + "\n"+
                      "Opción:";
        /*String menu = "INSTITUTO LA FLORESTA"+ "\n" +
                      "Seleccione tarea a realizar: " + "\n" +
                      "1. Ingresar estudiante" + "\n"+
                      "2. Buscar" + "\n"+
                      "3. Modificar estudiante" + "\n"+
                      "4. Eliminar Estudiante" + "\n"+
                      "5. Ver directorio de estudiantes" + "\n"+
                      "6. Salir" + "\n"+
                      "Opción:";*/
        do{
            opcion = vista.leerDatoEntero(menu);
            switch(opcion){
                case 1:
                    ingresarEstudiante();
                    break;
                case 2:
                    //buscarEstudiante();
                    consultas();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    mostrarDirectorio();
                    break;
                case 6:
                    vista.mostrarInformacion("\nHasta pronto");
                    break;
                default:
                    vista.mostrarInformacion("\nError opcion no valida");
                    break;                  
            } 
        }while(opcion!=6);
    }
    
    public void consultas(){
     int opcion = 0;
        String submenu = "Consultas"+ "\n" +
                      "Seleccione consulta a realizar: " + "\n" +
                      "1. Buscar estudiante por correo electrónico" + "\n"+
                      "2. Buscar estudiante por apellidos" + "\n"+
                      "3. Bucar por programa" + "\n"+
                      "4. Buscar cantidad de estudiantes por programa" + "\n"+
                      "5. Buscar por fecha de nacimiento" + "\n"+
                      "6. Buscar por número de celular" + "\n"+
                      "Opción:";
            opcion = vista.leerDatoEntero(submenu);
            switch(opcion){
                case 1:
                    buscarEstudiante();
                    break;
                case 2:
                    buscarEstudianteApellido();
                    break;
                case 3:
                    buscarEstudiantePrograma();
                    break;
                case 4:
                    cantidadEstudiantes();
                    break;
                case 5:
                    buscarEstudianteNacimiento();
                    break;
                case 6:
                    buscarEstudianteCelular();
                    break;
                default:
                    vista.mostrarInformacion("\nError opcion no valida");
                    break;                  
            }  
    }
    
    public void ingresarEstudiante(){
        String nombre = "", apellido = "", fNacimiento = "", correoInst = "", correoPers = "", programa = "";
        long fijo = 0, celular = 0;
        vista.mostrarInformacion("\nIngresar estudiante");
        nombre = vista.leerDatosString("Ingresar nombres: ");
        apellido = vista.leerDatosString("\nIngresar apellidos: ");
        fNacimiento = vista.leerDatosString("\nIngresar fecha de nacimiento (YYYY-MM-DD):");
        correoInst = vista.leerDatosString("\nIngresar correo institucional: ");
        correoPers = vista.leerDatosString("\nIngresar correo personal: ");
        celular = vista.leerDatoLong("\nIngresar número de celular: ");
        fijo = vista.leerDatoLong("\nIngresar número fijo: ");
        programa = vista.leerDatosString("\nIngresar programa: ");
        
        if (dto.getEstudianteDAO().agregarEstudiante(nombre, apellido, fNacimiento, correoInst,
                correoPers, celular, fijo, programa))
        {
            vista.mostrarInformacion("\nSe agregó el estudiante\n");
        }
        else
        {
            vista.mostrarInformacion("No fue posible agregar el estudiante\n");
        }
    }
    
    public void buscarEstudiante(){
        String correoInst = "";
        vista.mostrarInformacion("\nBuscar estudiante");
        correoInst = vista.leerDatosString("Ingresar correo institucional: ");
        Estudiante est = dto.getEstudianteDAO().buscarEstudiante(correoInst);
        if(est.getCorreoInst() != null)
        {
            vista.mostrarInformacion(est.toString()+"\n");
        }
        else
        {
            vista.mostrarInformacion("\nEl estudiante no se encuentra registrado en el instituto\n");
        }    
    }
    
    public void modificarEstudiante() {
        String nombre = "", apellido = "", fNacimiento = "", correoInst = "", correoPers = "", programa = "";
        long celular = 0, fijo = 0;
        vista.mostrarInformacion("\nModificar estudiante");
        correoInst = vista.leerDatosString("Ingresar correo institucional: ");
        Estudiante est = dto.getEstudianteDAO().buscarEstudiante(correoInst);
        if(est.getCorreoInst() != null)
        {
            correoPers = vista.leerDatosString("\nIngresar correo personal: ");
            celular = vista.leerDatoLong("\nIngresar número de celular: ");
            fijo = vista.leerDatoLong("\nIngresar número fijo: ");
            programa = vista.leerDatosString("\nIngresar programa:");
            
            dto.getEstudianteDAO().modificar(correoInst, correoPers, celular, fijo, programa);
           
            vista.mostrarInformacion("\nSe modificó el estudiante\n");
        }
        else
        {
            vista.mostrarInformacion("El estudiante no se encuentra registrado en el instituto \n");
        }    
    }
    
    public void eliminarEstudiante() {
        String correoInst = "";
        vista.mostrarInformacion("\nEliminar estudiante");
        correoInst = vista.leerDatosString("Ingresar correo institucional:");
        
        Estudiante est = dto.getEstudianteDAO().buscarEstudiante(correoInst);
        if(est.getCorreoInst() != null)
        {
            if (dto.getEstudianteDAO().eliminarEstudiante(correoInst))
            {
                vista.mostrarInformacion("Se eliminó el estudiante\n");
            }
        }
        else
        {
            vista.mostrarInformacion("El estudiante no se encuentra registrado\n");
        }    
    }
    
    public void mostrarDirectorio() {
        vista.mostrarInformacion("\nEl directorio de los estudiantes");
        vista.mostrarInformacion(dto.getEstudianteDAO().verEstudiantes());
    }  
    
    public void buscarEstudianteApellido(){
        String apellidos  = "";
        vista.mostrarInformacion("\n2. Buscar estudiante por apellidos");
        apellidos = vista.leerDatosString("Ingresar apellidos:  ");
        String PRINT = dto.getEstudianteDAO().buscarEstudianteApellido(apellidos);
        if(PRINT != "")
        {
            vista.mostrarInformacion(PRINT+"\n");
        }
        else
        {
            vista.mostrarInformacion("No hay resultados para esa consulta\n");
        }    
    }
    
    public void buscarEstudiantePrograma(){
        String programa  = "";
        vista.mostrarInformacion("\n3. Bucar por programa");
        programa = vista.leerDatosString("Ingresar programa:  ");
        String PRINT = dto.getEstudianteDAO().buscarEstudiantePrograma(programa);
        if(PRINT != "")
        {
            vista.mostrarInformacion(PRINT+"\n");
        }
        else
        {
             vista.mostrarInformacion("El estudiante no se encuentra registrado.\n");
        }    
    }
    
    public void buscarEstudianteNacimiento(){
        String fNacimiento  = "";
        vista.mostrarInformacion("\n5. Buscar por fecha de nacimiento ");
        fNacimiento = vista.leerDatosString("Ingresar fecha de nacimiento: ");
        String PRINT = dto.getEstudianteDAO().buscarEstudianteNacimiento(fNacimiento);
        if(PRINT != "")
        {
            vista.mostrarInformacion(PRINT+"\n");
        }
        else
        {
            vista.mostrarInformacion("No hay resultados para esa consulta\n");
        }    
    }
    
    public void buscarEstudianteCelular(){
        long celular;
        vista.mostrarInformacion("\n6. Buscar por número de celular");
        celular = Long.parseLong(vista.leerDatosString("Ingresar número de celular: "));
        String PRINT = dto.getEstudianteDAO().buscarEstudianteCelular(celular);
        if(PRINT != "")
        {
            vista.mostrarInformacion(PRINT+"\n");
        }
        else
        {
            vista.mostrarInformacion("No hay resultados para esa consulta\n");
        }    
    }
    
    public void cantidadEstudiantes(){
        String programa;
        vista.mostrarInformacion("\n4. Buscar cantidad de estudiantes por programa");
        programa = vista.leerDatosString("Ingresar programa: ");
        String PRINT = dto.getEstudianteDAO().calcularPrograma(programa);
        if("0".equals(PRINT))
        {   
            vista.mostrarInformacion("\nNo hay estudiantes registrados en ese programa.\n");
        }
        else
        {
            vista.mostrarInformacion("\nCantidad estudiantes " + programa + ": " + PRINT + "\n");
        }    
    }
}

