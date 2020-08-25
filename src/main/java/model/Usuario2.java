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
    private int id_usuario;
    private int id_rol;

    public Usuario2() {

    }
    
    /*Insersión de datos ID,NombreCompleto,Clave,ID_Rol,Telefono,Direccion,NombreUsuario*/

    public Usuario2(int id_usuario, String nombreCompleto, String pwUsuario, int id_rol, String telefono, String direccion, String nombreUsuario) {
        this.id_usuario = id_usuario;
        this.nombreCompleto = nombreCompleto;
        this.pwUsuario = pwUsuario;
        this.id_rol = id_rol;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
}
