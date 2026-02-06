package connoraclesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author herio
 * Proyecto para conexion a base de datos Oracle SQL,
 * esto para hacerse en un JAR e implementarse dentro de proyectos futuros y
 * facilitar las conexiones.
 * 
 */
public class connOracleSql {

    private static final String driver = "oracle.jdbc.OracleDriver";

    //funcion para enviar la conexion
    public static Connection getConnection(String user, String pass, String host, String db) throws SQLException {
        String connectionUrl = "jdbc:oracle:thin:@"+host+":1521:"+db;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException  ex) {
            throw new SQLException(
                "No se encontró el driver JDBC de Oracle SQL", ex
            );
        }
        return DriverManager.getConnection(connectionUrl,user,pass);
    }
    
}
