package model;

import java.util.Date;

public class Paciente {
    private int id_paciente;
    private String primer_nombre;
    private String segundo_nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String correo;
    private String cedula;
    private int id_distrito;
    private int id_canton;
    private int id_provincia;
    private Date fecha_nacimiento;
    private double peso;
    private double estatura;
    private double grasaCorp;
    private double cintura;
    
    /*Variables adicionales de la Vista*/
    private String nombreCompleto;
    private String desc_distrito;
    private String desc_canton;
    private String desc_provincia;

    public Paciente() {
    }

    public Paciente(int id_paciente, String primer_nombre, String segundo_nombre, String apellido1, String apellido2, String telefono, String correo, String cedula, int id_distrito, int id_canton, int id_provincia, Date fecha_nacimiento, double peso, double estatura, double grasaCorp, double cintura) {
        this.id_paciente = id_paciente;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.id_distrito = id_distrito;
        this.id_canton = id_canton;
        this.id_provincia = id_provincia;
        this.fecha_nacimiento = fecha_nacimiento;
        this.peso = peso;
        this.estatura = estatura;
        this.grasaCorp = grasaCorp;
        this.cintura = cintura;
    }

    public Paciente(int id_paciente, String primer_nombre, String segundo_nombre, String apellido1, String apellido2, String telefono, String correo, String cedula, Date fecha_nacimiento, double peso, double estatura, double grasaCorp, double cintura, String desc_distrito, String desc_canton, String desc_provincia) {
        this.id_paciente = id_paciente;
        this.nombreCompleto = primer_nombre +" "+segundo_nombre+" "+apellido1+" "+apellido2;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.fecha_nacimiento = fecha_nacimiento;
        this.peso = peso;
        this.estatura = estatura;
        this.grasaCorp = grasaCorp;
        this.cintura = cintura;
        this.desc_distrito = desc_distrito;
        this.desc_canton = desc_canton;
        this.desc_provincia = desc_provincia;
    }
    
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(int id_distrito) {
        this.id_distrito = id_distrito;
    }

    public int getId_canton() {
        return id_canton;
    }

    public void setId_canton(int id_canton) {
        this.id_canton = id_canton;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getGrasaCorp() {
        return grasaCorp;
    }

    public void setGrasaCorp(double grasaCorp) {
        this.grasaCorp = grasaCorp;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDesc_distrito() {
        return desc_distrito;
    }

    public void setDesc_distrito(String desc_distrito) {
        this.desc_distrito = desc_distrito;
    }

    public String getDesc_canton() {
        return desc_canton;
    }

    public void setDesc_canton(String desc_canton) {
        this.desc_canton = desc_canton;
    }

    public String getDesc_provincia() {
        return desc_provincia;
    }

    public void setDesc_provincia(String desc_provincia) {
        this.desc_provincia = desc_provincia;
    }
    
    
}