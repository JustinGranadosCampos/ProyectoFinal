package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion conexion;
    private static final String DBURL = "jdbc:mysql://localhost:3306/new_project?autoReconnect=true&useSSL=false";//"jdbc:derby://localhost:1527/prueba";//"jdbc:mysql://localhost:3306/new_project?autoReconnect=true&useSSL=false";//"jdbc:derby://localhost:1527/ugeneral";/*jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false*/
    private static Connection conn;

    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
//            Class.forName("org.apache.derby.jdbc.ClientDriver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(DBURL, "root", "123456");
//            conn = DriverManager.getConnection(DBURL, "root", "root");
        } catch (ClassNotFoundException | SQLException | InstantiationException
                | IllegalAccessException | NoSuchMethodException | SecurityException
                | IllegalArgumentException
                | InvocationTargetException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized Connection getConexion() {
        if (conn == null) {
            conexion = new Conexion();
        }
        return conn;
    }

}
