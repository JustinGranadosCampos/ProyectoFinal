package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.ServicioPaciente;

public class ServicioPacienteGestion {
    private static final String SQL_SELECT_SERVICIOS_X_CLIENTES = "SELECT * FROM servicios_x_paciente";
    private static final String SQL_SELECT_SERVICIO_X_CLIENTE = "SELECT * FROM servicios_x_paciente WHERE ID=?";
    private static final String SQL_UPDATE_SERVICIO_X_CLIENTE = "UPDATE servicios_x_paciente SET RECURRENTE=?,ID_PACIENTE=?,ID_DISTRITO=?,ID_CANTON=?,ID_PROVINCIA=?,ID_SERVICIO=? WHERE ID=?";
    private static final String SQL_INSERT_SERVICIO_X_CLIENTE = "INSERT INTO servicios_x_paciente(RECURRENTE,ID_PACIENTE,ID_DISTRITO,ID_CANTON,ID_PROVINCIA,ID_SERVICIO) VALUES(?,?,?,?,?,?)";
    private static final String SQL_DELETE_SERVICIO_X_CLIENTE = "DELETE FROM servicios_x_paciente WHERE ID=?";
    
    public static ArrayList<ServicioPaciente> getServiciosPacientes() {
        ArrayList<ServicioPaciente> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SERVICIOS_X_CLIENTES);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new ServicioPaciente(
                        datos.getInt(1),/*id*/
                        datos.getString(2).charAt(0),/*recurrente*/
                        datos.getInt(3),/*id_paciente*/
                        datos.getInt(4),/*ID distrito*/
                        datos.getInt(5), /*id canton*/
                        datos.getInt(6),/*id provincia*/
                        datos.getInt(7)/*id servicio*/
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioPacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ServicioPaciente getServicioPaciente(int id) {
        ServicioPaciente sxp = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SERVICIO_X_CLIENTE);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                sxp = new ServicioPaciente(
                        datos.getInt(1),/*id*/
                        datos.getString(2).charAt(0),/*recurrente*/
                        datos.getInt(3),/*id_paciente*/
                        datos.getInt(4),/*ID distrito*/
                        datos.getInt(5), /*id canton*/
                        datos.getInt(6),/*id provincia*/
                        datos.getInt(7)/*id servicio*/
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioPacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sxp;
    }
    
    public static boolean insertar(ServicioPaciente sxp) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_SERVICIO_X_CLIENTE);
            sentencia.setString(1, "" + sxp.getRecurrente());
            sentencia.setInt(2, sxp.getId_pacient());
            sentencia.setInt(3, sxp.getId_distrito());
            sentencia.setInt(4, sxp.getId_canton());
            sentencia.setInt(5, sxp.getId_provincia());
            sentencia.setInt(6, sxp.getId_servicio());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ServicioPacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean modificar(ServicioPaciente sxp) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_SERVICIO_X_CLIENTE);
            sentencia.setString(1, "" + sxp.getRecurrente());
            sentencia.setInt(2, sxp.getId_pacient());
            sentencia.setInt(3, sxp.getId_distrito());
            sentencia.setInt(4, sxp.getId_canton());
            sentencia.setInt(5, sxp.getId_provincia());
            sentencia.setInt(6, sxp.getId_servicio());
            sentencia.setInt(7, sxp.getId());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ServicioPacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminar(ServicioPaciente sxp) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETE_SERVICIO_X_CLIENTE);
            sentencia.setInt(1, sxp.getId());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ServicioPacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}