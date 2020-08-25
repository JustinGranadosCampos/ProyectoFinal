package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Paciente;

public class PacienteGestion {
    private static final String SQL_SELECT_V_PACIENTE_UBICACION = "SELECT * FROM v_paciente_ubicacion";
    private static final String SQL_SELECT_PACIENTE = "SELECT * FROM v_paciente_ubicacion WHERE ID_PACIENTE=?";
    private static final String SQL_INSERT_PACIENTE = "INSERT INTO PACIENTE(PRIMER_NOMBRE,SEGUNDO_NOMBRE,APELLIDO1,APELLIDO2,TELEFONO,CORREO,CEDULA,ID_DISTRITO,ID_CANTON,ID_PROVINCIA,FECHA_NACIMIENTO,PESO,ESTATURA,GRASA,CINTURA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PACIENTE = "UPDATE PACIENTE SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,APELLIDO1=?,APELLIDO2=?,TELEFONO=?,CORREO=?,CEDULA=?,ID_DISTRITO=?,ID_CANTON=?,ID_PROVINCIA=?,FECHA_NACIMIENTO=?,PESO=?,ESTATURA=?,GRASA=?,CINTURA=? WHERE ID_PACIENTE=?";
    private static final String SQL_DELETE_PACIENTE = "DELETE FROM PACIENTE WHERE ID_PACIENTE=?";
    
    public static ArrayList<Paciente> mostrarListaCitas() {
        ArrayList<Paciente> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_V_PACIENTE_UBICACION);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Paciente(datos.getInt(1),/*id*/
                        datos.getString(2),/*Pnombre*/
                        datos.getString(3),/*sNombre*/
                        datos.getString(4),/*apellido1*/
                        datos.getString(5),/*apellido2*/
                        datos.getString(6),/*telefono*/
                        datos.getString(7),/*correo*/
                        datos.getString(8),/*cedula*/
                        datos.getDate(9),/*fechaNaci*/
                        datos.getDouble(10),/*peso*/
                        datos.getDouble(11),/*estatura*/
                        datos.getDouble(12),/*grasa*/
                        datos.getDouble(13),/*cintura*/
                        datos.getString(14),/*distrito*/
                        datos.getString(15),/*canton*/
                        datos.getString(16)/*provincia*/
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static Paciente getPaciente(int id) {
        Paciente paciente = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PACIENTE);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                paciente = new Paciente(datos.getInt(1),/*id*/
                        datos.getString(2),/*Pnombre*/
                        datos.getString(3),/*sNombre*/
                        datos.getString(4),/*apellido1*/
                        datos.getString(5),/*apellido2*/
                        datos.getString(6),/*telefono*/
                        datos.getString(7),/*correo*/
                        datos.getString(8),/*cedula*/
                        datos.getInt(9),/*ID_Distrito*/
                        datos.getInt(10),/*ID_canton*/
                        datos.getInt(11),/*ID_provincia*/
                        datos.getDate(12),/*fecha_naci*/
                        datos.getDouble(13),/*peso*/
                        datos.getDouble(14),/*estatura*/
                        datos.getDouble(15),/*grasa*/
                        datos.getDouble(16)/*cintura*/
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paciente;
    }
    
    public static boolean insertar(Paciente paciente) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_PACIENTE);
            sentencia.setString(1, paciente.getPrimer_nombre());
            sentencia.setString(2, paciente.getSegundo_nombre());
            sentencia.setString(3, paciente.getApellido1());
            sentencia.setString(4, paciente.getApellido2());
            sentencia.setString(5, paciente.getTelefono());
            sentencia.setString(6, paciente.getCorreo());
            sentencia.setString(7, paciente.getCedula());
            sentencia.setInt(8, paciente.getId_distrito());
            sentencia.setInt(9, paciente.getId_canton());
            sentencia.setInt(10, paciente.getId_provincia());
            sentencia.setObject(11, paciente.getFecha_nacimiento());
            sentencia.setDouble(12, paciente.getPeso());
            sentencia.setDouble(13, paciente.getEstatura());
            sentencia.setDouble(14, paciente.getGrasaCorp());
            sentencia.setDouble(15, paciente.getCintura());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean modificar(Paciente paciente) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_PACIENTE);
            sentencia.setString(1, paciente.getPrimer_nombre());
            sentencia.setString(2, paciente.getSegundo_nombre());
            sentencia.setString(3, paciente.getApellido1());
            sentencia.setString(4, paciente.getApellido2());
            sentencia.setString(5, paciente.getTelefono());
            sentencia.setString(6, paciente.getCorreo());
            sentencia.setString(7, paciente.getCedula());
            sentencia.setInt(8, paciente.getId_distrito());
            sentencia.setInt(9, paciente.getId_canton());
            sentencia.setInt(10, paciente.getId_provincia());
            sentencia.setObject(11, paciente.getFecha_nacimiento());
            sentencia.setDouble(12, paciente.getPeso());
            sentencia.setDouble(13, paciente.getEstatura());
            sentencia.setDouble(14, paciente.getGrasaCorp());
            sentencia.setDouble(15, paciente.getCintura());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminar(Paciente paciente) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETE_PACIENTE);
            sentencia.setInt(1, paciente.getId_paciente());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}