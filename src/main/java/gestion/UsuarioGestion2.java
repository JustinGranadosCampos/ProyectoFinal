package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario2;

public class UsuarioGestion2 {

    private static final String SQL_SELECT_V_USUARIO_SESION = "Select * from usuario_sesion where NOMBRE_USUARIO=?";
    private static final String SQL_SELECT_USUARIOS = "";
    private static final String SQL_INSERT_USUARIO = "INSERT INTO USUARIO_SISTEMA() VALUES()";
    private static final String SQL_UPDATE_USUARIO = "UPDATE USUARIO_SISTEMA SET ";
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

}
