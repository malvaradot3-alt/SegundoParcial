package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {

    private final Properties config = new Properties();

    private String hostname;
    private String port;
    private String database;
    private String username;
    private String password;

    public CreateConnection() {
        cargarPropiedades();
    }

    private void cargarPropiedades() {
        try (InputStream in = CreateConnection.class.getResourceAsStream("/conexion/db_config.properties")) {

            if (in == null) {
                throw new IllegalStateException(
                        "No se encontró el archivo conexion/db_config.properties"
                );
            }

            config.load(in);

            hostname = config.getProperty("hostname");
            port = config.getProperty("port");
            database = config.getProperty("database");
            username = config.getProperty("username");
            password = config.getProperty("password");

        } catch (IOException | IllegalStateException ex) {
            System.out.println("ERROR AL CARGAR LA CONFIGURACIÓN DE POSTGRESQL");
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        if (hostname == null || port == null || database == null || username == null || password == null) {
            throw new SQLException("La configuración de PostgreSQL no está completa.");
        }

        String jdbcUrl = "jdbc:postgresql://"
                + hostname + ":"
                + port + "/"
                + database;

        try {
            Connection conn = DriverManager.getConnection(
                    jdbcUrl,
                    username,
                    password
            );

            System.out.println("Conexión establecida correctamente :)");
            return conn;

        } catch (SQLException ex) {
            System.out.println("ERROR DE CONEXIÓN A POSTGRESQL");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
