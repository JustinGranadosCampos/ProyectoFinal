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
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
