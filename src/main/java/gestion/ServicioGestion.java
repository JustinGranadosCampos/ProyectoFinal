package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Servicio;

public class ServicioGestion {
    
    private static final String SQL_SELECT_SERVICIOS="SELECT * FROM SERVICIO";
    private static final String SQL_SELECT_SERVICIO="SELECT * FROM SERVICIO WHERE ID_SERVICIO=?";
    private static final String SQL_INSERT_SERVICIO="INSERT INTO SERVICIO(DESC_SERVICIO,CODIGO_SERVICIO,PRECIO) VALUES(?,?,?)";
    private static final String SQL_UPDATE_SERVICIO="UPDATE SERVICIO SET DESC_SERVICIO=?,CODIGO_SERVICIO=?,PRECIO=? WHERE ID_SERVICIO=?";
    private static final String SQL_DELETE_SERVICIO="DELETE FROM SERVICIO WHERE ID_SERVICIO=?";
    
    public static ArrayList<Servicio> getServicios() {
        ArrayList<Servicio> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SERVICIOS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Servicio(
                        datos.getInt(1),/*id_servicio*/
                        datos.getString(2),/*desc*/
                        datos.getString(3),/*codigo*/
                        datos.getDouble(4)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static Servicio getServicio(int id) {
        Servicio servicio = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SERVICIO);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                servicio = new Servicio(
                        datos.getInt(1),/*id_servicio*/
                        datos.getString(2),/*desc*/
                        datos.getString(3),/*codigo*/
                        datos.getDouble(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return servicio;
    }
    
    public static boolean insertar(Servicio servicio) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_SERVICIO);
            sentencia.setString(1, servicio.getDesc_servicio());
            sentencia.setString(2, servicio.getCodigo_servicio());
            sentencia.setDouble(3, servicio.getPrecio());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean modificar(Servicio servicio) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_SERVICIO);
            sentencia.setString(1, servicio.getDesc_servicio());
            sentencia.setString(2, servicio.getCodigo_servicio());
            sentencia.setDouble(3, servicio.getPrecio());
            sentencia.setInt(4, servicio.getId_servicio());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminar(Servicio servicio) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETE_SERVICIO);
            sentencia.setInt(1, servicio.getId_servicio());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CitaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}