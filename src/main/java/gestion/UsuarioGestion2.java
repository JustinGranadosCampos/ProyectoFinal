package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Conexion;
import model.Usuario;

public class UsuarioGestion2 {

    private static final String SQL_SELECT_USUARIO = "Select * from usuario where idUsuario=?";

    public static Usuario valida(String idUsuario, String pwUsuario) {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIO);
            sentencia.setString(1, idUsuario);
            ResultSet rs = sentencia.executeQuery();
            if (rs != null && rs.next() && rs.getString(2).equals(pwUsuario)) {
                usuario = new Usuario();
                usuario.setIdUsuario(idUsuario);
                usuario.setPwUsuario(pwUsuario);
                usuario.setNombreUsuario(rs.getString(3));
                usuario.setIdRol(rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

}
