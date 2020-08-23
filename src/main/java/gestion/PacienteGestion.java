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
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}