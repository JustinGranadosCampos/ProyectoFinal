package model;

public class Servicio {
    private int id_servicio;
    private String desc_servicio;
    private String codigo_servicio;
    private double precio;

    public Servicio() {
    }

    public Servicio(int id_servicio, String desc_servicio, String codigo_servicio, double precio) {
        this.id_servicio = id_servicio;
        this.desc_servicio = desc_servicio;
        this.codigo_servicio = codigo_servicio;
        this.precio = precio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getDesc_servicio() {
        return desc_servicio;
    }

    public void setDesc_servicio(String desc_servicio) {
        this.desc_servicio = desc_servicio;
    }

    public String getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(String codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Object getFechaNaci() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}