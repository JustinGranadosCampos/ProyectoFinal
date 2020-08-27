package controller;

import gestion.ServicioPacienteGestion;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Servicio_x_Paciente;

@Named(value = "servicioPacienteController")
@RequestScoped
public class ServicioPacienteController extends Servicio_x_Paciente implements Serializable{

    public ServicioPacienteController() {
    }
    
    public List<Servicio_x_Paciente> getServiciosPacientes() {
        return ServicioPacienteGestion.getServiciosPacientes();
    }
    
    public String edita(int id) {/*Boton de editar*/
        Servicio_x_Paciente sxp = ServicioPacienteGestion.getServicioPaciente(id);
        if (sxp != null) {
            this.setId(sxp.getId());
            this.setRecurrente(sxp.getRecurrente());
            this.setId_pacient(sxp.getId_pacient());
            this.setId_distrito(sxp.getId_distrito());
            this.setId_canton(sxp.getId_canton());
            this.setId_provincia(sxp.getId_provincia());
            this.setId_servicio(sxp.getId_servicio());
            return "editasp.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaSPForm:codigo", msg);
            return "servicio_x_cliente_gestion.xhtml";
        }
    }
}
