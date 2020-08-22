/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.UsuarioGestion2;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario2;

/**
 *
 * @author Justin Granados
 */
@Named(value = "usuarioSistemaController")
@SessionScoped
public class UsuarioSistemaController extends Usuario2 implements Serializable {

    /**
     * Creates a new instance of UsuarioSistemaController
     */
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
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
}
