package controller;

import gestion.PacienteGestion;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Paciente;

@Named(value = "pacienteController")
//@ViewScoped
@ApplicationScoped
public class PacienteController extends Paciente implements Serializable {

    public PacienteController() {
    }
    
    public List<Paciente> mostrarPacientes(){
        return PacienteGestion.mostrarListaCitas();
    }
    
    public String edita(String id) {
        Paciente paciente = PacienteGestion.getPaciente(id);
        if (paciente != null) {
            this.setId_paciente(paciente.getId_paciente());
            this.setPrimer_nombre(paciente.getPrimer_nombre());
            this.setSegundo_nombre(paciente.getSegundo_nombre());
            this.setApellido1(paciente.getApellido1());
            this.setApellido2(paciente.getApellido2());
            this.setTelefono(paciente.getTelefono());
            this.setCorreo(paciente.getCorreo());
            this.setCedula(paciente.getCedula());
            this.setId_distrito(paciente.getId_distrito());
            this.setId_canton(paciente.getId_canton());
            this.setId_provincia(paciente.getId_provincia());
            this.setFecha_nacimiento(paciente.getFecha_nacimiento());
            this.setPeso(paciente.getPeso());
            this.setEstatura(paciente.getEstatura());
            this.setGrasaCorp(paciente.getGrasaCorp());
            this.setCintura(paciente.getCintura());
            return "http://localhost:8080/ProyectoF/faces/admin/cliente/edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", msg);
            return "cliente_gestion.xhtml";
        }
    }
    
    public String inserta() {
        if (PacienteGestion.insertar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }

    public String modifica() {
        if (PacienteGestion.modificar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }

    public String elimina() {
        if (PacienteGestion.eliminar(this)) {
            return "list.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", msg);
            return "edita.xhtml";
        }
    }

    //Creacion de nueva Variable 
    private boolean noImprimir = true;

    public boolean isNoImprimir() {
        return noImprimir;
    }

    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }

    public void buscaPaciente(String id) {
        if ("".equalsIgnoreCase(id)) {
            noImprimir = true;
        } else {
            Paciente paciente = PacienteGestion.getPaciente(id);
            if (paciente != null) {
                this.setId_paciente(paciente.getId_paciente());
            this.setPrimer_nombre(paciente.getPrimer_nombre());
            this.setSegundo_nombre(paciente.getSegundo_nombre());
            this.setApellido1(paciente.getApellido1());
            this.setApellido2(paciente.getApellido2());
            this.setTelefono(paciente.getTelefono());
            this.setCorreo(paciente.getCorreo());
            this.setCedula(paciente.getCedula());
            this.setId_distrito(paciente.getId_distrito());
            this.setId_canton(paciente.getId_canton());
            this.setId_provincia(paciente.getId_provincia());
            this.setFecha_nacimiento(paciente.getFecha_nacimiento());
            this.setPeso(paciente.getPeso());
            this.setEstatura(paciente.getEstatura());
            this.setGrasaCorp(paciente.getGrasaCorp());
            this.setCintura(paciente.getCintura());
                noImprimir = false;
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Posiblemente identificacion ya no exista");
                FacesContext.getCurrentInstance()
                        .addMessage("certificacionEstudianteForm:identificacion", msg);
                noImprimir = true;

            }

        }

    }
}
