package controller;

import gestion.CitaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.Cita;

@Named(value = "citaController")
@SessionScoped
public class CitaController extends Cita implements Serializable {

    public CitaController() {
    }
    
    public List<Cita> mostrarListaCitas() {
        return CitaGestion.mostrarListaCitas();
    }
}