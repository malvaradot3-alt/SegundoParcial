/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EstudianteDao;
import modelo.Estudiante;
import java.util.List;

public class EstudianteController {

    private final EstudianteDao dao = new EstudianteDao();

    public String getUltimoError() {
        return dao.getUltimoError();
    }

    public List<Estudiante> obtenerEstudiante() {
        return dao.obtenerTodos();
    }

   
    public boolean guardarEstudiante(Estudiante Est) {
        return dao.guardar(Est);
    }

  
    public boolean eliminarEstudiante(int id) {
        return dao.eliminar(id);
    }

    
    public boolean actualizarEstudiante(Estudiante Est) {
        return dao.actualizar(Est);
    }
}
    

