package controller;

import gestion.ServicioGestion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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
    
    public void respaldo() {
        ZipOutputStream out = null;
        try {
            String json = ServicioGestion.generarJson();
            File f = new File(FacesContext.getCurrentInstance()
                    .getExternalContext().
                    getRealPath("/respaldo") + "servicios.zip");
            out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry("servicios.json");
            out.putNextEntry(e);
            byte[] data = json.getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();
            File zipPath = new File(FacesContext.getCurrentInstance()
                    .getExternalContext().
                    getRealPath("/respaldo") + "servicios.zip");
            byte[] zip = Files.readAllBytes(zipPath.toPath());

            HttpServletResponse respuesta
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                            .getExternalContext().getResponse();
            ServletOutputStream sos = respuesta.getOutputStream();
            respuesta.setContentType("application/7zip");
            respuesta.setHeader("Content-disposition",
                    "attachment; filename=servicios.zip");
            sos.write(zip);
            sos.flush();
            FacesContext.getCurrentInstance().getResponseComplete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
