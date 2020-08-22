package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "citaController")
@SessionScoped
public class CitaController implements Serializable {

    public CitaController() {
    }
    
}
