package connmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author herio
 * Proyecto para conexion a base de datos MYSQL,
 * esto para hacerse en un JAR e implementarse dentro de proyectos futuros y
 * facilitar las conexiones.
 * 
 */
public class connMySql {
    
    
    //Driver de SQL Server
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    //funcion para enviar la conexion
    public static Connection getConnection(String user, String pass, String host, String db) throws SQLException {
        String connectionUrl = "jdbc:mysql://"+host+":3306/"+db+"?useUnicode=true&use"+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"+"serverTimezone=UTC";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException  ex) {
            throw new SQLException(
                "No se encontró el driver JDBC de SQL Server", ex
            );
        }
        return DriverManager.getConnection(connectionUrl,user,pass);
    }
    
}
