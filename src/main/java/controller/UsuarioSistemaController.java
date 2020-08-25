package controller;

import gestion.UsuarioGestion2;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Usuario2;
import static org.castor.mapping.AbstractMappingLoaderFactory.LOG;

@Named(value = "usuarioSistemaController")
//@SessionScoped
@RequestScoped
public class UsuarioSistemaController extends Usuario2 implements Serializable {

//    @PostConstruct
//    void initialiseSession() {
//        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//    }

    public UsuarioSistemaController() {
    }

    public String inicarSesion() {
        Usuario2 usuario = UsuarioGestion2.valida(this.getNombreUsuario(), this.getPwUsuario());
        if (usuario != null) {
//            this.setNombreUsuario(usuario.getNombreUsuario());
            this.setDesc_rol(usuario.getDesc_rol());
            return "principal?faces-redirect=true";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Usuario y/o contraseña invalidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            FacesContext.getCurrentInstance().addMessage("loginForm:usuario", msg);
            return "index?faces-redirect=true";
        }
    }
    
    public List<Usuario2> getUsuarios() {
        return UsuarioGestion2.getUsuarios();
    }

    public String cerrarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();

        // invalidate session
	ExternalContext ec = fc.getExternalContext();
	HttpSession session = (HttpSession) ec.getSession(false);
	session.invalidate();
	
//         redirect to the login / home page
	try {
	    ec.redirect("../../index.xhtml");
	} catch (IOException e) {
	    LOG.error("Redirect to the login page failed");
	    throw new FacesException(e);
	}
	return null;
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        return "../../index.xhtml";
    }
    
    public String edita(int id) {/*Boton de editar*/
        Usuario2 usuario = UsuarioGestion2.getUsuario(id);
        if (usuario != null) {
            this.setId_usuario(usuario.getId_usuario());
            this.setNombreCompleto(usuario.getNombreCompleto());
            this.setPwUsuario(usuario.getPwUsuario());
            this.setId_rol(usuario.getId_rol());
            this.setTelefono(usuario.getTelefono());
            this.setDireccion(usuario.getDireccion());
            this.setNombreUsuario(usuario.getNombreUsuario());
            return "edita.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:identificacion", msg);
            return "usuario_gestion.xhtml";
        }
    }
    
    public String inserta() {
        if (UsuarioGestion2.insertar(this)) {
            return "usuario_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion duplicada");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:identificacion", msg);
            return "edita.xhtml";
        }
    }

    public String modifica() {
        if (UsuarioGestion2.modificar(this)) {
            return "usuario_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion duplicada");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:identificacion", msg);
            return "edita.xhtml";
        }
    }

    public String elimina() {
        if (UsuarioGestion2.eliminar(this)) {
            return "usuario_gestion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente identificacion ya no exista");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:identificacion", msg);
            return "edita.xhtml";
        }
    }
    
}
