package connsqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author herio 
 * Proyecto para conexion a base de datos SQL Server de Windows,
 * esto para hacerse en un JAR e implementarse dentro de proyectos futuros y
 * facilitar las conexiones.
 * 
 */
public class connSqlServer {

    //Driver de SQL Server
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //funcion para enviar la conexion
    public static Connection getConnection(String user, String pass, String host, String db) throws SQLException {
        String connectionUrl = "jdbc:sqlserver://" + host + ":1433;databaseName=" + db + ";user=" + user + ";password=" + pass + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException  ex) {
            throw new SQLException(
                "No se encontró el driver JDBC de SQL Server", ex
            );
        }
        return DriverManager.getConnection(connectionUrl);
    }
}
