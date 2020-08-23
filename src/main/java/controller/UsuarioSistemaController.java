/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.UsuarioGestion2;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Usuario2;
import static org.castor.mapping.AbstractMappingLoaderFactory.LOG;

@Named(value = "usuarioSistemaController")
@SessionScoped
public class UsuarioSistemaController extends Usuario2 implements Serializable {

    public UsuarioSistemaController() {
    }
    
    public String inicarSesion() {
        Usuario2 usuario = UsuarioGestion2.valida(this.getNombreUsuario(), this.getPwUsuario());
        if (usuario != null) {
//            this.setNombreUsuario(usuario.getNombreUsuario());
            this.setDesc_rol(usuario.getDesc_rol());
            return "principal";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Usuario y/o contraseña invalidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            FacesContext.getCurrentInstance().addMessage("loginForm:usuario", msg);
            return "index.xhtml";
        }
    }
    
     public String cerrarSesion() {
         FacesContext fc = FacesContext.getCurrentInstance();
	
	// invalidate session
//	ExternalContext ec = fc.getExternalContext();
//	HttpSession session = (HttpSession) ec.getSession(false);
//	session.invalidate();
//	
	// redirect to the login / home page
//	try {
//	    ec.redirect("../../index.xhtml");
//	} catch (IOException e) {
//	    LOG.error("Redirect to the login page failed");
//	    throw new FacesException(e);
//	}
	
//	return null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "../../index.xhtml";
    }
}
