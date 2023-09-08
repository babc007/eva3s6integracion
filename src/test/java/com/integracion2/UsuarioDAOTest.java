package com.integracion2;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuarioDAOTest {

    private Connection connection;
    
    @Before
    public void setUp() throws Exception {
        // Configura la conexión a tu base de datos SQL Server con autenticación de Windows
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=BancoPlatinum;integratedSecurity=true;";
        connection = DriverManager.getConnection(jdbcUrl);
    }

    @After
    public void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testOperacionesBasicasUsuario() throws SQLException {
        try {
            // Realización de la prueba
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

            // Insertar
            Usuario nuevoUsuario = new Usuario("salmonesaustral\\NewUser", "newpassword");
            boolean insertResult = usuarioDAO.insertarUsuario(nuevoUsuario);
            assertTrue(insertResult);

            // Leer
            Usuario usuarioLeido = usuarioDAO.obtenerUsuarioPorUsername("salmonesaustral\\NewUser");
            assertNotNull(usuarioLeido);

            // Actualizar
            usuarioLeido.setPassword("newpasswordupdated");
            boolean updateResult = usuarioDAO.actualizarUsuario(usuarioLeido);
            assertTrue(updateResult);

            // Eliminar
            boolean deleteResult = usuarioDAO.eliminarUsuario("salmonesaustral\\NewUser");
            assertTrue(deleteResult);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Excepción durante la prueba: " + e.getMessage());
        }
    }
}
