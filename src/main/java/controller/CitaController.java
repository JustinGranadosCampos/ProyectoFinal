package controller;

import gestion.CitaGestion;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Cita;

@Named(value = "citaController")
@ApplicationScoped
public class CitaController extends Cita implements Serializable {

    public CitaController() {
    }
    
    public List<Cita> mostrarListaCitas() {
        return CitaGestion.mostrarListaCitas();
    }
    
    public List<Cita> getCitas() {
        return CitaGestion.getCitas();
    }
    
    public String edita(int id) {/*Boton de editar*/
        Cita cita = CitaGestion.getCita(id);
        if (cita != null) {
            this.setCod_cita(cita.getCod_cita());
            this.setFecha_cita(cita.getFecha_cita());
            this.setHora_cita(cita.getHora_cita());
            this.setId_paciente(cita.getId_paciente());
            this.setId_distrito(cita.getId_distrito());
            this.setId_canton(cita.getId_canton());
            this.setId_provincia(cita.getId_provincia());
            this.setSede(cita.getSede());
            this.setId_usuario(cita.getId_usuario());
            this.setId_rol(cita.getId_rol());
            this.setId_servicio(cita.getId_servicio());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:codigo", msg);
            return "cita_gestion.xhtml";
        }
    }
    
    public String inserta() {
        if (CitaGestion.insertar(this)) {
            return "cita_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion duplicada");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:codigo", msg);
            return "edita.xhtml";
        }
    }

    public String modifica() {
        if (CitaGestion.modificar(this)) {
            return "cita_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion duplicada");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:codigo", msg);
            return "edita.xhtml";
        }
    }

    public String elimina() {
        if (CitaGestion.eliminar(this)) {
            return "cita_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaCitaForm:codigo", msg);
            return "edita.xhtml";
        }
    }
}