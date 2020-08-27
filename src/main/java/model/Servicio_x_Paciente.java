package model;

public class Servicio_x_Paciente {
    private char recurrente;
    private int id_pacient;
    private int id_distrito;
    private int id_canton;
    private int id_provincia;
    private int id_servicio;

    public Servicio_x_Paciente() {
    }

    public Servicio_x_Paciente(char recurrente, int id_pacient, int id_distrito, int id_canton, int id_provincia, int id_servicio) {
        this.recurrente = recurrente;
        this.id_pacient = id_pacient;
        this.id_distrito = id_distrito;
        this.id_canton = id_canton;
        this.id_provincia = id_provincia;
        this.id_servicio = id_servicio;
    }

    public char getRecurrente() {
        return recurrente;
    }

    public void setRecurrente(char recurrente) {
        this.recurrente = recurrente;
    }

    public int getId_pacient() {
        return id_pacient;
    }

    public void setId_pacient(int id_pacient) {
        this.id_pacient = id_pacient;
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

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    
    
}