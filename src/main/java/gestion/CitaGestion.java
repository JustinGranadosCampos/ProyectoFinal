package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cita;
import model.Conexion;

public class CitaGestion {
    private static final String SQL_SELECT_V_CITAS = "SELECT * FROM V_CITAS";
    private static final String SQL_SELECT_CITAS = "SELECT * FROM CITA";
    private static final String SQL_SELECT_CITA = "SELECT * FROM CITA WHERE COD_CITA=?";
    private static final String SQL_UPDATE_CITA = "UPDATE CITA SET FECHA_CITA=?,HORA_CITA=?,ID_PACIENTE=?,ID_DISTRITO=?,ID_CANTON=?,ID_PROVINCIA=?,LOCALIDAD=?,ID_USUARIO=?,ID_ROL=?,ID_SERVICIO=? WHERE COD_CITA=?";
    private static final String SQL_INSERT_CITA = "INSERT INTO CITA(FECHA_CITA,HORA_CITA,ID_PACIENTE,ID_DISTRITO,ID_CANTON,ID_PROVINCIA,LOCALIDAD,ID_USUARIO,ID_ROL,ID_SERVICIO) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_CITA = "DELETE FROM CITA WHERE COD_CITA=?";
    
    /*Vista v_citas*/
    public static ArrayList<Cita> mostrarListaCitas() {
        ArrayList<Cita> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_V_CITAS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Cita(
                        datos.getInt(1),/*cod_cita*/
                        datos.getDate(2),/*fecha*/
                        datos.getDate(3),/*hora*/
                        datos.getString(4),/*sede*/
                        datos.getString(5),/*cedula*/
                        datos.getString(6),/*nombreP*/
                        datos.getString(7),/*apellidoP*/
                        datos.getString(8),/*nombreProvincia*/
                        datos.getString(9),/*nombreMedico*/
                        datos.getString(10)/*desc_servicio*/
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList<Cita> getCitas() {
        ArrayList<Cita> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CITAS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Cita(
                        datos.getInt(1),/*cod_cita*/
                        datos.getDate(2),/*fecha*/
                        datos.getDate(3),/*hora*/
                        datos.getInt(4),/*ID paciente*/
                        datos.getInt(5), /*ID distrito*/
                        datos.getInt(6),/*canton*/
                        datos.getInt(7),/*provincia*/
                        datos.getString(8),/*Sede*/
                        datos.getInt(9),/*nombreProvincia*/
                        datos.getInt(10),/*nombreMedico*/
                        datos.getInt(11)/*desc_servicio*/
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static Cita getCita(int id) {
        Cita cita = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CITA);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                cita = new Cita(
                        datos.getInt(1),/*cod_cita*/
                        datos.getDate(2),/*fecha*/
                        datos.getDate(3),/*hora*/
                        datos.getInt(4),/*sede*/
                        datos.getInt(5),
                        datos.getInt(6),/*cedula*/
                        datos.getInt(7),/*nombreP*/
                        datos.getString(8),/*apellidoP*/
                        datos.getInt(9),/*nombreProvincia*/
                        datos.getInt(10),/*nombreMedico*/
                        datos.getInt(11)/*desc_servicio*/
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cita;
    }
    
    public static boolean insertar(Cita cita) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_CITA);
            sentencia.setObject(1, cita.getFecha_cita());
            sentencia.setObject(2, cita.getHora_cita());
            sentencia.setInt(3, cita.getId_paciente());
            sentencia.setInt(4, cita.getId_distrito());
            sentencia.setInt(5, cita.getId_canton());
            sentencia.setInt(6, cita.getId_provincia());
            sentencia.setString(7, cita.getSede());
            sentencia.setInt(8, cita.getId_usuario());
            sentencia.setInt(9, cita.getId_rol());
            sentencia.setInt(10, cita.getId_servicio());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean modificar(Cita cita) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_CITA);
            sentencia.setObject(1, cita.getFecha_cita());
            sentencia.setObject(2, cita.getHora_cita());
            sentencia.setInt(3, cita.getId_paciente());
            sentencia.setInt(4, cita.getId_distrito());
            sentencia.setInt(5, cita.getId_canton());
            sentencia.setInt(6, cita.getId_provincia());
            sentencia.setString(7, cita.getSede());
            sentencia.setInt(8, cita.getId_usuario());
            sentencia.setInt(9, cita.getId_rol());
            sentencia.setInt(10, cita.getId_servicio());
            sentencia.setInt(11, cita.getCod_cita());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminar(Cita cita) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETE_CITA);
            sentencia.setInt(1, cita.getCod_cita());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
