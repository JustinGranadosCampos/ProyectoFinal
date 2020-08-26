package controller;

import gestion.ServicioGestion;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Servicio;

@Named(value = "servicioController")
@RequestScoped
public class ServicioController extends Servicio implements Serializable  {

    public ServicioController() {
    }
    
     public List<Servicio> getServicios() {
        return ServicioGestion.getServicios();
    }
    
    public String edita(int id) {/*Boton de editar*/
        Servicio servicio = ServicioGestion.getServicio(id);
        if (servicio != null) {
            this.setId_servicio(servicio.getId_servicio());
            this.setDesc_servicio(servicio.getDesc_servicio());
            this.setCodigo_servicio(servicio.getCodigo_servicio());
            this.setPrecio(servicio.getPrecio());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion del servicio ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaServicioForm:codigo", msg);
            return "servicio_gestion.xhtml";
        }
    }
    
    public String inserta() {
        if (ServicioGestion.insertar(this)) {
            return "servicio_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion de servicio duplicada");
            FacesContext.getCurrentInstance().addMessage("editaServicioForm:codigo", msg);
            return "edita.xhtml";
        }
    }

    public String modifica() {
        if (ServicioGestion.modificar(this)) {
            return "servicio_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion de servicio duplicada");
            FacesContext.getCurrentInstance().addMessage("editaServicioForm:codigo", msg);
            return "edita.xhtml";
        }
    }

    public String elimina() {
        if (ServicioGestion.eliminar(this)) {
            return "servicio_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion de servicio ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaServicioForm:codigo", msg);
            return "edita.xhtml";
        }
    }
}
