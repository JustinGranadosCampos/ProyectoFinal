package model;

import java.util.Date;

public class Cita {
    private int cod_cita;
    private Date fecha_cita;
    private Date hora_cita;
    private int id_paciente;
    private int id_distrito;
    private int id_caton;
    private int id_provincia;
    private int localidad;
    private int id_usuario;
    private int id_rol;
    private int id_servicio;
    
    /*Varibales para la Vista Citas*/
    private String nombrePaciente;
    private String nombreProvincia;
    private String nombreMedico;
    private String desc_provincia;
    private String sede;

    public Cita() {
    }

    public Cita(int cod_cita, Date fecha_cita, Date hora_cita, int id_paciente, int id_distrito, int id_caton, int id_provincia, int localidad, int id_usuario, int id_rol, int id_servicio) {
        this.cod_cita = cod_cita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.id_paciente = id_paciente;
        this.id_distrito = id_distrito;
        this.id_caton = id_caton;
        this.id_provincia = id_provincia;
        this.localidad = localidad;
        this.id_usuario = id_usuario;
        this.id_rol = id_rol;
        this.id_servicio = id_servicio;
    }
    
    /*Constructor para la vista citas*/
    public Cita(int cod_cita, Date fecha_cita, Date hora_cita, String sede, String nombreP, String apellidoP, String nombreProvincia, String nombreMedico, String desc_provincia) {
        this.cod_cita = cod_cita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.sede = sede;
        this.nombrePaciente = nombreP + apellidoP;
        this.nombreProvincia = nombreProvincia;
        this.nombreMedico = nombreMedico;
        this.desc_provincia = desc_provincia;
    }
    
    public int getCod_cita() {
        return cod_cita;
    }

    public void setCod_cita(int cod_cita) {
        this.cod_cita = cod_cita;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public Date getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(Date hora_cita) {
        this.hora_cita = hora_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(int id_distrito) {
        this.id_distrito = id_distrito;
    }

    public int getId_caton() {
        return id_caton;
    }

    public void setId_caton(int id_caton) {
        this.id_caton = id_caton;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public int getLocalidad() {
        return localidad;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
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

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
}
