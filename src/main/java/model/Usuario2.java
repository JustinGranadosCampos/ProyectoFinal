package model;

public class Usuario2 {

    private String idUsuario;
    private String nombreCompleto;
    private String pwUsuario;
    private String nombreUsuario;
    private String idRol;
    private String telefono;
    private String direccion;
    
    /*Variables para vista sesion*/
    private String desc_rol;

    public Usuario2() {

    }
    
    /*Insersión de datos ID,NombreCompleto,Clave,ID_Rol,Telefono,Direccion,NombreUsuario*/

    public Usuario2(String idUsuario, String nombreCompleto, String pwUsuario, String idRol, String telefono, String direccion, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.pwUsuario = pwUsuario;
        this.idRol = idRol;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombreUsuario = nombreUsuario;
    }
    
    
    public Usuario2(String nombreUsuario, String pwUsuario, String desc_rol) {
        this.nombreUsuario = nombreUsuario;
        this.pwUsuario = pwUsuario;
        this.desc_rol = desc_rol;
    }

    public Usuario2(String idUsuario, String pwUsuario, String nombreUsuario, String idRol) {
        this.idUsuario = idUsuario;
        this.pwUsuario = pwUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idRol = idRol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPwUsuario() {
        return pwUsuario;
    }

    public void setPwUsuario(String pwUsuario) {
        this.pwUsuario = pwUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getDesc_rol() {
        return desc_rol;
    }

    public void setDesc_rol(String desc_rol) {
        this.desc_rol = desc_rol;
    }
}
