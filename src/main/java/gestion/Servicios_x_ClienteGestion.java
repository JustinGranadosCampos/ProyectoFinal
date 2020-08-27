package gestion;

public class Servicios_x_ClienteGestion {
    private static final String SQL_SELECT_CITAS = "SELECT * FROM servicios_x_paciente";
    private static final String SQL_SELECT_CITA = "SELECT * FROM CITA WHERE COD_CITA=?";
    private static final String SQL_UPDATE_CITA = "UPDATE CITA SET FECHA_CITA=?,HORA_CITA=?,ID_PACIENTE=?,ID_DISTRITO=?,ID_CANTON=?,ID_PROVINCIA=?,LOCALIDAD=?,ID_USUARIO=?,ID_ROL=?,ID_SERVICIO=? WHERE COD_CITA=?";
    private static final String SQL_INSERT_CITA = "INSERT INTO CITA(FECHA_CITA,HORA_CITA,ID_PACIENTE,ID_DISTRITO,ID_CANTON,ID_PROVINCIA,LOCALIDAD,ID_USUARIO,ID_ROL,ID_SERVICIO) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_CITA = "DELETE FROM CITA WHERE COD_CITA=?";
}