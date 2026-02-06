package connpostgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author herio
 * Proyecto para conexion a base de datos PostgreSQL,
 * esto para hacerse en un JAR e implementarse dentro de proyectos futuros y
 * facilitar las conexiones.
 * 
 */
public class connPostgreSql {
    
    //Driver de PostgreSQL
    private static final String driver = "org.postgresql.Driver";

    //funcion para enviar la conexion
    public static Connection getConnection(String user, String pass, String host, String db) throws SQLException {
        String connectionUrl = "jdbc:postgresql://"+host+":5432/"+db;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException  ex) {
            throw new SQLException(
                "No se encontró el driver JDBC de PostgreSQL", ex
            );
        }
        return DriverManager.getConnection(connectionUrl,user,pass);
    }
    
}
