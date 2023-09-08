package com.integracion2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.integracion2.Persona;

import java.io.IOException;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Aquí realiza la validación de las credenciales en tu base de datos
        boolean validCredentials = validarCredenciales(username, password);

        if (validCredentials) {
            // Simulación: Obtén la información básica de la persona desde la base de datos
            Persona persona = obtenerInformacionPersona(username);

            // Almacena la información básica en la sesión
            HttpSession session = request.getSession();
            session.setAttribute("persona", persona);

            // Redirige al usuario a la página de información
            response.sendRedirect("informacion.jsp");
        } else {
            // Redirige al usuario de nuevo a la página de inicio de sesión con un mensaje de error
            response.sendRedirect("login.jsp?error=true");
        }
    }

    // Simulación: Método para validar las credenciales en tu base de datos
    boolean validarCredenciales(String username, String password) {
        // Aquí implementa la lógica real de validación en tu base de datos
        // Retorna true si las credenciales son válidas, de lo contrario, false
        return false;
    }

    // Simulación: Método para obtener la información de la persona desde la base de datos
    private Persona obtenerInformacionPersona(String username) {
        // Aquí implementa la lógica real para obtener la información de la persona desde la base de datos
        // Retorna una instancia de Persona con la información correspondiente
        Persona persona = new Persona();
        persona.setRut("12345678-9");
        persona.setNombre("John");
        persona.setApellido("Doe");
        return persona;
    }
}
