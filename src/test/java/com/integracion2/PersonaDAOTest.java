package com.integracion2;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaDAOTest {

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
    public void testOperacionesBasicasPersona() throws SQLException {
        try {
            // Realización de la prueba
            PersonaDAO personaDAO = new PersonaDAO(connection);

            // Insertar
            Persona nuevaPersona = new Persona("98765432-1", "Jane", "Doe", "123456789", "2023-08-26");
            boolean insertResult = personaDAO.insertarPersona(nuevaPersona);
            assertTrue(insertResult);

            // Leer
            Persona personaLeida = personaDAO.obtenerPersonaPorRut("98765432-1");
            assertNotNull(personaLeida);

            // Actualizar
            personaLeida.setNombre("Jane Updated");
            boolean updateResult = personaDAO.actualizarPersona(personaLeida);
            assertTrue(updateResult);

            // Eliminar
            boolean deleteResult = personaDAO.eliminarPersona("98765432-1");
            assertTrue(deleteResult);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Excepción durante la prueba: " + e.getMessage());
        }
    }
}
