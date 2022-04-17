package mintic.edu.poo.modelo;

import mintic.edu.poo.persistencia.EstudianteDAO;
/**
 *
 * @author Alejandro
 */
public class EstudianteDTO {
    
    private EstudianteDAO estudianteDAO;

    public EstudianteDTO(){ 
        estudianteDAO = new EstudianteDAO();
    }
    
   
    public EstudianteDAO getEstudianteDAO(){
        return estudianteDAO;
    }
    
    public void setEstudianteDAO(EstudianteDAO estudianteDAO){
        this.estudianteDAO = estudianteDAO;
    }
    
}