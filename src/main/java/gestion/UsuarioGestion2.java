package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario2;

public class UsuarioGestion2 {

    private static final String SQL_SELECT_V_USUARIO_SESION = "Select * from usuario_sesion where NOMBRE_USUARIO=?";
    private static final String SQL_SELECT_USUARIOS = "SELECT * FROM USUARIO_SISTEMA";
    private static final String SQL_SELECT_USUARIO = "SELECT * FROM USUARIO_SISTEMA WHERE ID_USUARIO=?";
    private static final String SQL_INSERT_USUARIO = "INSERT INTO USUARIO_SISTEMA(NOMBRE_COMPLETO,CLAVE,ID_ROL,TELEFONO,DIRECCION,NOMBRE_USUARIO) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE_USUARIO = "UPDATE USUARIO_SISTEMA SET NOMBRE_COMPLETO=?,CLAVE=?,ID_ROL=?,TELEFONO=?,DIRECCION=?,NOMBRE_USUARIO=? WHERE ID_USUARIO=?";
    private static final String SQL_DELETE_USUARIO = "DELETE FROM USUARIO_SISTEMA WHERE ID_USUARIO=?";

    public static Usuario2 valida(String nombreUsuario, String pwUsuario) {
        Usuario2 usuario2 = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_V_USUARIO_SESION);
            sentencia.setString(1, nombreUsuario);
            ResultSet rs = sentencia.executeQuery();
            if (rs != null && rs.next() && rs.getString(2).equals(pwUsuario)) {
                usuario2 = new Usuario2();
                usuario2.setNombreUsuario(nombreUsuario);
                usuario2.setPwUsuario(pwUsuario);
                usuario2.setDesc_rol(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario2;
    }
    
    public static ArrayList<Usuario2> getUsuarios(){
        ArrayList<Usuario2> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIOS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new Usuario2(
                        datos.getInt(1),/*id_usuario*/
                        datos.getString(2),/*Nombrecompleto*/
                        datos.getString(3),/*Clave*/
                        datos.getInt(4),/*Id_rol*/
                        datos.getString(5),/*telefono*/
                        datos.getString(6),/*direccion*/
                        datos.getString(7)/*nombreUsuario*/
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static Usuario2 getUsuario(int id) {
        Usuario2 usuario = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIO);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                usuario = new Usuario2(
                        datos.getInt(1),/*id_usuario*/
                        datos.getString(2),/*Nombrecompleto*/
                        datos.getString(3),/*Clave*/
                        datos.getInt(4),/*Id_rol*/
                        datos.getString(5),/*telefono*/
                        datos.getString(6),/*direccion*/
                        datos.getString(7)/*nombreUsuario*/
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
    public static boolean insertar(Usuario2 usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_USUARIO);
            sentencia.setString(1, usuario.getNombreCompleto());
            sentencia.setString(2, usuario.getPwUsuario());
            sentencia.setInt(3, usuario.getId_rol());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getDireccion());
            sentencia.setString(6, usuario.getNombreUsuario());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean modificar(Usuario2 usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_USUARIO);
            sentencia.setString(1, usuario.getNombreCompleto());
            sentencia.setString(2, usuario.getPwUsuario());
            sentencia.setInt(3, usuario.getId_rol());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getDireccion());
            sentencia.setString(6, usuario.getNombreUsuario());
            sentencia.setInt(7, usuario.getId_usuario());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminar(Usuario2 usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETE_USUARIO);
            sentencia.setInt(1, usuario.getId_usuario());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
